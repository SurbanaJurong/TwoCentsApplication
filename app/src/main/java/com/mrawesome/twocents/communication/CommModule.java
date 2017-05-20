package com.mrawesome.twocents.communication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.mrawesome.twocents.Configuration;
import com.mrawesome.twocents.communication.request.Request;
import com.mrawesome.twocents.communication.request.RequestFactory;
import com.mrawesome.twocents.communication.request.RequestType;
import com.mrawesome.twocents.communication.response.NullResponse;
import com.mrawesome.twocents.communication.response.Response;
import com.mrawesome.twocents.communication.response.ResponseFactory;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by mrawesome on 14/5/17.
 */

public class CommModule {

    private static final String TAG = "CommModule";

    public static Response sendRequest(RequestType requestType, Bundle payload) throws IOException {
        Request request = RequestFactory.newRequest(requestType, payload);
        URL url = new URL(Configuration.SERVER_DOMAIN + request.getRequestParams());
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            return ResponseFactory.newResponse(in);
        } catch (IOException e) {
            Response response = new NullResponse();
            response.payload = "IO Exception";
            Log.d(TAG, e.getMessage());
            return response;
        } finally {
            urlConnection.disconnect();
        }
    }

    public static Response sendRequest(String address) throws IOException {
        URL url = new URL(address);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            return ResponseFactory.newResponse(in);
        } catch (IOException e) {
            Response response = new NullResponse();
            response.payload = "IO Exception";
            Log.d(TAG, e.getMessage());
            return response;
        } finally {
            urlConnection.disconnect();
        }
    }

}
