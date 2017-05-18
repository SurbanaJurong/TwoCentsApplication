package com.mrawesome.twocents.ui;

import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mrawesome.twocents.R;
import com.mrawesome.twocents.communication.CommModule;
import com.mrawesome.twocents.communication.request.Request;
import com.mrawesome.twocents.communication.request.RequestFactory;
import com.mrawesome.twocents.communication.request.RequestType;
import com.mrawesome.twocents.communication.response.Response;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private TextView responseView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        responseView = (TextView) findViewById(R.id.textView2);
    }

    public void toProfileTest(View view) {
        Intent intent = new Intent(this, ProfileTestActivity.class);
        startActivity(intent);
    }

    public void toEventTest(View view) {
        Intent intent = new Intent(this, EventTestActivity.class);
        startActivity(intent);
    }

    public void testUserSuggestion(View view) {
        try {
            Response response = CommModule.sendRequest(RequestType.UserSuggestion, null);
            responseView.setText(response.payload);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
