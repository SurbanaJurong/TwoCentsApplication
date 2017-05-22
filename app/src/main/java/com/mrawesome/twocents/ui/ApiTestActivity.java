package com.mrawesome.twocents.ui;

import android.content.Intent;
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

public class ApiTestActivity extends AppCompatActivity {

    private static final String TAG = ApiTestActivity.class.getSimpleName();

    private TextView responseView;
    private Gson gson = new GsonBuilder().create();
    private OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
    private ApiEndpointInterface apiEndpointInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_test);
        responseView = (TextView) findViewById(R.id.textView2);
        apiEndpointInterface = new Retrofit.Builder().baseUrl(Configuration.SERVER_DOMAIN).addConverterFactory(GsonConverterFactory.create(gson)).callFactory(httpClientBuilder.build()).build().create(ApiEndpointInterface.class);
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
