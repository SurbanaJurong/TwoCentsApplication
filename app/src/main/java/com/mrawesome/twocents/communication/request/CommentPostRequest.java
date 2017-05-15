package com.mrawesome.twocents.communication.request;

import com.mrawesome.twocents.Profile;
import com.mrawesome.twocents.util.StreamReader;

/**
 * Created by mrawesome on 14/5/17.
 */

public class CommentPostRequest implements Request {

    private String username;
    private String eventId;
    private String comment;

    public CommentPostRequest(String eventId, String comment) {
        this.eventId = eventId;
        this.username = Profile.getInstance().getUsername();
        StreamReader.collapse(comment);
        this.comment = comment;

    }
    @Override
    public RequestType type() {
        return RequestType.CommentPost;
    }

    @Override
    public String getRequestParams() {
        return null;
    }
}
