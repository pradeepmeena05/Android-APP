package unit_converter;

import android.graphics.Color;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BmiActivity extends AppCompatActivity {

    EditText edit1, edit2, edit3;
    TextView res;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        RadioButton male = findViewById(R.id.male);
        RadioButton female = findViewById(R.id.female);
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        edit3 = findViewById(R.id.edit3);
        res = findViewById(R.id.result);
        btn = findViewById(R.id.bmi);

        male.setOnClickListener(view -> {
            if (male.isChecked()) {
                female.setChecked(false);
            }
        });

        female.setOnClickListener(view -> {
            if (female.isChecked()) {
                male.setChecked(false);
            }
        });

        btn.setOnClickListener(view -> {
            String heightText = edit2.getText().toString();
            String weightText = edit3.getText().toString();

            if (!heightText.isEmpty() && !weightText.isEmpty()) {
                  double heightcm=Integer.parseInt(heightText);
                double  weightKg = Integer.parseInt(weightText);

                double heightM= heightcm/100;
                double bmi = weightKg / (heightM * heightM);

                if (bmi < 18.5) {
                    res.setText("Underweight");
                    res.setBackgroundColor(Color.YELLOW);
                    res.setTextColor(Color.BLACK);
                } else if (bmi >= 18.5 && bmi < 24.9) {
                    res.setText("Normal weight");
                    res.setBackgroundColor(Color.GREEN);

                } else if (bmi >= 25 && bmi < 29.9) {
                    res.setText("Overweight");
                    res.setBackgroundColor(Color.YELLOW);
                    res.setTextColor(Color.BLACK);
                } else {
                    res.setText("Obesity");
                    res.setBackgroundColor(Color.RED);
                }
            }

            InputMethodManager im = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            if (im != null && getCurrentFocus() != null) {
                im.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        });


    }
}
