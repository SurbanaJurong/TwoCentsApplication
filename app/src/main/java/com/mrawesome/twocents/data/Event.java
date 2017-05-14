package com.mrawesome.twocents.data;

/**
 * Created by mrawesome on 14/5/17.
 */

public class Event {
    /**
     * Created by mrawesome on 14/5/17.
     */

    public enum EventMode {
        Recurring(0), OneTime(1);

        private int code;

        EventMode(int code) {
            this.code = code;
        }

        public int getCode() {
            return this.code;
        }

        public static EventMode valueOf(int code) {
            return code == 0 ? Recurring : OneTime;
        }
    }
}
