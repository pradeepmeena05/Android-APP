package download_manager;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class DownLoad_MainActivity extends AppCompatActivity {

    EditText UrlId;
    Button downloadButton;
    DataClass object = new DataClass(this);
    private boolean iBound = false;
    private forgroudservice service;
    private final ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            forgroudservice.LocalBinder localBinder = (forgroudservice.LocalBinder) binder;
            service = localBinder.getService();
            iBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            service = null;
            iBound = false;
        }
    };
    private String fileName, user_url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down_load_main);

        UrlId = findViewById(R.id.UrlId);
        downloadButton = findViewById(R.id.downloadButton);

        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user_url = UrlId.getText().toString().trim();

                if (user_url.isEmpty()) {
                    Toast.makeText(DownLoad_MainActivity.this, "Enter a valid URL!", Toast.LENGTH_SHORT).show();
                    return;
                }
                UrlId.setText(" ");
                service.getNotification();
                askToSave();

            }
        });

    }

    private void askToSave() {
        String file_original_name= URLUtil.guessFileName(user_url, null, null);

        Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_TITLE, file_original_name);
        startActivityForResult(intent, 10);

    }

    public void onActivityResult(int requsetCode, int resultCode, Intent data) {
        super.onActivityResult(requsetCode, resultCode, data);
        new Thread(() -> {



            if (requsetCode == 10 && resultCode == RESULT_OK && data != null) {
                fileName = String.valueOf(data.getData());
                if (!fileName.isEmpty()) {
                    object.downloadData(user_url, Uri.parse(fileName));
                }


            }
        }).start();


    }

    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, forgroudservice.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (iBound) {
            unbindService(serviceConnection);
            iBound = false;
        }
    }
}
