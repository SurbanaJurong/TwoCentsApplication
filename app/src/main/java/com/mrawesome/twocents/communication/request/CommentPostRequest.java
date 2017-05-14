package com.mrawesome.twocents.communication.request;

import com.mrawesome.twocents.Profile;

/**
 * Created by mrawesome on 14/5/17.
 */

public class CommentPostRequest implements Request {

    private String username;
    private String eventId;
    private String comment;

    public CommentPostRequest(String eventId, String comment) {
        this.username = Profile.getInstance().getUsername();
        this.eventId = eventId;
        comment.replace(" ", "|");
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
