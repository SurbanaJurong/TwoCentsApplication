package com.mrawesome.twocents.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gc.materialdesign.views.ButtonFlat;
import com.mrawesome.twocents.R;
import com.mrawesome.twocents.fragment.addInterest.AddInterestFragment1;
import com.mrawesome.twocents.fragment.addInterest.AddInterestFragment2;
import com.mrawesome.twocents.fragment.addInterest.AddInterestFragment3;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

public class AddInterestActivity extends AppCompatActivity {

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
        FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new AddInterestFragment1();
                    case 1:
                        return new AddInterestFragment2();
                    case 2:
                        return new AddInterestFragment3();
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
                if (viewPager.getCurrentItem() == 2) {
                    finishAddInterest();
                } else {
                    viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
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

    private void finishAddInterest() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
