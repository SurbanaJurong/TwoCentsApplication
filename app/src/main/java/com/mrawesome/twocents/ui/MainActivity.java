package com.mrawesome.twocents.ui;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.mrawesome.twocents.R;
import com.mrawesome.twocents.fragment.main.EventFragment;
import com.mrawesome.twocents.fragment.main.NotificationFragment;
import com.mrawesome.twocents.fragment.main.TodayFragment;

public class MainActivity extends AppCompatActivity implements TodayFragment.OnListFragmentInteractionListener, EventFragment.OnListFragmentInteractionListener, NotificationFragment.OnListFragmentInteractionListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Fragment fragment;
    private android.support.v4.app.FragmentManager fragmentManager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_today_view:
                    fragment = TodayFragment.newInstance();
                    break;
                case R.id.navigation_event_view:
                    fragment = EventFragment.newInstance();
                    break;
                case R.id.navigation_notifications:
                    fragment = NotificationFragment.newInstance();
                    break;
                case R.id.navigation_profile_view:
                    fragment = TodayFragment.newInstance();
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

//        SharedPreferences preferences =  getSharedPreferences("my_preferences", MODE_PRIVATE);
//
//        if (false) {
////        if (!preferences.getBoolean("onboarding_complete",false)) {
//            Intent onboarding = new Intent(this, OnboardingActivity.class);
//            startActivity(onboarding);
//            finish();
//            return;
//        }
//        Intent addInterest = new Intent(this, AddInterestActivity.class);
//        startActivity(addInterest);
//        finish();
//        return;
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
}
