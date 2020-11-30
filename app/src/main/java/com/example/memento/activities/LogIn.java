package com.example.memento.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.memento.R;
import com.example.memento.data.UserConfig;
import com.example.memento.helpers.ItemTapListener;
import com.example.memento.model.UserModel;
import com.example.memento.notifications.MyNotificationPublisher;

import java.security.InvalidParameterException;


public class LogIn extends AppCompatActivity implements ItemTapListener {

    public static final String NOTIFICATION_CHANNEL_ID = "10001";
    private final static String default_notification_channel_id = "default";

    private static final String TAG = MainActivity.class.getName();
    public static final String USER_KEY = "USER";
    public static final String PASSWORD_KEY = "PASSWORD";

    private ViewGroup rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        setup();
    }

    private void setup() {
        rootView = findViewById(R.id.ly_root);
        setupViewFromData();
    }

    private void setupViewFromData() {
        Intent startIntent = getIntent();
        if(startIntent == null) {
            Toast.makeText(
                    this,
                    "Algo salió mal al obtener los datos :(",
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }

        UserModel userModel = getUserModelFromSources(startIntent.getExtras());

        if(getSupportActionBar() != null) {
            String fullname = TextUtils.isEmpty(userModel.getFullname()) ?
                    "Usuario" : userModel.getFullname();
            getSupportActionBar()
                    .setTitle(getString(R.string.welcome_user_title, fullname));
        }

        if(TextUtils.isEmpty(userModel.getPassword())) {
            Toast.makeText(
                    this,
                    R.string.cannot_get_password,
                    Toast.LENGTH_SHORT
            ).show();
        }
    }


    @NonNull
    private UserModel getUserModelFromSources(Bundle extras) {
        UserConfig userConfig = new UserConfig(getApplicationContext());
        final UserModel user = userConfig.getUser();
        if(user != null) {
            return user;
        }
        if(extras == null) {
            throw new InvalidParameterException("Extras");
        }
        return new UserModel(extras.getString(USER_KEY), extras.getString(PASSWORD_KEY));
    }

    @Override
    public void onItemTap(View view, int position) {

    }

    //Schedule alarm notification
    private void scheduleNotification(Notification notification, long delay) {
        Intent notificationIntent = new Intent(this, MyNotificationPublisher.class);
        notificationIntent.putExtra(MyNotificationPublisher.NOTIFICATION_ID, 1);
        notificationIntent.putExtra(MyNotificationPublisher.NOTIFICATION, notification);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        assert alarmManager != null;
        alarmManager.set(AlarmManager.RTC_WAKEUP, delay, pendingIntent);
    }

    //Build notification
    private Notification getNotification(String content) {
        //on notification click open MainActivity
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, default_notification_channel_id);
        builder.setContentTitle("Memento Reminder");
        builder.setContentText(content);
        builder.setContentIntent(pendingIntent);
        builder.setAutoCancel(true);
        builder.setSmallIcon(R.drawable.ic_stat_name);
        builder.setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_SOUND);
        builder.setChannelId(NOTIFICATION_CHANNEL_ID);
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);
        return builder.build();
    }

}