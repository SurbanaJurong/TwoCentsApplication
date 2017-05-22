package com.mrawesome.twocents.fragment.onboarding;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrawesome.twocents.R;

/**
 * Created by mrawesome on 20/5/17.
 */

public class OnboardingFragment1 extends Fragment {

    private static final String TAG = OnboardingFragment1.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle s) {
        return inflater.inflate(R.layout.onboarding_screen1, container, false);
    }
}
