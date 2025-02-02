package services;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class BackGroundClass extends Service {

    Handler handler=new Handler(Looper.getMainLooper());
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        new Thread(()->{
            background();
            stopSelf();
        }).start();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_REDELIVER_INTENT;
    }

    public void background(){
        try {
            Thread.sleep(4000);
           handler.post(()-> Toast.makeText(this, "background process complete", Toast.LENGTH_SHORT).show());
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
