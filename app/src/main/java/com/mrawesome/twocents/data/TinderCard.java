package com.mrawesome.twocents.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;
import com.mrawesome.twocents.R;
import com.mrawesome.twocents.data.persistent.Event;
import com.mrawesome.twocents.data.persistent.Interest;
import com.mrawesome.twocents.data.persistent.User;
import com.mrawesome.twocents.data.persistent.Venue;

import org.w3c.dom.Text;

import io.realm.Realm;

/**
 * Created by mrawesome on 23/5/17.
 */

@Layout(R.layout.event_card_view)
public class TinderCard {

    @View(R.id.today_event_icon)
    private ImageView imageView;

    @View(R.id.today_event_name)
    private TextView name;

    @View(R.id.today_event_host)
    private TextView hostView;

    @View(R.id.today_event_venue)
    private TextView venueView;

    @View(R.id.today_event_time)
    private TextView time;

    @View(R.id.today_event_recurring)
    private TextView recurring;

    @View(R.id.today_event_participant)
    private TextView participant;

    private Event event;
    private Context mContext;
    private SwipePlaceHolderView mSwipeView;

    public TinderCard(Context context, Event event, SwipePlaceHolderView swipeView) {
        this.mContext = context;
        this.event = event;
        this.mSwipeView = swipeView;
    }

    @Resolve
    private void onResolved(){
        Realm realm = Realm.getDefaultInstance();
        Interest interest = realm.where(Interest.class).equalTo("id", event.getCategory()).findFirst();
        byte[] avatarBase64 = Base64.decode(interest.getIcon(), Base64.DEFAULT);
        Bitmap image = BitmapFactory.decodeByteArray(avatarBase64, 0, avatarBase64.length);
        imageView.setImageBitmap(image);
        name.setText(event.getName());
        User host = Realm.getDefaultInstance().where(User.class).equalTo("id", event.getHost()).findFirst();
        if (host != null) {
            hostView.setText(host.getUsername());
        }
        Venue venue = Realm.getDefaultInstance().where(Venue.class).equalTo("id", event.getVenueId()).findFirst();
        if (venue != null) {
            venueView.setText(venue.getName());
        }
        time.setText(event.getStartTime().substring(0, 16));
        recurring.setText(event.getIsRecurring() ? "one time" : "every week");
        participant.setText(event.getParticipants().size() + "/" + event.getMaxCapacity());
    }

    @SwipeOut
    private void onSwipedOut(){
        Log.d("EVENT", "onSwipedOut");
        mSwipeView.addView(this);
    }

    @SwipeCancelState
    private void onSwipeCancelState(){
        Log.d("EVENT", "onSwipeCancelState");
    }

    @SwipeIn
    private void onSwipeIn(){
        Log.d("EVENT", "onSwipedIn");
    }

    @SwipeInState
    private void onSwipeInState(){
        Log.d("EVENT", "onSwipeInState");
    }

    @SwipeOutState
    private void onSwipeOutState(){
        Log.d("EVENT", "onSwipeOutState");
    }
}
