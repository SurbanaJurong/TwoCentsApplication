package com.mrawesome.twocents.data.persistent;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mrawesome on 14/5/17.
 */

public class Comment extends RealmObject implements Flattenable {

    @PrimaryKey
    private int commentId;
    private int sender;
    private String comment;

    public Comment() {}

    public Comment(int sender, String comment) {
        this.sender = sender;
        this.comment = comment;
    }

    @Override
    public StringBuilder flatten() {
        return new StringBuilder().append(sender).append(DELIM).append(comment);
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isOwnComment() {
        return sender == Profile.getInstance().getUserId();
    }
}
