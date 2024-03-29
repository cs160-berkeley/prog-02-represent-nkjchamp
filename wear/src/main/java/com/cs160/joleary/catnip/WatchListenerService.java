package com.cs160.joleary.catnip;

import android.content.Intent;
import android.util.Log;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

import java.lang.reflect.Member;
import java.nio.charset.StandardCharsets;

/**
 * Created by joleary and noon on 2/19/16 at very late in the night. (early in the morning?)
 */
public class WatchListenerService extends WearableListenerService {
    // In PhoneToWatchService, we passed in a path, either "/FRED" or "/LEXY"
    // These paths serve to differentiate different phone-to-watch messages
    private static final String ZIP_LOC = "/ZipCode";
    private static final String CURR_LOC = "/CurrentLocation";
    private static final String SEN1 = "/Sen1";
    private static final String SEN2 = "/Sen2";
    private static final String REP = "/Rep";

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        Log.d("T", "in WatchListenerService, got: " + messageEvent.getPath());
        //use the 'path' field in sendmessage to differentiate use cases
        //(here, fred vs lexy)

        if( messageEvent.getPath().equalsIgnoreCase( ZIP_LOC ) ) {
            String value = new String(messageEvent.getData(), StandardCharsets.UTF_8);
            Intent intent = new Intent(this, MainActivity.class );
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //you need to add this flag since you're starting a new activity from a service
            intent.putExtra("MEMBER", "Sen1");
            Log.d("T", "about to start watch MainActivity with ENTER_LOC: ZipCode");
            startActivity(intent);
        } else if (messageEvent.getPath().equalsIgnoreCase( CURR_LOC )) {
            String value = new String(messageEvent.getData(), StandardCharsets.UTF_8);
            Intent intent = new Intent(this, MainActivity.class );
            intent.addFlags( Intent.FLAG_ACTIVITY_NEW_TASK );
            //you need to add this flag since you're starting a new activity from a service
            intent.putExtra("MEMBER", "Sen1");
            Log.d("T", "about to start watch MainActivity with ENTER_LOC: CurrentLocation");
            startActivity(intent);
        } else if (messageEvent.getPath().equalsIgnoreCase( SEN1 )) {
            String value = new String(messageEvent.getData(), StandardCharsets.UTF_8);
            Intent intent = new Intent(this, MainActivity.class );
            intent.addFlags( Intent.FLAG_ACTIVITY_NEW_TASK );
            //you need to add this flag since you're starting a new activity from a service
            intent.putExtra("MEMBER", "Sen1");
            Log.d("T", "about to start watch MainActivity with ENTER_LOC: CurrentLocation");
            startActivity(intent);
        } else if (messageEvent.getPath().equalsIgnoreCase( SEN2 )) {
            String value = new String(messageEvent.getData(), StandardCharsets.UTF_8);
            Intent intent = new Intent(this, MainActivity.class );
            intent.addFlags( Intent.FLAG_ACTIVITY_NEW_TASK );
            //you need to add this flag since you're starting a new activity from a service
            intent.putExtra("MEMBER", "Sen2");
            Log.d("T", "about to start watch MainActivity with ENTER_LOC: CurrentLocation");
            startActivity(intent);
        } else if (messageEvent.getPath().equalsIgnoreCase( REP )) {
            String value = new String(messageEvent.getData(), StandardCharsets.UTF_8);
            Intent intent = new Intent(this, MainActivity.class );
            intent.addFlags( Intent.FLAG_ACTIVITY_NEW_TASK );
            //you need to add this flag since you're starting a new activity from a service
            intent.putExtra("MEMBER", "Rep");
            Log.d("T", "about to start watch MainActivity with ENTER_LOC: CurrentLocation");
            startActivity(intent);
        } else {
            super.onMessageReceived( messageEvent );
        }

    }
}