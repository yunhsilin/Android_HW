/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.fundamentals.standup;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;


/**
 * MainActivity for the Stand up! app. Contains a toggle button that
 * sets an alarm which delivers a Stand up notification every 15 minutes.
 */
public class MainActivity extends AppCompatActivity {

    // Notification ID.
    private static final int NOTIFICATION_ID = 0;
    // Notification channel ID.
    private static final String PRIMARY_CHANNEL_ID =
            "primary_notification_channel";
    private NotificationManager mNotificationManager;

    /**
     * Initializes the activity.
     *
     * @param savedInstanceState The current state data.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNotificationManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);

        ToggleButton alarmToggle = findViewById(R.id.alarmToggle);

        // Set up the Notification Broadcast Intent.
        Intent notifyIntent = new Intent(this, AlarmReceiver.class);

        boolean alarmUp = (PendingIntent.getBroadcast(this, NOTIFICATION_ID,
                notifyIntent, PendingIntent.FLAG_NO_CREATE) != null);
        alarmToggle.setChecked(alarmUp);

        final PendingIntent notifyPendingIntent = PendingIntent.getBroadcast
                (this, NOTIFICATION_ID, notifyIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT);

        final AlarmManager alarmManager = (AlarmManager) getSystemService
                (ALARM_SERVICE);

        // Set the click listener for the toggle button.
        alarmToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String toastMessage;
                if (isChecked){
                    if (alarmManager != null){
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.HOUR, 11);
                        calendar.set(Calendar.MINUTE, 11);
                        alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), notifyPendingIntent);
                    }
                    toastMessage = getString(R.string.alarm_on_toast);
                }
                else{
                    mNotificationManager.cancelAll();

                    if (alarmManager != null){
                        alarmManager.cancel(notifyPendingIntent);
                    }
                    toastMessage = getString(R.string.alarm_off_toast);
                }
                // Show a toast to say the alarm is turned on or off.
                Toast.makeText(MainActivity.this, toastMessage,
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Create the notification channel.
        createNotificationChannel();
    }


    /**
     * Creates a Notification channel, for OREO and higher.
     */
    public void createNotificationChannel() {

        // Create a notification manager object.
        mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Notification channels are only available in OREO and higher.
        // So, add a check on SDK version.
        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.O) {

            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_ID, "Stand up notification", NotificationManager.IMPORTANCE_HIGH);
            //TEXT
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.WHITE);
            notificationChannel.enableVibration(true);
            mNotificationManager.createNotificationChannel(notificationChannel);
        }
    }
}
