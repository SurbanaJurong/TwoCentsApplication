package com.mrawesome.twocents.data.persistent;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by mrawesome on 14/5/17.
 */

public class Interest extends RealmObject {

    @PrimaryKey
    @SerializedName("Id")
    private int id;
    @SerializedName("Name")
    private String name;
    @SerializedName("Icon")
    private String icon;

    public Interest() {}

    @Override
    public String toString() {
        return id + "|" + name + "|" + icon;
    }

    public Interest(String subject, String icon) {
        this.name = subject;
        this.icon = icon;
    }

    public String getName() {
        return this.name;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
