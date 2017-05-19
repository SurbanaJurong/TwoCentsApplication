package com.mrawesome.twocents.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mrawesome.twocents.R;
import com.mrawesome.twocents.communication.CommModule;
import com.mrawesome.twocents.communication.request.RequestType;
import com.mrawesome.twocents.communication.response.Response;
import com.mrawesome.twocents.data.Event;
import com.mrawesome.twocents.util.BundleWriter;

import java.io.IOException;
import java.util.Calendar;

public class EventTestActivity extends AppCompatActivity {

    private TextView responseView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_test);
        responseView = (TextView) findViewById(R.id.textView3);
    }

    public void testAttendanceMark(View view) {
        Bundle payload = BundleWriter.packAttendanceMark("e123123");
        try {
            Response response = CommModule.sendRequest(RequestType.AttendanceMark, payload);
            responseView.setText(response.payload);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testCalendarRefresh(View view) {
        try {
            Response response = CommModule.sendRequest(RequestType.CalendarRefresh, null);
            responseView.setText(response.payload);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testCommentPost(View view) {
        Bundle payload = BundleWriter.packCommentPost("e123123", "What is this?");
        try {
            Response response = CommModule.sendRequest(RequestType.CommentPost, payload);
            responseView.setText(response.payload);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testEventCreate(View view) {
        Bundle payload = BundleWriter.packEventCreate("Football for life", "football", "A place to gather", "v123123", 10, 20, Calendar.getInstance(), 1);
        try {
            Response response = CommModule.sendRequest(RequestType.EventCreate, payload);
            responseView.setText(response.payload);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testEventEdit(View view) {
        Bundle payload = BundleWriter.packEventEdit("e123123", "Not a place to gather", "fasawdvdawv", 11, 19);
        try {
            Response response = CommModule.sendRequest(RequestType.EventEdit, payload);
            responseView.setText(response.payload);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testEventRegister(View view) {
        Bundle payload = BundleWriter.packEventRegister("e123123");
        try {
            Response response = CommModule.sendRequest(RequestType.EventRegister, payload);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testEventTimeEdit(View view) {
        Bundle payload = BundleWriter.packEventTimeEdit("e123123", Calendar.getInstance(), 2);
        try {
            Response response = CommModule.sendRequest(RequestType.EventTimeEdit, payload);
            responseView.setText(response.payload);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testEventVenueEdit(View view) {
        Bundle payload = BundleWriter.packEventVenueEdit("e123123", "v234234");
        try {
            Response response = CommModule.sendRequest(RequestType.EventVenueEdit, payload);
            responseView.setText(response.payload);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testSwitchRecur(View view) {
        Bundle payload = BundleWriter.packSwitchRecur("e123123", Event.MODE_ONE_TIME);
        try {
            Response response = CommModule.sendRequest(RequestType.SwitchRecur, payload);
            responseView.setText(response.payload);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
