package com.rafidka.dailynotification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

/**
 * Created by rabdullah on 08/06/2015.
 */
public class AlarmReceiver extends BroadcastReceiver {

  @Override
  public void onReceive(Context context, Intent intent) {
    long when = System.currentTimeMillis();
    NotificationManager notificationManager = (NotificationManager) context
        .getSystemService(Context.NOTIFICATION_SERVICE);

    Intent notificationIntent = new Intent(context, MainActivity.class);
    notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

    PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,
        notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);


    Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

    NotificationCompat.Builder mNotifyBuilder = new NotificationCompat.Builder(
        context)//.setSmallIcon(R.drawable.applogo)
        .setContentTitle("Alaram Fired")
        .setContentText("Events To be PErformed").setSound(alarmSound)
        .setAutoCancel(true).setWhen(when)
        .setContentIntent(pendingIntent)
        .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000});
    notificationManager.notify(0, /* Put a different ID if you want to show more than one notification*/
        mNotifyBuilder.build());
  }

}
