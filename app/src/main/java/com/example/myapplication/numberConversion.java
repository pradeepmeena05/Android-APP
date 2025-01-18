package com.example.myapplication;

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

public class numberConversion extends AppCompatActivity {

    List<String> list = Arrays.asList("Binary", "Decimal", "Octal", "HexDecimal");

    EditText valueInput;
    Spinner unitFromSpinner, unitToSpinner;
    Button convertButton, resetbtn;
    TextView resultTextView;

    String SelectedItem1, SelectedItem2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_conversion);

        valueInput = findViewById(R.id.valueInput);
        unitFromSpinner = findViewById(R.id.unitFromSpinner);
        unitToSpinner = findViewById(R.id.unitToSpinner);
        convertButton = findViewById(R.id.convertButton);
        resetbtn = findViewById(R.id.resetbtn);
        resultTextView = findViewById(R.id.resultTextView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        unitFromSpinner.setAdapter(adapter);
        unitToSpinner.setAdapter(adapter);

        unitFromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SelectedItem1 = adapterView.getItemAtPosition(i).toString();
                unitFromSpinner.setDropDownWidth(400);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        unitToSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SelectedItem2 = adapterView.getItemAtPosition(i).toString();
                unitToSpinner.setDropDownWidth(400);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = valueInput.getText().toString();

                if (input.isEmpty()) {
                    Toast.makeText(numberConversion.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                } else if (SelectedItem1.equals("Binary")) {
                    String result = BinarytoAll(SelectedItem2, input);
                    resultTextView.setText(SelectedItem2 + " value is " + result);
                } else if (SelectedItem1.equals("Decimal")) {
                    if (SelectedItem2.equals("HexDecimal")) {
                        int deci = Integer.parseInt(input);
                        resultTextView.setText(SelectedItem2 + " value is " + Integer.toHexString(deci).toUpperCase());
                    } else {
                        String result = DecimaltoAll(SelectedItem2, input);
                        resultTextView.setText(SelectedItem2 + " value is " + result);
                    }
                } else if (SelectedItem1.equals("Octal")) {
                    if (SelectedItem2.equals("HexDecimal")) {
                        int deci = Integer.parseInt(input, 8);
                        resultTextView.setText(SelectedItem2 + " value is " + Integer.toHexString(deci).toUpperCase());
                    } else {
                        String result = OctaltoAll(SelectedItem2, input);
                        resultTextView.setText(SelectedItem2 + " value is " + result);
                    }
                } else if (SelectedItem1.equals("HexDecimal")) {
                    if (SelectedItem2.equals("Decimal")) {
                        int deci = Integer.parseInt(input, 16);
                        resultTextView.setText(SelectedItem2 + " value is " + deci);
                    } else if (SelectedItem2.equals("Binary")) {
                        int deci = Integer.parseInt(input, 16);
                        resultTextView.setText(SelectedItem2 + " value is " + Integer.toBinaryString(deci));
                    } else if (SelectedItem2.equals("Octal")) {
                        int deci = Integer.parseInt(input, 16);
                        resultTextView.setText(SelectedItem2 + " value is " + Integer.toOctalString(deci));
                    }
                }
                InputMethodManager im=(InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

                if(im!=null&& getCurrentFocus()!=null)

                {
                    im.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
                }
            }

        });

        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unitFromSpinner.setSelection(0);
                unitToSpinner.setSelection(0);
                valueInput.setText(" ");
                resultTextView.setText(" ");

            }
        });
    }

    public String BinarytoAll(String value, String inputValue) {
        switch (value) {
            case "Decimal":
                return String.valueOf(Integer.parseInt(inputValue, 2));
            case "HexDecimal":
                return Integer.toHexString(Integer.parseInt(inputValue, 2)).toUpperCase();
            case "Octal":
                return Integer.toOctalString(Integer.parseInt(inputValue, 2));
        }
        return "Invalid Conversion";
    }

    public String DecimaltoAll(String value, String inputValue) {
        int decimalValue = Integer.parseInt(inputValue);
        switch (value) {
            case "Binary":
                return Integer.toBinaryString(decimalValue);
            case "HexDecimal":
                return Integer.toHexString(decimalValue).toUpperCase();
            case "Octal":
                return Integer.toOctalString(decimalValue);
        }
        return "Invalid Conversion";
    }

    public String OctaltoAll(String value, String inputValue) {
        int decimalValue = Integer.parseInt(inputValue, 8);
        switch (value) {
            case "Binary":
                return Integer.toBinaryString(decimalValue);
            case "Decimal":
                return String.valueOf(decimalValue);
            case "HexDecimal":
                return Integer.toHexString(decimalValue).toUpperCase();
        }
        return "Invalid Conversion";
    }
}
