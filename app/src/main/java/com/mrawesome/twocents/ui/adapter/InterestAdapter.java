package com.mrawesome.twocents.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mrawesome.twocents.R;
import com.mrawesome.twocents.data.persistent.Interest;

import java.util.ArrayList;

/**
 * Created by mrawesome on 21/5/17.
 */

public class InterestAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Interest> interests;

    public InterestAdapter(Context context, ArrayList<Interest> interests) {
        this.context = context;
        this.interests = interests;
    }
    @Override
    public int getCount() {
        return interests.size();
    }

    @Override
    public Object getItem(int position) {
        return interests.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.interest_item, parent, false);
        }

        Interest interest = (Interest) getItem(position);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.interest_avatar);
        TextView textView = (TextView) convertView.findViewById(R.id.interest_subject);

        byte[] avatarBase64 = Base64.decode(interest.getIcon(), Base64.DEFAULT);
        Bitmap image = BitmapFactory.decodeByteArray(avatarBase64, 0, avatarBase64.length);
        imageView.setImageBitmap(image);
        textView.setText(interest.getSubject());

        return convertView;
    }
}
