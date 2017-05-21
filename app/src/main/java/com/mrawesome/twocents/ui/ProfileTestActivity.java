package com.mrawesome.twocents.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.mrawesome.twocents.Configuration;
import com.mrawesome.twocents.R;
import com.mrawesome.twocents.communication.ApiEndpointInterface;
import com.mrawesome.twocents.data.persistent.Interest;
import com.mrawesome.twocents.data.persistent.Profile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileTestActivity extends AppCompatActivity {

    private TextView responseView;
    private Gson gson = new GsonBuilder().create();
    private OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
    private ApiEndpointInterface apiEndpointInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_test);
        responseView = (TextView) findViewById(R.id.textView);
        apiEndpointInterface = new Retrofit.Builder().baseUrl(Configuration.SERVER_DOMAIN).addConverterFactory(GsonConverterFactory.create(gson)).callFactory(httpClientBuilder.build()).build().create(ApiEndpointInterface.class);

    }

    public void testProfileCreate(View view) {
        apiEndpointInterface.insertUserProfile(Profile.getInstance()).enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {

            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {

            }
        });
    }

    public void testProfileEdit(View view) {
        apiEndpointInterface.insertUserProfile(Profile.getInstance()).enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {

            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {

            }
        });
    }

    public void testInterestEdit(View view) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("userId", "u123123");
        jsonObject.addProperty("interestId", "i123123");
        apiEndpointInterface.registerInterest(jsonObject).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }

    public void testUserBookmark(View view) {
        apiEndpointInterface.insertUserProfile(Profile.getInstance()).enqueue(new Callback<Profile>() {
            @Override
            public void onResponse(Call<Profile> call, Response<Profile> response) {

            }

            @Override
            public void onFailure(Call<Profile> call, Throwable t) {

            }
        });
    }
}
