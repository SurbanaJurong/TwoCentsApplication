package com.mrawesome.twocents.data.persistent;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mrawesome on 14/5/17.
 */

public class Interest extends RealmObject implements Flattenable {

    @PrimaryKey
    private String subject;
    private String icon;

    public Interest() {}

    public Interest(String subject, String icon) {
        this.subject = subject;
        this.icon = icon;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getIcon() {
        return this.icon;
    }

    @Override
    public StringBuilder flatten() {
        return new StringBuilder().append(subject);
    }
}