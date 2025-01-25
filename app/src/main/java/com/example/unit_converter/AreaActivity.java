package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class AreaActivity extends AppCompatActivity {


    List<String> areaUnits = Arrays.asList(
            "Square kilometre",
            "Hectare",
            "Are",
            "Square metre",
            "Square decimetre",
            "Square centimetre",
            "Square millimetre",
            "Acre",
            "Square mile",
            "Square yard",
            "Square foot",
            "Square inch"
    );
    String spinner1Text, spinner2Text;
    Spinner unitFromSpinner;
    Spinner unitToSpinner;
    EditText valueInput;
    Button convertButton, reset;
    TextView resultText;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);

        valueInput = findViewById(R.id.valueInput);
        unitFromSpinner = findViewById(R.id.unitFromSpinner);
        unitToSpinner = findViewById(R.id.unitToSpinner);
        convertButton = findViewById(R.id.convertButton);
        resultText = findViewById(R.id.resultTextView);
        reset = findViewById(R.id.resetbtn);


        unitFromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                spinner1Text = adapterView.getItemAtPosition(i).toString();
                unitFromSpinner.setDropDownWidth(400);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        unitToSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinner2Text = adapterView.getItemAtPosition(i).toString();
                unitToSpinner.setDropDownWidth(400);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String>adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,areaUnits);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitFromSpinner.setAdapter(adapter);
        unitToSpinner.setAdapter(adapter);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = valueInput.getText().toString();
                Double inputVal = Double.parseDouble(input);

                if (input.isEmpty()) {
                    Toast.makeText(AreaActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                } else if (spinner1Text.equals("Square kilometre")) {
                    double result = checkForSK(spinner2Text, inputVal);
                    resultText.setText(result + " " + spinner2Text);
                }
                else if (spinner1Text.equals("Hectare")) {
                    double result = checkForHec(spinner2Text, inputVal);
                    resultText.setText(result + " " + spinner2Text);
                }
                else if (spinner1Text.equals("Are")) {
                    double result = checkForAr(spinner2Text, inputVal);
                    resultText.setText(result + " " + spinner2Text);
                }
                else if (spinner1Text.equals("Acre")) {
                    double result = checkForAcre(spinner2Text, inputVal);
                    resultText.setText(result + " " + spinner2Text);
                }
                else if (spinner1Text.equals("Square decimetre")) {
                    double result = checkForDm2(spinner2Text, inputVal);
                    resultText.setText(result + " " + spinner2Text);
                }
                else if (spinner1Text.equals("Square mile")) {
                    double result = checkForMi2(spinner2Text, inputVal);
                    resultText.setText(result + " " + spinner2Text);
                }
                else if (spinner1Text.equals("Square centimetre")) {
                    double result = checkForCm2(spinner2Text, inputVal);
                    resultText.setText(result + " " + spinner2Text);
                }
                else if (spinner1Text.equals("Square millimetre")) {
                    double result = checkForMm2(spinner2Text, inputVal);
                    resultText.setText(result + " " + spinner2Text);
                }
                else if (spinner1Text.equals("Square yard")) {
                    double result = checkForYd2(spinner2Text, inputVal);
                    resultText.setText(result + " " + spinner2Text);
                }
                else if (spinner1Text.equals("Square foot")) {
                    double result = checkForFt2(spinner2Text, inputVal);
                    resultText.setText(result + " " + spinner2Text);
                }
                else if (spinner1Text.equals("Square inch")) {
                    double result = checkForIn2(spinner2Text, inputVal);
                    resultText.setText(result + " " + spinner2Text);
                }
                else if (spinner1Text.equals("Square metre")) {
                    double result = checkForM2(spinner2Text, inputVal);
                    resultText.setText(result + " " + spinner2Text);
                }
                InputMethodManager imm=(InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                if(imm!=null&&getCurrentFocus()!=null)
                {
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
                }
            }
        });



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

    public double checkForSK(String str, double input) {
        switch (str) {
            case "Hectare":
                return input*100;
            case "Are":
                return input*10000;
            case "Square metre":
                return input*1000000;

            case "Square decimetre":
                return input*10000000;
            case "Square centimetre":
                return input*100000000;
            case "Square millimetre":
                return input*1000000000000L;
            case "Acre":
                return input*247.105;
            case "Square mile":
                return input*0.386102;
            case "Square yard":
                return input * 1_195_990;
            case "Square foot":
                return input * 10_763_910;
            case "Square inch":
                return input * 1_550_003_100;
        }
        return 0.0;
    }
    public double checkForHec(String str, double input) {
        switch (str) {
            case "Square kilometre":
                return input/100;
            case "Are":
                return input*100;
            case "Square metre":
                return input*10000;
            case "Square decimetre":
                return input*100_000;
            case "Square centimetre":
                return input*1_000_000;
            case "Square millimetre":
                return input*10_000_000_000L;
            case "Acre":
                return input*2.47105;
            case "Square mile":
                return input/258.999;
            case "Square yard":
                return input * 11_959.9;
            case "Square foot":
                return input * 107_639.1;
            case "Square inch":
                return input * 15_500_031;
        }
        return 0.0;
    }
    public double checkForAr(String str, double input) {
        switch (str) {
            case "Square kilometre":
                return input * 10_000;
            case "Hectare":
                return input * 100;
            case "Square metre":
                return input / 100;
            case "Square decimetre":
                return input / 1_000;
            case "Square centimetre":
                return input / 10_000;
            case "Square millimetre":
                return input / 100_000_000;
            case "Acre":
                return input * 40.4686;
            case "Square mile":
                return input * 25899.9;
            case "Square yard":
                return input / 11.9599;
            case "Square foot":
                return input / 107.639;
            case "Square inch":
                return input / 15_500.031;
        }
        return 0.0;
    }
    public double checkForM2(String str, double input) {
        switch (str) {
            case "Square kilometre":
                return input * 1_000_000;
            case "Hectare":
                return input * 10_000;
            case "Are":
                return input * 100;
            case "Square decimetre":
                return input / 100;
            case "Square centimetre":
                return input / 10_000;
            case "Square millimetre":
                return input / 1_000_000;
            case "Acre":
                return input * 4046.86;
            case "Square mile":
                return input * 2_589_990;
            case "Square yard":
                return input * 0.836127;
            case "Square foot":
                return input * 0.092903;
            case "Square inch":
                return input * 0.00064516;
        }
        return 0.0;
    }
    public double checkForAcre(String str, double input) {
        switch (str) {
            case "Square kilometre":
                return input * 247.105;
            case "Hectare":
                return input / 2.47105;
            case "Are":
                return input / 40.4686;
            case "Square metre":
                return input / 4046.86;
            case "Square decimetre":
                return input / 40_468.6;
            case "Square centimetre":
                return input / 4_046_860;
            case "Square millimetre":
                return input / 4_046_860_000L;
            case "Square mile":
                return input * 640;
            case "Square yard":
                return input / 4840;
            case "Square foot":
                return input / 43_560;
            case "Square inch":
                return input / 6_272_640;
        }
        return 0.0;
    }
    public double checkForMi2(String str, double input) {
        switch (str) {
            case "Square kilometre":
                return input * 0.386102;
            case "Hectare":
                return input / 258.999;
            case "Are":
                return input / 25_899.88;
            case "Square metre":
                return input / 2_589_990;
            case "Square decimetre":
                return input / 25_899_900;
            case "Square centimetre":
                return input / 2_589_990_000L;
            case "Square millimetre":
                return input / 2_589_990_000_000L;
            case "Acre":
                return input / 640;
            case "Square yard":
                return input / 3_097_600;
            case "Square foot":
                return input / 27_878_400;
            case "Square inch":
                return input / 4_014_489_600L;
        }
        return 0.0;
    }
    public double checkForDm2(String str, double input) {
        switch (str) {
            case "Square kilometre":
                return input * 10_000_000;
            case "Hectare":
                return input * 100_000;
            case "Are":
                return input * 10_000;
            case "Square metre":
                return input * 100;
            case "Square centimetre":
                return input / 100;
            case "Square millimetre":
                return input / 10_000;
            case "Acre":
                return input * 4_046_860;
            case "Square mile":
                return input * 25_899_900;
            case "Square yard":
                return input * 836.127;
            case "Square foot":
                return input * 92.903;
            case "Square inch":
                return input * 6.4516;
        }
        return 0.0;
    }
    public double checkForCm2(String str, double input) {
        switch (str) {
            case "Square kilometre":
                return input * 10_000_000_000L;
            case "Hectare":
                return input * 100_000_000;
            case "Are":
                return input * 10_000_000;
            case "Square metre":
                return input * 10_000;
            case "Square decimetre":
                return input * 100;
            case "Square millimetre":
                return input / 100;
            case "Acre":
                return input * 4_046_860_000L;
            case "Square mile":
                return input * 25_899_900_000L;
            case "Square yard":
                return input * 83_612.7;
            case "Square foot":
                return input * 9_290.3;
            case "Square inch":
                return input * 645.16;
        }
        return 0.0;
    }
    public double checkForMm2(String str, double input) {
        switch (str) {
            case "Square kilometre":
                return input * 1_000_000_000_000L;
            case "Hectare":
                return input * 10_000_000_000L;
            case "Are":
                return input * 1_000_000_000;
            case "Square metre":
                return input * 1_000_000;
            case "Square decimetre":
                return input * 10_000;
            case "Square centimetre":
                return input * 100;
            case "Acre":
                return input * 4_046_860_000_000L;
            case "Square mile":
                return input * 2_589_990_000_000L;
            case "Square yard":
                return input * 836_127;
            case "Square foot":
                return input * 92_903;
            case "Square inch":
                return input * 6_451.6;
        }
        return 0.0;
    }
    public double checkForYd2(String str, double input) {
        switch (str) {
            case "Square kilometre":
                return input * 1_195_990;
            case "Hectare":
                return input * 11_959.9;
            case "Are":
                return input * 1_195.99;
            case "Square metre":
                return input * 1.19599;
            case "Square decimetre":
                return input * 0.01196;
            case "Square centimetre":
                return input * 0.0001196;
            case "Square millimetre":
                return input * 0.000001196;
            case "Acre":
                return input * 4_840;
            case "Square mile":
                return input * 3_097_600;
            case "Square foot":
                return input / 9;
            case "Square inch":
                return input / 1_296;
        }
        return 0.0;
    }
    public double checkForFt2(String str, double input) {
        switch (str) {
            case "Square kilometre":
                return input * 10_763_910;
            case "Hectare":
                return input * 107_639;
            case "Are":
                return input * 10_764;
            case "Square metre":
                return input * 10.764;
            case "Square decimetre":
                return input * 0.10764;
            case "Square centimetre":
                return input * 0.0010764;
            case "Square millimetre":
                return input * 0.000010764;
            case "Acre":
                return input * 43_560;
            case "Square mile":
                return input * 27_878_400;
            case "Square yard":
                return input * 9;
            case "Square inch":
                return input / 144;
        }
        return 0.0;
    }
    public double checkForIn2(String str, double input) {
        switch (str) {
            case "Square kilometre":
                return input * 1_550_003_100L;
            case "Hectare":
                return input * 15_500_031;
            case "Are":
                return input * 1_550_003.1;
            case "Square metre":
                return input * 1_550.0031;
            case "Square decimetre":
                return input * 15.500031;
            case "Square centimetre":
                return input * 0.155;
            case "Square millimetre":
                return input * 0.00155;
            case "Acre":
                return input * 6_272_640;
            case "Square mile":
                return input * 4_014_489_600L;
            case "Square yard":
                return input * 1_296;
            case "Square foot":
                return input * 144;
        }
        return 0.0;
    }










}