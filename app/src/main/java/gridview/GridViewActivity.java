package gridview;

import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;

public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_grid_view);

        GridView GridId=findViewById(R.id.GridId);

        ArrayList<GridData>list=new ArrayList<>();

        list.add(new GridData("Card1"));
        list.add(new GridData("Card2"));
        list.add(new GridData("Card3"));
        list.add(new GridData("Card4"));
        list.add(new GridData("Card5"));
        list.add(new GridData("Card6"));
        list.add(new GridData("Card7"));
        list.add(new GridData("Card8"));

       GridAdapter gridAdapter=new GridAdapter(this,list);

       GridId.setAdapter(gridAdapter);



    }
}