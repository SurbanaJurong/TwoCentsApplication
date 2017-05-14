package com.mrawesome.twocents.communication.request;

import com.mrawesome.twocents.Profile;

/**
 * Created by mrawesome on 14/5/17.
 */

public class UserSuggestionRequest implements Request {

    private String username;

    UserSuggestionRequest() {
        this.username = Profile.getInstance().getUsername();
    }

    @Override
    public RequestType type() {
        return RequestType.UserSuggestion;
    }

    @Override
    public String getRequestParams() {
        return null;
    }
}
