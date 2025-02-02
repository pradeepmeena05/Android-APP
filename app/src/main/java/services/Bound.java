package services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class Bound extends Service {

    @Nullable

    private final IBinder iBinder=new LocalBinder();

    public class LocalBinder extends Binder{
        public Bound getService()
        {
            return Bound.this;
        }

    }

    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    public String getMessage()
    {
        return "This is bound services";
    }

//
//    int count=0;
//    boolean flag=false;
//
//    public void StartCounter()
//    {
//        flag=true;
//        new Thread(()->{
//
//            count++;
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//
//
//        }).start();
//    }
//
//    public void stop()
//    {
//        flag=false;
//    }
//
//    public int result()
//    {
//        return count;
//    }

}
