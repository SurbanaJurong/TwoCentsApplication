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
import com.mrawesome.twocents.data.enumerate.EventMode;
import com.mrawesome.twocents.data.persistent.Comment;
import com.mrawesome.twocents.data.persistent.Event;
import com.mrawesome.twocents.data.persistent.Profile;

import java.io.IOException;
import java.util.Set;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EventTestActivity extends AppCompatActivity {

    private static final String TAG = EventTestActivity.class.getSimpleName();

    private TextView responseView;
    private Gson gson = new GsonBuilder().create();
    private OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
    private ApiEndpointInterface apiEndpointInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_test);
        responseView = (TextView) findViewById(R.id.textView3);
        apiEndpointInterface = new Retrofit.Builder().baseUrl(Configuration.SERVER_DOMAIN).addConverterFactory(GsonConverterFactory.create(gson)).callFactory(httpClientBuilder.build()).build().create(ApiEndpointInterface.class);

    }

    public void testAttendanceMark(View view) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("userId", "u123123");
        jsonObject.addProperty("eventId", "e123123");
        apiEndpointInterface.markParticipation(jsonObject).enqueue(new Callback<Event>() {
            @Override
            public void onResponse(Call<Event> call, Response<Event> response) {

            }

            @Override
            public void onFailure(Call<Event> call, Throwable t) {

            }
        });
    }

    public void testCalendarRefresh(View view) {
        apiEndpointInterface.getEventByUser(Profile.getInstance().getUsername()).enqueue(new Callback<Set<Event>>() {
            @Override
            public void onResponse(Call<Set<Event>> call, Response<Set<Event>> response) {

            }

            @Override
            public void onFailure(Call<Set<Event>> call, Throwable t) {

            }
        });
    }

    public void testCommentPost(View view) {
        apiEndpointInterface.postComment(new Comment()).enqueue(new Callback<Set<Comment>>() {
            @Override
            public void onResponse(Call<Set<Comment>> call, Response<Set<Comment>> response) {

            }

            @Override
            public void onFailure(Call<Set<Comment>> call, Throwable t) {

            }
        });
    }

    public void testEventCreate(View view) {
        apiEndpointInterface.insertEvent(new Event()).enqueue(new Callback<Event>() {
            @Override
            public void onResponse(Call<Event> call, Response<Event> response) {

            }

            @Override
            public void onFailure(Call<Event> call, Throwable t) {

            }
        });
    }

    public void testEventEdit(View view) {
        apiEndpointInterface.insertEvent(new Event()).enqueue(new Callback<Event>() {
            @Override
            public void onResponse(Call<Event> call, Response<Event> response) {

            }

            @Override
            public void onFailure(Call<Event> call, Throwable t) {

            }
        });
    }

    public void testEventBookmark(View view) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("userId", "u123123");
        jsonObject.addProperty("eventId", "e123123");
        apiEndpointInterface.bookmarkEvent(jsonObject).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });
    }

    public void testEventTimeEdit(View view) {
        apiEndpointInterface.insertEvent(new Event()).enqueue(new Callback<Event>() {
            @Override
            public void onResponse(Call<Event> call, Response<Event> response) {

            }

            @Override
            public void onFailure(Call<Event> call, Throwable t) {

            }
        });
    }

    public void testEventVenueEdit(View view) {
        apiEndpointInterface.insertEvent(new Event()).enqueue(new Callback<Event>() {
            @Override
            public void onResponse(Call<Event> call, Response<Event> response) {

            }

            @Override
            public void onFailure(Call<Event> call, Throwable t) {

            }
        });
    }

    public void testSwitchRecur(View view) {
        apiEndpointInterface.insertEvent(new Event()).enqueue(new Callback<Event>() {
            @Override
            public void onResponse(Call<Event> call, Response<Event> response) {

            }

            @Override
            public void onFailure(Call<Event> call, Throwable t) {

            }
        });
    }
}
