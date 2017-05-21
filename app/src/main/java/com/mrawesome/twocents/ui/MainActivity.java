package com.mrawesome.twocents.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.mrawesome.twocents.R;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_today_view:
                    mTextMessage.setText(R.string.title_today_view);
                    return true;
                case R.id.navigation_event_view:
                    mTextMessage.setText(R.string.title_event_view);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_profile_view:
                    mTextMessage.setText(R.string.title_profile_view);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
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

}
