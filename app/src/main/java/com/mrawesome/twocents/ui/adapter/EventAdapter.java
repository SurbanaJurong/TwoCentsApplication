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
import com.mrawesome.twocents.data.persistent.Event;
import com.mrawesome.twocents.data.persistent.Interest;
import com.mrawesome.twocents.data.persistent.User;
import com.mrawesome.twocents.data.persistent.Venue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import io.realm.Realm;

/**
 * Created by mrawesome on 21/5/17.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private static final String TAG = EventAdapter.class.getSimpleName();

    private List<Event> events = new ArrayList<>();

    public EventAdapter(Set<Event> events) {
        this.events.addAll(events);
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        Event event = events.get(position);
        Realm realm = Realm.getDefaultInstance();
        Interest interest = realm.where(Interest.class).equalTo("id", event.getCategory()).findFirst();
        byte[] avatarBase64 = Base64.decode(interest.getIcon(), Base64.DEFAULT);
        Bitmap image = BitmapFactory.decodeByteArray(avatarBase64, 0, avatarBase64.length);
        holder.imageView.setImageBitmap(image);
        holder.eventName.setText(event.getName());
        User host = Realm.getDefaultInstance().where(User.class).equalTo("id", event.getHost()).findFirst();
        if (host != null) {
            holder.host.setText(host.getUsername());
        }
        Venue venue = Realm.getDefaultInstance().where(Venue.class).equalTo("id", event.getVenueId()).findFirst();
        if (venue != null) {
            holder.venue.setText(venue.getName());
        }
        holder.time.setText(event.getStartTime().substring(0, 16));
        holder.isRecurring.setText(event.getIsRecurring() ? "one time" : "every week");
        holder.participant.setText(event.getParticipants().size() + "/" + event.getMaxCapacity());

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {

        protected ImageView imageView;
        protected TextView eventName;
        protected TextView host;
        protected TextView venue;
        protected TextView time;
        protected TextView isRecurring;
        protected TextView participant;

        public EventViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.user_avatar);
            eventName = (TextView) itemView.findViewById(R.id.event_item_event_name);
            host = (TextView) itemView.findViewById(R.id.event_item_host);
            venue = (TextView) itemView.findViewById(R.id.event_item_venueId);
            time = (TextView) itemView.findViewById(R.id.event_item_time);
            isRecurring = (TextView) itemView.findViewById(R.id.event_item_is_recurring);
            participant = (TextView) itemView.findViewById(R.id.event_item_participant);
        }
    }

}
