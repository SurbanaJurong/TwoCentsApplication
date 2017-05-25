package com.mrawesome.twocents.ui;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.mrawesome.twocents.R;
import com.mrawesome.twocents.data.persistent.Comment;
import com.mrawesome.twocents.ui.adapter.ChatArrayAdapter;

public class ChatroomActivity extends AppCompatActivity {

    private ChatArrayAdapter chatArrayAdapter;
    private ListView listView;
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);
        listView = (ListView) findViewById(R.id.comment_list);
        editText = (EditText) findViewById(R.id.textbox);
        button = (Button) findViewById(R.id.send_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendChatMessage();
            }
        });
        chatArrayAdapter = new ChatArrayAdapter(getApplicationContext(), R.layout.right_chat_bubble);
        chatArrayAdapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                listView.setSelection(chatArrayAdapter.getCount() - 1);
            }
        });
        listView.setAdapter(chatArrayAdapter);
        listView.setDivider(null);

    }

    private boolean sendChatMessage() {
        String text = editText.getText().toString();
        if (!text.equals("")) {
            chatArrayAdapter.add(new Comment(123123, editText.getText().toString()));
            editText.setText("");
        }
        return true;
    }
}
