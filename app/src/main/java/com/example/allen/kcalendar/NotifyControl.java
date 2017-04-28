package com.example.allen.kcalendar;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

class NotifyControl {
    private Context activity;

    NotifyControl(Context activity) {
        this.activity = activity;
    }

    void sendNotification(String ntmess, String title, String mess) {
        int icon = R.mipmap.ic_launcher;
        int nt_default = Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE | Notification.DEFAULT_LIGHTS;

        PendingIntent pendingIntent = getPendingIntent();
        Notification notification = getNotification(pendingIntent, ntmess, title, mess, icon, nt_default);
        NotificationManager manager = (NotificationManager)activity.getSystemService(Service.NOTIFICATION_SERVICE);
        manager.notify(0, notification);
    }

    private Notification getNotification(PendingIntent pendingIntent, String ntmess, String title, String mess, int icon, int nt_default) {
        NotificationCompat.Builder notification = new NotificationCompat.Builder(activity.getApplicationContext());

        notification.setContentIntent(pendingIntent);
        notification.setTicker(ntmess);
        notification.setSmallIcon(icon);
        notification.setContentTitle(title);
        notification.setContentText(mess);
        notification.setWhen(System.currentTimeMillis());
        notification.setDefaults(nt_default);
        notification.setAutoCancel(true);

        return notification.build();
    }

    private PendingIntent getPendingIntent() {
        Intent intent = new Intent(activity, activity.getClass());
        return PendingIntent.getActivity(activity, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }
}
