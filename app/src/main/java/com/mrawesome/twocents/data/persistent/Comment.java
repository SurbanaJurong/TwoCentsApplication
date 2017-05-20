package com.mrawesome.twocents.data.persistent;

import io.realm.RealmObject;

/**
 * Created by mrawesome on 14/5/17.
 */

public class Comment extends RealmObject implements Flattenable {

    private int seqNum;
    private String sender;
    private String comment;

    public Comment() {}

    public Comment(String sender, String comment) {
        this.sender = sender;
        this.comment = comment;
    }

    @Override
    public StringBuilder flatten() {
        return new StringBuilder().append(sender).append(DELIM).append(comment);
    }
}
