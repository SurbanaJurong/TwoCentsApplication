package com.mrawesome.twocents.data;

import com.mrawesome.twocents.util.StreamReader;

/**
 * Created by mrawesome on 14/5/17.
 */

public class Comment implements Flattenable {

    private String sender;
    private String comment;

    public Comment(String sender, String comment) {
        this.sender = sender;
        StreamReader.expand(comment);
        this.comment = comment;
    }

    @Override
    public StringBuilder flatten() {
        return new StringBuilder().append(sender).append(DELIM).append(comment);
    }
}
