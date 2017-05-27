package com.mrawesome.twocents.ui.fragment.addInterest;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrawesome.twocents.R;

/**
 * Created by mrawesome on 21/5/17.
 */

public class AddInterestFragment3 extends Fragment {

    private static final String TAG = AddInterestFragment3.class.getSimpleName();

    private static AddInterestFragment3 fragment = null;

    public AddInterestFragment3() {

    }

    public static AddInterestFragment3 newInstance() {
        if (fragment == null) {
            fragment = new AddInterestFragment3();
        }
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        return inflater.inflate(R.layout.add_interest_screen3, container, false);
    }
}