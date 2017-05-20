package com.mrawesome.twocents.data.persistent;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mrawesome on 14/5/17.
 */

public class Interest extends RealmObject implements Flattenable {

    @PrimaryKey
    private String subject;

    public Interest() {}

    public Interest(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return this.subject;
    }

    @Override
    public StringBuilder flatten() {
        return new StringBuilder().append(subject);
    }
}
