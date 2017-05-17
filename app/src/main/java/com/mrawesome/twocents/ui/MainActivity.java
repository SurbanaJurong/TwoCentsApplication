package com.mrawesome.twocents.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mrawesome.twocents.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toProfileTest(View view) {
        Intent intent = new Intent(this, ProfileTestActivity.class);
        startActivity(intent);
    }

    public void toEventTest(View view) {
        Intent intent = new Intent(this, EventTestActivity.class);
        startActivity(intent);
    }

    public void testUserSuggestion(View view) {

    }
}
