package com.mrawesome.twocents.ui.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mrawesome.twocents.R;
import com.mrawesome.twocents.data.persistent.Notification;
import com.mrawesome.twocents.data.persistent.User;
import com.mrawesome.twocents.fragment.addInterest.AddInterestFragment1;

import java.util.List;

/**
 * Created by mrawesome on 21/5/17.
 */

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {

    private List<Notification> notifications;

    public NotificationAdapter(List<Notification> notifications) {
        this.notifications = notifications;
    }

    @Override
    public NotificationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item, parent, false);
        return new NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NotificationViewHolder holder, int position) {
        Notification notification = notifications.get(position);
        User user = new User(notification.getSender(), AddInterestFragment1.basketballAva, "83567597");
        byte[] avatarBase64 = Base64.decode(user.getProfilePic(), Base64.DEFAULT);
        Bitmap image = BitmapFactory.decodeByteArray(avatarBase64, 0, avatarBase64.length);
        holder.imageView.setImageBitmap(image);
        holder.textView.setText(notification.getSender() + " has modified event " + notification.getEventId());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }

    public static class NotificationViewHolder extends RecyclerView.ViewHolder {

        protected ImageView imageView;
        protected TextView textView;

        public NotificationViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.user_avatar);
            textView = (TextView) itemView.findViewById(R.id.user_name);
        }
    }

}
