package com.mrawesome.twocents.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mrawesome.twocents.Configuration;
import com.mrawesome.twocents.R;
import com.mrawesome.twocents.communication.ApiEndpointInterface;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView responseView;
    private Gson gson = new GsonBuilder().create();
    private OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
    private ApiEndpointInterface apiEndpointInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        responseView = (TextView) findViewById(R.id.textView2);
        SharedPreferences preferences =  getSharedPreferences("my_preferences", MODE_PRIVATE);
        apiEndpointInterface = new Retrofit.Builder().baseUrl(Configuration.SERVER_DOMAIN).addConverterFactory(GsonConverterFactory.create(gson)).callFactory(httpClientBuilder.build()).build().create(ApiEndpointInterface.class);

        if (true) {
//        if (!preferences.getBoolean("onboarding_complete",false)) {
            Intent onboarding = new Intent(this, OnboardingActivity.class);
            startActivity(onboarding);
            finish();
            return;
        }
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
        apiEndpointInterface.testGetApi().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                if (response.isSuccessful()) {
                    responseView.setText(response.body());
                } else {
                    responseView.setText(response.message());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                responseView.setText(t.getMessage());
            }
        });
    }

}
