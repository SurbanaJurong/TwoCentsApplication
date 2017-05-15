package com.mrawesome.twocents.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mrawesome.twocents.data.Flattenable;
import com.mrawesome.twocents.data.Venue;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by mrawesome on 16/5/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "database";
    private static final int DATABASE_VERSION = 1;

    // query keyword constants
    private static final String INTEGER = " INTEGER";
    private static final String TEXT = " TEXT";
    private static final String PK = " PRIMARY KEY";
    private static final String COMMA = ",";
    private static final String LBRAC = "(";
    private static final String RBRAC = ")";
    private static final String SPACE = " ";

    // table names in database
    private static final String TABLE_PROFILE = "profile";
    private static final String TABLE_EVENT = "events";
    private static final String TABLE_INTEREST = "interests";
    private static final String TABLE_NOTIFICATION = "notifications";
    private static final String TABLE_USER = "users";
    private static final String TABLE_VENUE = "venues";

    // attributes in profile
    private static final String P_USERNAME = "username";
    private static final String P_PROFILEPIC = "profilePic";
    private static final String P_PHONENUMBER = "phoneNumber";
    private static final String P_NRIC = "nric";
    private static final String P_POSTALCODE = "postalCode";
    private static final String P_YEAR = "year";
    private static final String P_DATECREATED = "dateCreated";
    private static final String P_INTERESTS = "interests";
    private static final String P_NOTIFICATIONS = "notifications";
    private static final String P_ATTENDANCES = "attendances";
    private static final String P_EVENTS = "events";
    private static final String P_USERS = "users";

    // attributes in event
    private static final String E_EVENTID = "eventId";
    private static final String E_HOST = "host";
    private static final String E_DESCRIPTION = "description";
    private static final String E_ISRECURRING = "isRecurring";
    private static final String E_VENUEID = "venueId";
    private static final String E_MIN = "minCapacity";
    private static final String E_MAX = "maxCapacity";
    private static final String E_USERREGISTERED = "userRegistered";
    private static final String E_PARTICIPANTS = "participants";
    private static final String E_CHAT = "chat";
    private static final String E_VENUESTATUS = "venueStatus";
    private static final String E_STARTTIME = "startTime";
    private static final String E_DURATION = "duration";

    // attributes in interest
    private static final String I_SUBJECT = "subject";

    // attributes in notification
    private static final String N_TYPE = "notificationType";
    private static final String N_SENDER = "sender";
    private static final String N_EVENTID = "eventId";

    // attributes in venue
    private static final String V_VENUEID = "venueId";
    private static final String V_NAME = "venueName";
    private static final String V_CATEGORY = "category";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE ";

        // create profile table
        StringBuilder pCreate = new StringBuilder().append(TABLE_PROFILE).append(LBRAC);
        pCreate.append(P_USERNAME).append(TEXT).append(PK).append(COMMA);
        pCreate.append(P_PROFILEPIC).append(TEXT).append(COMMA);
        pCreate.append(P_PHONENUMBER).append(TEXT).append(COMMA);
        pCreate.append(P_NRIC).append(TEXT).append(COMMA);
        pCreate.append(P_POSTALCODE).append(TEXT).append(COMMA);
        pCreate.append(P_YEAR).append(INTEGER).append(COMMA);
        pCreate.append(P_DATECREATED).append(INTEGER).append(COMMA);
        pCreate.append(P_INTERESTS).append(TEXT).append(COMMA);
        pCreate.append(P_NOTIFICATIONS).append(TEXT).append(COMMA);
        pCreate.append(P_ATTENDANCES).append(TEXT).append(COMMA);
        pCreate.append(P_EVENTS).append(TEXT).append(COMMA);
        pCreate.append(P_USERS).append(TEXT).append(RBRAC);
        db.execSQL(createTable + pCreate);

        // create event table
        StringBuilder eCreate = new StringBuilder().append(TABLE_EVENT).append(LBRAC);
        eCreate.append(E_EVENTID).append(TEXT).append(PK).append(COMMA);
        eCreate.append(E_HOST).append(TEXT).append(COMMA);
        eCreate.append(P_PROFILEPIC).append(TEXT).append(COMMA);
        eCreate.append(E_DESCRIPTION).append(TEXT).append(COMMA);
        eCreate.append(E_ISRECURRING).append(INTEGER).append(COMMA);
        eCreate.append(P_DATECREATED).append(INTEGER).append(COMMA);
        eCreate.append(E_VENUEID).append(TEXT).append(COMMA);
        eCreate.append(E_MIN).append(INTEGER).append(COMMA);
        eCreate.append(E_MAX).append(INTEGER).append(COMMA);
        eCreate.append(E_USERREGISTERED).append(TEXT).append(COMMA);
        eCreate.append(E_PARTICIPANTS).append(TEXT).append(COMMA);
        eCreate.append(E_CHAT).append(TEXT).append(COMMA);
        eCreate.append(E_VENUESTATUS).append(INTEGER).append(COMMA);
        eCreate.append(E_STARTTIME).append(INTEGER).append(COMMA);
        eCreate.append(E_DURATION).append(INTEGER).append(RBRAC);
        db.execSQL(createTable + eCreate);

        // create interest table
        StringBuilder iCreate = new StringBuilder().append(TABLE_INTEREST).append(LBRAC);
        iCreate.append(I_SUBJECT).append(TEXT).append(PK).append(RBRAC);
        db.execSQL(createTable + iCreate);

        // create notification table
        StringBuilder nCreate = new StringBuilder().append(TABLE_NOTIFICATION).append(LBRAC);
        nCreate.append(N_TYPE).append(INTEGER).append(PK).append(COMMA);
        nCreate.append(N_SENDER).append(TEXT).append(COMMA);
        nCreate.append(N_EVENTID).append(TEXT).append(RBRAC);
        db.execSQL(createTable + nCreate);

        // create user table
        StringBuilder uCreate = new StringBuilder().append(TABLE_USER).append(LBRAC);
        uCreate.append(P_USERNAME).append(TEXT).append(PK).append(COMMA);
        uCreate.append(P_PROFILEPIC).append(TEXT).append(COMMA);
        uCreate.append(P_PHONENUMBER).append(TEXT).append(RBRAC);
        db.execSQL(createTable + uCreate);

        // create venue table
        StringBuilder vCreate = new StringBuilder().append(TABLE_VENUE).append(LBRAC);
        vCreate.append(V_VENUEID).append(TEXT).append(PK).append(COMMA);
        vCreate.append(V_NAME).append(TEXT).append(COMMA);
        vCreate.append(V_CATEGORY).append(TEXT).append(COMMA);
        vCreate.append(P_POSTALCODE).append(TEXT).append(RBRAC);
        db.execSQL(createTable + vCreate);
    }

    private static String stringifyList(List<Flattenable> list) {
        StringBuilder str = new StringBuilder().append(list.size());
        for (Flattenable f : list) {
            str.append(SPACE).append(f.flatten());
        }
        return str.toString();
    }

    private static String stringifyMap(Map<Flattenable, ?> map) {
        StringBuilder str = new StringBuilder().append(map.size());
        for (Flattenable f: map.keySet()) {
            str.append(f).append(SPACE).append(map.get(f));
        }
        return str.toString();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
