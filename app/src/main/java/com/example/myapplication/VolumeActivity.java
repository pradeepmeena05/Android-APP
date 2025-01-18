package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;
import java.util.List;

public class VolumeActivity extends AppCompatActivity {


    String spinner1Text, spinner2Text;
    List<String> list1 = Arrays.asList("Kilometre", "Metre", "Centimetre", "Millimetre", "Micrometre", "Nanometre", "Mile", "Yard", "Foot", "Inch", "Decimetre");

    Spinner unitFromSpinner;
    Spinner unitToSpinner;
    EditText valueInput;
    Button convertButton,reset;
    TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_volume);
        valueInput = findViewById(R.id.valueInput);
        unitFromSpinner = findViewById(R.id.unitFromSpinner);
        unitToSpinner = findViewById(R.id.unitToSpinner);
        convertButton = findViewById(R.id.convertButton);
        resultText = findViewById(R.id.resultTextView);
        reset=findViewById(R.id.resetbtn);


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unitFromSpinner.setSelection(0);
                unitToSpinner.setSelection(0);
                valueInput.setText(" ");
                resultText.setText(" ");

            }
        });



    }
}