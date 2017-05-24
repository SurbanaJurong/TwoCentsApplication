package com.mrawesome.twocents.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
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
import java.util.List;

/**
 * Created by mrawesome on 21/5/17.
 */

public class InterestAdapter extends RecyclerView.Adapter<InterestAdapter.InterestViewHolder> {

    private static final String TAG = InterestAdapter.class.getSimpleName();

    private List<Interest> interests;

    public InterestAdapter(List<Interest> interests) {
        this.interests = interests;
    }

    @Override
    public InterestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.interest_item, parent, false);
        return new InterestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InterestViewHolder holder, int position) {
        Interest interest = interests.get(position);
        byte[] avatarBase64 = Base64.decode(interest.getIcon(), Base64.DEFAULT);
        Bitmap image = BitmapFactory.decodeByteArray(avatarBase64, 0, avatarBase64.length);
        holder.imageView.setImageBitmap(image);
        holder.textView.setText(interest.getSubject());

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return interests.size();
    }

    public static class InterestViewHolder extends RecyclerView.ViewHolder {

        protected ImageView imageView;
        protected TextView textView;

        public InterestViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.interest_avatar);
            textView = (TextView) itemView.findViewById(R.id.interest_subject);
        }
    }
}
