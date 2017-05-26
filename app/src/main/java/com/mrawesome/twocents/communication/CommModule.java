package com.mrawesome.twocents.communication;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mrawesome.twocents.Configuration;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mrawesome on 26/5/17.
 */

public class CommModule {

    private CommModule() {}

    private static OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
    private static ApiEndpointInterface apiEndpointNoExpose;
    static {
        final GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        final Gson gson = builder.create();
        apiEndpointNoExpose = new Retrofit.Builder().baseUrl(Configuration.SERVER_DOMAIN).addConverterFactory(GsonConverterFactory.create(gson)).callFactory(httpClientBuilder.build()).build().create(ApiEndpointInterface.class);
    }

    private static ApiEndpointInterface apiEndpointExpose;
    static {
        final Gson gson = new GsonBuilder().create();
        apiEndpointExpose = new Retrofit.Builder().baseUrl(Configuration.SERVER_DOMAIN).addConverterFactory(GsonConverterFactory.create(gson)).callFactory(httpClientBuilder.build()).build().create(ApiEndpointInterface.class);
    }

    public static ApiEndpointInterface getApiEndpointNoExpose() {
        return apiEndpointNoExpose;
    }

    public static ApiEndpointInterface getApiEndpointExpose() {
        return apiEndpointExpose;
    }
}
