package com.mrawesome.twocents.data.persistent;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mrawesome on 14/5/17.
 */

public class Comment extends RealmObject implements Flattenable {

    @PrimaryKey
    private int commentId;
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
