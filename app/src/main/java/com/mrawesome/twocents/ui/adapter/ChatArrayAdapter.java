package com.mrawesome.twocents.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.mrawesome.twocents.R;
import com.mrawesome.twocents.data.persistent.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrawesome on 26/5/17.
 */

public class ChatArrayAdapter extends ArrayAdapter<Comment> {

    private TextView chatText;
    private List<Comment> CommentList = new ArrayList<>();
    private Context context;

    @Override
    public void add(Comment object) {
        CommentList.add(object);
        super.add(object);
    }

    public ChatArrayAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        this.context = context;
    }

    public int getCount() {
        return this.CommentList.size();
    }

    public Comment getItem(int index) {
        return this.CommentList.get(index);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Comment comment = getItem(position);
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (comment.isOwnComment()) {
            convertView = inflater.inflate(R.layout.right_chat_bubble, parent, false);
        }else{
            convertView = inflater.inflate(R.layout.left_chat_bubble, parent, false);
        }
        chatText = (TextView) convertView.findViewById(R.id.msgr);
        chatText.setText(comment.getComment());
        return convertView;
    }
}
