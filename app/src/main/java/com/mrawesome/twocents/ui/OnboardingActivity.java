package com.mrawesome.twocents.ui;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gc.materialdesign.views.ButtonFlat;
import com.mrawesome.twocents.R;
import com.mrawesome.twocents.fragment.OnboardingFragment1;
import com.mrawesome.twocents.fragment.OnboardingFragment2;
import com.mrawesome.twocents.fragment.OnboardingFragment3;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

public class OnboardingActivity extends FragmentActivity {

    private ViewPager viewPager;
    private SmartTabLayout smartTabLayout;
    private ButtonFlat back;
    private ButtonFlat next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        smartTabLayout = (SmartTabLayout) findViewById(R.id.indicator);
        back = (ButtonFlat) findViewById(R.id.back);
        back.setVisibility(View.GONE);
        next = (ButtonFlat) findViewById(R.id.next);
        FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public android.support.v4.app.Fragment getItem(int position) {
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
