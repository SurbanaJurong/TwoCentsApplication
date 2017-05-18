package com.mrawesome.twocents.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mrawesome.twocents.R;
import com.mrawesome.twocents.communication.CommModule;
import com.mrawesome.twocents.communication.request.RequestFactory;
import com.mrawesome.twocents.communication.request.RequestType;
import com.mrawesome.twocents.communication.response.Response;
import com.mrawesome.twocents.data.Interest;
import com.mrawesome.twocents.util.BundleWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProfileTestActivity extends AppCompatActivity {

    private TextView responseView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_test);
        responseView = (TextView) findViewById(R.id.textView);
    }

    public void testProfileCreate(View view) {
        Bundle payload = BundleWriter.packProfileCreate("dummy_user", "83567597", "G1414362P", "400018", 1996);
        try {
            Response response = CommModule.sendRequest(RequestType.ProfileCreate, payload);
            responseView.setText(response.payload);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testProfileEdit(View view) {
        Bundle payload = BundleWriter.packProfileEdit("adwdfjxkaawdv", "86705571", "637124");
        try {
            Response response = CommModule.sendRequest(RequestType.ProfileEdit, payload);
            responseView.setText(response.payload);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testInterestEdit(View view) {
        Set<Interest> interests = new HashSet<>();
        interests.add(new Interest("football"));
        interests.add(new Interest("basketball"));
        Bundle payload = BundleWriter.packInterestEdit(interests);
        try {
            Response response = CommModule.sendRequest(RequestType.InterestEdit, payload);
            responseView.setText(response.payload);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testUserBookmark(View view) {
        Bundle payload = BundleWriter.packUserBookmark("target_dummy");
        try {
            Response response = CommModule.sendRequest(RequestType.UserBookmark, payload);
            responseView.setText(response.payload);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
