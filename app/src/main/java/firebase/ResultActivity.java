package firebase;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultTextview=findViewById(R.id.resultTextView);

        Intent intent=getIntent();

        String value1=intent.getStringExtra("login");
        String value2=intent.getStringExtra("register");


        resultTextview.setText(value1);
        resultTextview.setText(value2);
    }
}