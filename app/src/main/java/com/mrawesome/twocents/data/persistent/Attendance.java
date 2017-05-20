package com.mrawesome.twocents.data.persistent;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by mrawesome on 20/5/17.
 */

public class Attendance extends RealmObject {

    @PrimaryKey
    @Required
    public String key;
    public Integer value;
}
