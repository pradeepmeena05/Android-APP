package notify;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.example.myapplication.R;

public class NotifyActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "channel_id";
    private static final int NOTIFICATION_ID = 700;
    private static final int REQUEST_CODE = 107;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);
        createAndShowNotification();
    }

    private void createAndShowNotification() {
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (notificationManager == null) return;

        Intent intent = new Intent(getApplicationContext(), NotifyActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(
                getApplicationContext(),
                REQUEST_CODE,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT | (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ? PendingIntent.FLAG_IMMUTABLE : 0)
        );

        Drawable drawable= ResourcesCompat.getDrawable(getResources(),R.drawable.profile,null);

        BitmapDrawable bitmapDrawable=(BitmapDrawable) drawable;

        Bitmap bitmap=bitmapDrawable.getBitmap();


        Notification notification;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "My Notification Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            notificationManager.createNotificationChannel(channel);

            notification = new Notification.Builder(this, CHANNEL_ID)
                    .setSmallIcon(R.drawable.unit)
                    .setContentTitle("Notification Title")
                    .setContentText("This is my notification")
                    .setSubText("Pradeep Meena")
                    .setStyle(new Notification.BigPictureStyle().bigPicture(bitmap))
                    .build();



        } else {
            notification = new Notification.Builder(this)
                    .setSmallIcon(R.drawable.unit)
                    .setContentTitle("Notification Title")
                    .setContentText("This is my notification")
                    .setSubText("Pradeep Meena")
                    .setStyle(new Notification.InboxStyle().addLine("pradeep").addLine("Meena").addLine("Meena").addLine("Meena").addLine("Meena").addLine("Meena"))
                    .build();
        }

        notificationManager.notify(NOTIFICATION_ID, notification);
    }
}
