package searchview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.Arrays;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    List<String> list = Arrays.asList("Leetcode","leetcode","leetc", "GeeksforGeeks", "Coding Ninja","Coding", "Leethub", "geeksforgeeks", "c", "c++", "java", "python");

    SearchView searchView;
    ListView listView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchView = findViewById(R.id.searchView);
        listView = findViewById(R.id.listView);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (list.contains(query)) {
                    adapter.getFilter().filter(query);
                } else {
                    Toast.makeText(SearchActivity.this, "No Match Found", Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (list.contains(newText)) {
                    adapter.getFilter().filter(newText);
                }
                return false;
            }


        });
    }
}
