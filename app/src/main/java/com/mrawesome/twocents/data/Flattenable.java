package com.mrawesome.twocents.data;

/**
 * Created by mrawesome on 16/5/17.
 */

public interface Flattenable {
    String DELIM = "|";
    StringBuilder flatten();
}
