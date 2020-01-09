package com.example.myapplication;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends WearableActivity {
    private final String CHANNEL_ID="personal_notification";
    private final int NOTIFICATION_ID=001;
    private TextView mTextView;
    private Button botton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        mTextView = (TextView) findViewById( R.id.text );
        botton=(Button)findViewById( R.id.button );
        // Enables Always-on
        setAmbientEnabled();

        botton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this,CHANNEL_ID);
                builder.setSmallIcon( R.drawable.ic_sms_black_24dp );
                builder.setContentTitle( "Simple Notification" );
                builder.setContentText( "This is a simple notification from retail group..." );
                builder.setPriority( NotificationCompat.PRIORITY_DEFAULT );

                PendingIntent contentIntent = PendingIntent.getActivity(MainActivity.this, 0,
                        new Intent(MainActivity.this, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(contentIntent);


                NotificationManagerCompat notificationCompat= NotificationManagerCompat.from( MainActivity.this );
                notificationCompat.notify(NOTIFICATION_ID,builder.build());


            }
        } );
    }
}
