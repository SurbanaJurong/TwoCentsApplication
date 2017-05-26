package com.mrawesome.twocents.ui.fragment.onboarding;

import android.content.Context;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.mrawesome.twocents.R;

/**
 * Created by mrawesome on 20/5/17.
 */

public class OnboardingFragment3 extends Fragment {

    private static final String TAG = OnboardingFragment3.class.getSimpleName();

    private static OnboardingFragment3 fragment = null;

    private EditText otpField;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle s) {
        Log.d(TAG, "Creating view, assigning OTP field");
        View view = inflater.inflate(R.layout.onboarding_screen3, container, false);
        otpField = (EditText) view.findViewById(R.id.otp_field);
        return view;
    }

    private OnFragmentInteractionListener mListener;

    public OnboardingFragment3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment OnboardingFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static OnboardingFragment3 newInstance() {
        if (fragment == null) {
            fragment = new OnboardingFragment3();
        }
        return fragment;
    }

    public String getOtpField() {
        return otpField.getText().toString();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onOnboarding3FragmentInteraction(Uri uri);
    }
}
