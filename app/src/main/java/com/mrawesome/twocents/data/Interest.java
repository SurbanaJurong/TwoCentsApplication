package com.mrawesome.twocents.data;

/**
 * Created by mrawesome on 14/5/17.
 */

public class Interest implements Flattenable {

    private String subject;

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
