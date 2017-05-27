package com.mrawesome.twocents.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.mrawesome.twocents.R;
import com.mrawesome.twocents.communication.ApiEndpointInterface;
import com.mrawesome.twocents.communication.CommModule;
import com.mrawesome.twocents.data.persistent.Event;
import com.mrawesome.twocents.data.persistent.Interest;
import com.mrawesome.twocents.ui.fragment.main.EventFragment;
import com.mrawesome.twocents.ui.fragment.main.NotificationFragment;
import com.mrawesome.twocents.ui.fragment.main.TodayFragment;
import com.mrawesome.twocents.ui.fragment.main.YourEventFragment;

import java.util.List;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity implements YourEventFragment.OnListFragmentInteractionListener, EventFragment.OnListFragmentInteractionListener, NotificationFragment.OnListFragmentInteractionListener, TodayFragment.OnFragmentInteractionListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Fragment fragment;
    private android.support.v4.app.FragmentManager fragmentManager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_today_view:
                    fragment = TodayFragment.newInstance(null, null);
                    break;
                case R.id.navigation_event_view:
                    fragment = EventFragment.newInstance();
                    break;
                case R.id.navigation_notifications:
                    fragment = NotificationFragment.newInstance();
                    break;
                case R.id.navigation_your_event:
                    fragment = YourEventFragment.newInstance();
                    break;
            }
            final FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.content, fragment).commit();
            return true;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        fragmentManager = getSupportFragmentManager();
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_today_view);
        fetchInterest();
        fetchEvent();

        SharedPreferences preferences =  getSharedPreferences("my_preferences", MODE_PRIVATE);

        if (!preferences.getBoolean("onboarding_complete",false)) {
            Intent intent = new Intent(this, OnboardingActivity.class);
            startActivity(intent);
            finish();
            return;
        }
    }

    private void fetchInterest() {
        ApiEndpointInterface apiEndpointInterface = CommModule.getApiEndpointExpose();
        apiEndpointInterface.getAllInterests().enqueue(new Callback<List<Interest>>() {
            @Override
            public void onResponse(Call<List<Interest>> call, Response<List<Interest>> response) {
                Log.d(TAG, response.body().toString());
                if (response.isSuccessful()) {
                    writeToLocal(response.body());
                    makeToast(R.string.toast_request_success);
                } else {
                    makeToast(R.string.toast_request_unsuccess);
                }
            }

            @Override
            public void onFailure(Call<List<Interest>> call, Throwable t) {
                makeToast(R.string.toast_request_fail);
            }
        });
    }

    private void fetchEvent() {
        ApiEndpointInterface apiEndpointInterface = CommModule.getApiEndpointExpose();
        apiEndpointInterface.getAllEvents().enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                if (response.isSuccessful()) {
                    writeToLocal(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {

            }
        });
    }

    private void writeToLocal(final List list) {
        Realm realm = Realm.getDefaultInstance();
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.insertOrUpdate(list);
                }
            });
        Log.d(TAG, "Write interests to local successfully");
    }

    private void makeToast(int resId) {
        Toast.makeText(this, resId, LENGTH_SHORT).show();
    }

    private void makeToast(String msg) {
        Toast.makeText(this, msg, LENGTH_SHORT).show();
    }


    @Override
    public void onEventListFragmentInteraction() {

    }

    @Override
    public void onNotificationListFragmentInteraction() {

    }

    @Override
    public void onTodayListFragmentInteraction() {

    }

    @Override
    public void onTodayFragmentInteraction(Uri uri) {

    }
}
