package com.mrawesome.twocents.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;

import com.gc.materialdesign.views.ButtonFlat;
import com.mrawesome.twocents.R;
import com.mrawesome.twocents.fragment.onboarding.OnboardingFragment1;
import com.mrawesome.twocents.fragment.onboarding.OnboardingFragment2;
import com.mrawesome.twocents.fragment.onboarding.OnboardingFragment3;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

public class OnboardingActivity extends FragmentActivity {

    private static final String TAG = OnboardingActivity.class.getSimpleName();

    private ViewPager viewPager;
    private SmartTabLayout smartTabLayout;
    private ButtonFlat back;
    private ButtonFlat next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        viewPager = (ViewPager) findViewById(R.id.onboarding_view_pager);
        smartTabLayout = (SmartTabLayout) findViewById(R.id.onboarding_tab_view);
        back = (ButtonFlat) findViewById(R.id.onboarding_back);
        back.setVisibility(View.GONE);
        next = (ButtonFlat) findViewById(R.id.onboarding_next);
        FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new OnboardingFragment1();
                    case 1:
                        return new OnboardingFragment2();
                    case 2:
                        return new OnboardingFragment3();
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
                if(viewPager.getCurrentItem() == 2) { // The last screen
                    finishOnboarding();
                } else {
                    viewPager.setCurrentItem(
                            viewPager.getCurrentItem() + 1,
                            true
                    );
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

    private void finishOnboarding() {
        SharedPreferences preferences = getSharedPreferences("my_preferences", MODE_PRIVATE);
        preferences.edit().putBoolean("onboarding_complete", true).apply();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
