package com.mrawesome.twocents.data;

import com.mrawesome.twocents.util.Reader;

/**
 * Created by mrawesome on 14/5/17.
 */

public class Comment {

    private String sender;
    private String comment;

    public Comment(String sender, String comment) {
        this.sender = sender;
        Reader.expand(comment);
        this.comment = comment;
    }
}
