package com.mrawesome.twocents;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by mrawesome on 18/5/17.
 */

public class TwoCents extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
