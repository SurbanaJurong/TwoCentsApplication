package com.mrawesome.twocents.communication.request;

import com.mrawesome.twocents.data.Profile;

/**
 * Created by mrawesome on 14/5/17.
 */

public class UserBookmarkRequest extends Request {

    private String username;
    private String targetUsername;

    UserBookmarkRequest(String targetUsername) {
        this.username = Profile.getInstance().getUsername();
        this.targetUsername = targetUsername;
    }

    @Override
    public RequestType type() {
        return RequestType.UserBookmark;
    }

    @Override
    public String getRequestParams() {
        append(RequestFactory.p_username, username);
        append(RequestFactory.p_username, targetUsername);
        return stringBuilder.toString();
    }
}
