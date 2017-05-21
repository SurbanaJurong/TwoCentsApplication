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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences preferences =  getSharedPreferences("my_preferences", MODE_PRIVATE);

//        if (true) {
        if (!preferences.getBoolean("onboarding_complete",false)) {
            Intent onboarding = new Intent(this, OnboardingActivity.class);
            startActivity(onboarding);
            finish();
            return;
        }
        Intent addInterest = new Intent(this, AddInterestActivity.class);
        startActivity(addInterest);
        finish();
        return;
    }

}
