package com.mrawesome.twocents.data.persistent;

/**
 * Created by mrawesome on 16/5/17.
 */

public interface Flattenable {
    String DELIM = " ";
    StringBuilder flatten();
}
