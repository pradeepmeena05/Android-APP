package toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.myapplication.R;

public class ToolBarMainActivity extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tool_bar_main);



        toolbar=findViewById(R.id.Toolbar);

        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("MY TOOLBAR");



        toolbar.setSubtitle("toolbar 2");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.menubar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

         int itemid=item.getItemId();

        if(itemid==R.id.setting)
        {
            Toast.makeText(this, "this is seeting", Toast.LENGTH_SHORT).show();
        }
       else if(itemid==R.id.close)
        {
            Toast.makeText(this, "this is close", Toast.LENGTH_SHORT).show();
        }
       else if(itemid==R.id.save)
        {
            Toast.makeText(this, "this is save", Toast.LENGTH_SHORT).show();
        }
       else{
            Toast.makeText(this, "this is home", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}