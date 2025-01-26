package videoview;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class VideoMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_video_main);

        TextView text=findViewById(R.id.text);

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.small);

        VideoView videoView=findViewById(R.id.videoview);

        videoView.setVideoURI(uri);

        MediaController mediaController=new MediaController(this);

        mediaController.setAnchorView(videoView);

        mediaController.setMediaPlayer(videoView);

        videoView.setMediaController(mediaController);



    }
}