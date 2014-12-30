package com.kosbrother.pullups.alert_setting;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.kosbrother.pullups.IndexActivity;
import com.kosbrother.pullups.R;

public class AlarmReceiver extends BroadcastReceiver {
    public AlarmReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        PendingIntent viewPendingIntent = PendingIntent.getActivity(context, 0, new Intent(context, IndexActivity.class), PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_ONE_SHOT);

        Bitmap iconBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher);
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.ic_stat_notify)
                        .setLargeIcon(iconBitmap)
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("訓練的時間到囉，快點動起來，會愈來愈強壯哦！"))
                        .setContentTitle("訓練的時間到囉")
                        .setContentText("訓練的時間到囉，快點動起來，會愈來愈強壯哦！")
                        .setContentIntent(viewPendingIntent)
                        .setTicker("訓練的時間到囉！")
                        .setSound(alarmSound)
                        .setAutoCancel(true);

        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(context);

        int notificationId = 2;
        notificationManager.notify(notificationId, notificationBuilder.build());

    }
}
