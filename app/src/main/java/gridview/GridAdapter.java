package gridview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;

import java.util.ArrayList;

public class GridAdapter extends ArrayAdapter<GridData> {


    public GridAdapter(GridViewActivity context, ArrayList<GridData> list) {
        super(context, 0, list);
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView = convertView;

        if (listitemView == null) {
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.card_item, parent, false);
        }

        GridData item = getItem(position);

        TextView text = listitemView.findViewById(R.id.text);
        text.setText(item.getCard_name());


        return listitemView;
    }
}
