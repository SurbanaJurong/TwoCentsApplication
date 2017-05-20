package com.mrawesome.twocents.communication.request;

import com.mrawesome.twocents.data.Profile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mrawesome on 14/5/17.
 */

public class InterestEditRequest extends Request {

    private String username;
    private Set<String> interests = new HashSet<>();

    InterestEditRequest(ArrayList<String> interests) {
        this.username = Profile.getInstance().getUsername();
        this.interests.addAll(interests);
    }

    @Override
    public RequestType type() {
        return RequestType.InterestEdit;
    }

    @Override
    public String getRequestParams() {
        append(RequestFactory.p_username, username);
        append(RequestFactory.p_interests, interests);
        return stringBuilder.toString();
    }
}
