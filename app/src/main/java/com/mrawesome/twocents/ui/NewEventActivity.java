package com.mrawesome.twocents.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gc.materialdesign.views.ButtonFlat;
import com.mrawesome.twocents.R;
import com.mrawesome.twocents.fragment.addevent.NewEventFragment1;
import com.mrawesome.twocents.fragment.addevent.NewEventFragment2;
import com.mrawesome.twocents.fragment.addevent.NewEventFragment3;
import com.mrawesome.twocents.fragment.addevent.NewEventFragment4;
import com.mrawesome.twocents.fragment.onboarding.OnboardingFragment1;
import com.mrawesome.twocents.fragment.onboarding.OnboardingFragment2;
import com.mrawesome.twocents.fragment.onboarding.OnboardingFragment3;
import com.mrawesome.twocents.fragment.onboarding.OnboardingFragment4;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

public class NewEventActivity extends FragmentActivity implements NewEventFragment1.OnFragmentInteractionListener, NewEventFragment2.OnFragmentInteractionListener, NewEventFragment3.OnListFragmentInteractionListener, NewEventFragment4.OnFragmentInteractionListener {

    private static final String TAG = NewEventActivity.class.getSimpleName();

    private ViewPager viewPager;
    private SmartTabLayout smartTabLayout;
    private ButtonFlat back;
    private ButtonFlat next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);
        viewPager = (ViewPager) findViewById(R.id.add_event_view_pager);
        smartTabLayout = (SmartTabLayout) findViewById(R.id.add_event_tab_view);
        back = (ButtonFlat) findViewById(R.id.add_event_back);
        back.setVisibility(View.GONE);
        next = (ButtonFlat) findViewById(R.id.add_event_next);
        FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return new NewEventFragment1();
                    case 1:
                        return new NewEventFragment2();
                    case 2:
                        return new NewEventFragment3();
                    case 3:
                        return new NewEventFragment4();
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
                if(viewPager.getCurrentItem() == 3) { // The last screen
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
                } else if (position == 3) {
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
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onNewEvent3UserListFragmentInteraction() {

    }

    @Override
    public void onNewEvent1FragmentInteraction(Uri uri) {

    }

    @Override
    public void onNewEvent2FragmentInteraction(Uri uri) {

    }

    @Override
    public void onNewEvent4FragmentInteraction(Uri uri) {

    }
}
