package com.mrawesome.twocents.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.gc.materialdesign.views.ButtonFlat;
import com.google.gson.JsonObject;
import com.mrawesome.twocents.R;
import com.mrawesome.twocents.communication.ApiEndpointInterface;
import com.mrawesome.twocents.communication.CommModule;
import com.mrawesome.twocents.data.persistent.Profile;
import com.mrawesome.twocents.ui.fragment.onboarding.OnboardingFragment1;
import com.mrawesome.twocents.ui.fragment.onboarding.OnboardingFragment2;
import com.mrawesome.twocents.ui.fragment.onboarding.OnboardingFragment3;
import com.mrawesome.twocents.ui.fragment.onboarding.OnboardingFragment4;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.Toast.LENGTH_SHORT;

public class OnboardingActivity extends FragmentActivity implements OnboardingFragment2.OnFragmentInteractionListener, OnboardingFragment1.OnFragmentInteractionListener, OnboardingFragment3.OnFragmentInteractionListener, OnboardingFragment4.OnFragmentInteractionListener {

    private static final String TAG = OnboardingActivity.class.getSimpleName();

    private ViewPager viewPager;
    private SmartTabLayout smartTabLayout;
    private ButtonFlat back;
    private ButtonFlat next;
    private FragmentStatePagerAdapter adapter;
    private ApiEndpointInterface apiEndpointInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        viewPager = (ViewPager) findViewById(R.id.onboarding_view_pager);
        smartTabLayout = (SmartTabLayout) findViewById(R.id.onboarding_tab_view);
        back = (ButtonFlat) findViewById(R.id.onboarding_back);
        back.setVisibility(View.GONE);
        next = (ButtonFlat) findViewById(R.id.onboarding_next);
        adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return OnboardingFragment1.newInstance();
                    case 1:
                        return OnboardingFragment2.newInstance();
                    case 2:
                        return OnboardingFragment3.newInstance();
                    case 3:
                        return OnboardingFragment4.newInstance();
                    default:
                        return null;
                }
            }

            @Override
            public int getCount() {
                return 4;
            }
        };
        viewPager.setAdapter(adapter);
        smartTabLayout.setViewPager(viewPager);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewPager.getCurrentItem() > 0) { // The last screen
                    viewPager.setCurrentItem(
                            viewPager.getCurrentItem() - 1,
                            true
                    );
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentIndex = viewPager.getCurrentItem();
                switch (currentIndex) {
                    case 0:
                        OnboardingFragment1 fragment1 = (OnboardingFragment1) adapter.getItem(0);
                        fragment1.updateProfileData();
                        OnboardingFragment2 fragment2 = (OnboardingFragment2) adapter.getItem(1);
                        fragment2.setData();
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
                        break;
                    case 1:
                        sendCreateProfileRequest();
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
                        break;
                    case 2:
                        OnboardingFragment3 fragment3 = (OnboardingFragment3) adapter.getItem(2);
                        String otp = fragment3.getOtpField();
                        if (otp.equals("")) {
                            makeToast(R.string.toast_empty_otp);
                        } else {
                            sendOtpConfirmation(Integer.parseInt(otp));
                        }
                        break;
                    case 3:
                        finishOnboarding();
                }
            }
        });
        smartTabLayout.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    back.setVisibility(View.GONE);
                } else if (position == 3) {
                    back.setVisibility(View.GONE);
                    next.setText("Done");
                } else {
                    back.setVisibility(View.VISIBLE);
                    next.setText("Next");
                }
            }
        });
        apiEndpointInterface = CommModule.getApiEndpointNoExpose();
    }

    private void finishOnboarding() {
        SharedPreferences preferences = getSharedPreferences("my_preferences", MODE_PRIVATE);
        preferences.edit().putBoolean("onboarding_complete", true).apply();
        Intent intent = new Intent(this, AddInterestActivity.class);
        startActivity(intent);
        finish();
    }

    private void sendCreateProfileRequest() {
        Realm realm = Realm.getDefaultInstance();
        Profile profile = realm.where(Profile.class).findFirst();
        Log.d(TAG, profile.toString());
        apiEndpointInterface.insertUserProfile(profile).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    makeToast(R.string.toast_request_success);
                } else {
                    makeToast(R.string.toast_request_unsuccess);
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                makeToast(R.string.toast_request_fail);
            }
        });
    }

    private void sendOtpConfirmation(int otp) {
        Realm realm = Realm.getDefaultInstance();
        Profile profile = realm.where(Profile.class).findFirst();
        String username = profile.getUsername();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("username", username);
        jsonObject.addProperty("otp", otp);
        Log.d(TAG, jsonObject.toString());
        apiEndpointInterface.confirmOTP(jsonObject).enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "Success Request");
                    makeToast(R.string.toast_request_success);
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
                } else {
                    Log.d(TAG, "Unsuccess Request");
                    makeToast(R.string.toast_request_unsuccess);
                }
            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {
                Log.d(TAG, "Fail Request");
                makeToast(R.string.toast_request_fail);
            }
        });
    }

    private void makeToast(int resId) {
        Toast.makeText(this, resId, LENGTH_SHORT).show();
    }

    private void makeToast(String msg) {
        Toast.makeText(this, msg, LENGTH_SHORT).show();
    }

    @Override
    public void onOnboarding2FragmentInteraction(Uri uri) {

    }

    @Override
    public void onOnboarding3FragmentInteraction(Uri uri) {

    }

    @Override
    public void onOnboarding4FragmentInteraction(Uri uri) {

    }

    @Override
    public void onOnboarding1FragmentInteraction(Uri uri) {

    }
}
