package com.mrawesome.twocents.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.gc.materialdesign.views.ButtonFlat;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mrawesome.twocents.Configuration;
import com.mrawesome.twocents.R;
import com.mrawesome.twocents.communication.ApiEndpointInterface;
import com.mrawesome.twocents.communication.CommModule;
import com.mrawesome.twocents.data.persistent.Event;
import com.mrawesome.twocents.data.persistent.Interest;
import com.mrawesome.twocents.ui.fragment.addInterest.AddInterestFragment1;
import com.mrawesome.twocents.ui.fragment.addInterest.AddInterestFragment2;
import com.mrawesome.twocents.ui.fragment.addInterest.AddInterestFragment3;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import io.realm.Realm;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.widget.Toast.LENGTH_SHORT;

public class AddInterestActivity extends AppCompatActivity implements AddInterestFragment1.OnListFragmentInteractionListener {

    private static final String TAG = AddInterestActivity.class.getSimpleName();

    private ViewPager viewPager;
    private SmartTabLayout smartTabLayout;
    private ButtonFlat back;
    private ButtonFlat next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_interest);
        viewPager = (ViewPager) findViewById(R.id.add_interest_view_pager);
        smartTabLayout = (SmartTabLayout) findViewById(R.id.add_interest_tab_view);
        back = (ButtonFlat) findViewById(R.id.add_interest_back);
        back.setVisibility(View.GONE);
        next = (ButtonFlat) findViewById(R.id.add_interest_next);
        final FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return AddInterestFragment1.newInstance();
                    case 1:
                        return AddInterestFragment2.newInstance();
                    case 2:
                        return AddInterestFragment3.newInstance();
                    default:
                        return null;
                }
            }

            @Override
            public int getCount() {
                return 3;
            }
        };
        viewPager.setAdapter(adapter);
        smartTabLayout.setViewPager(viewPager);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewPager.getCurrentItem() > 0) {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() - 1, true);
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentIndex = viewPager.getCurrentItem();
                switch (currentIndex) {
                    case 0:
                        AddInterestFragment1 fragment1 = (AddInterestFragment1) adapter.getItem(0);
                        Set<Interest> interests = fragment1.getSelectedInterest();
                        List<Event> events = fetchEvent(interests);
                        AddInterestFragment2 fragment2 = (AddInterestFragment2) adapter.getItem(1);
                        fragment2.setEvents(events);
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
                        break;
                    case 1:
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
                        break;
                    case 2:
                        finishAddInterest();
                }
            }
        });
        smartTabLayout.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    back.setVisibility(View.GONE);
                } else if (position == 2) {
                    back.setVisibility(View.GONE);
                    next.setText("Done");
                } else {
                    back.setVisibility(View.VISIBLE);
                    next.setText("Next");
                }
            }
        });
    }

    private List<Event> fetchEvent(Set<Interest> interests) {
        ApiEndpointInterface apiEndpointInterface = CommModule.getApiEndpointExpose();
        final List<Event> events = new ArrayList<>();
        for (Interest interest : interests) {
            apiEndpointInterface.getEventByInterest(interest.getId()).enqueue(new Callback<List<Event>>() {
                @Override
                public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                    if (response.isSuccessful()) {
                        synchronized (events) {
                            events.addAll(response.body());
                        }
                        makeToast(R.string.toast_request_success);
                    } else {
                        makeToast(R.string.toast_request_unsuccess);
                    }
                }

                @Override
                public void onFailure(Call<List<Event>> call, Throwable t) {
                    Log.d(TAG, call.request().url().toString());
                    makeToast(R.string.toast_request_fail);
                }
            });
        }
        return events;
    }

    private void makeToast(int resId) {
        Toast.makeText(this, resId, LENGTH_SHORT).show();
    }

    private void makeToast(String msg) {
        Toast.makeText(this, msg, LENGTH_SHORT).show();
    }


    private void finishAddInterest() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onInterestListFragmentInteraction() {

    }
}
