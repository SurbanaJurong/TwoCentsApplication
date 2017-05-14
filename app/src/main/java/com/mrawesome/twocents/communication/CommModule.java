package com.mrawesome.twocents.communication;

import android.os.Bundle;

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
import java.net.URL;

/**
 * Created by mrawesome on 14/5/17.
 */

public class CommModule {
    public static Response sendRequest(RequestType requestType, Bundle payload) throws IOException {
        Request request = RequestFactory.newRequest(requestType, payload);
        URL url = new URL(Configuration.SERVER_DOMAIN + request.getRequestParams());
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            return ResponseFactory.newResponse(in);
        } catch (IOException e) {
            return new NullResponse();
        } finally {
            urlConnection.disconnect();
        }
    }
}
