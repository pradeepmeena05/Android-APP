package download_manager;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;

import com.example.myapplication.R;

public class forgroudservice extends Service {

    private final IBinder iBinder = new LocalBinder();
    private final String channelId = "Pradeep_channel_Id";
    private final int notificationId = 101;

    NotificationManager notificationManager;

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }



    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
             notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            NotificationChannel channel = new NotificationChannel(
                    channelId,
                    "My Channel",
                    NotificationManager.IMPORTANCE_HIGH
            );
            notificationManager.createNotificationChannel(channel);
        }
    }


    public void getNotification() {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId)
                    .setContentTitle("Download Start...")
                    .setContentText("File is Downloading......")
                    .setSmallIcon(R.drawable.baseline_download_24)

                    .setAutoCancel(true);

            notificationManager.notify(notificationId, builder.build());

    }


    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    class LocalBinder extends Binder {
        public forgroudservice getService() {
            return forgroudservice.this;
        }
    }
}
