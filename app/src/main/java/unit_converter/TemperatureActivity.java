package unit_converter;

import android.os.Bundle;
import android.view.View;
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

public class TemperatureActivity extends AppCompatActivity {


    List<String> list = Arrays.asList("Degree Celsius", "Degree Fahrenheit", "Degree Reaumur", "Degree Rankine","Degree Kelvin");

    EditText valueInput;
    Spinner unitFromSpinner, unitToSpinner;
    Button convertButton, resetbtn;
    TextView resultTextView;

    String SelectedItem1, SelectedItem2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_temperature);

        valueInput = findViewById(R.id.valueInput);
        unitFromSpinner = findViewById(R.id.unitFromSpinner);
        unitToSpinner = findViewById(R.id.unitToSpinner);
        convertButton = findViewById(R.id.convertButton);
        resetbtn = findViewById(R.id.resetbtn);
        resultTextView = findViewById(R.id.resultTextView);

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


        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitFromSpinner.setAdapter(adapter);
        unitToSpinner.setAdapter(adapter);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String input=valueInput.getText().toString();
                Double inputVal=Double.parseDouble(input);


                if(input.isEmpty())
                {
                    Toast.makeText(TemperatureActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                }
                else if(SelectedItem1.equals("Degree Celsius"))
                {

                    Double result=checkCelsius(SelectedItem2,inputVal);

                    resultTextView.setText(SelectedItem2+" = "+result);
                }
                else if(SelectedItem1.equals("Degree Fahrenheit"))
                {

                    Double result=checkFahrenheit(SelectedItem2,inputVal);

                    resultTextView.setText(SelectedItem2+" = "+result);
                }
                else if(SelectedItem1.equals("Degree Reaumur"))
                {

                    Double result=checkReaumur(SelectedItem2,inputVal);

                    resultTextView.setText(SelectedItem2+" = "+result);
                }
                else if(SelectedItem1.equals("Degree Rankine"))
                {

                    Double result=checkRankine(SelectedItem2,inputVal);

                    resultTextView.setText(SelectedItem2+" = "+result);
                }
                else if(SelectedItem1.equals("Degree Kelvin"))
                {

                    Double result=checkKelvin(SelectedItem2,inputVal);

                    resultTextView.setText(SelectedItem2+" = "+result);
                }


            }
        });

        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueInput.setText(" ");
                unitFromSpinner.setSelection(0);
                unitToSpinner.setSelection(0);
                resultTextView.setText(" ");
            }
        });



    }

    public double checkCelsius(String str,double input)
    {
        switch(str)
        {
            case "Degree Fahrenheit":
                return (input*9/5)+32;
            case "Degree Reaumur":
                return (input*4/5);
            case "Degree Rankine":
                return (input+273.15)*9/5;
            case "Degree Kelvin":
                return (input+273.15);

        }
        return 0.0;
    }
    public double checkFahrenheit(String str,double input)
    {
        switch(str)
        {
            case "Degree Celsius":
                return (input-32)*5/9;
            case "Degree Reaumur":
                return (input-32)*4/9;
            case "Degree Rankine":
                return (input+459.67);
            case "Degree Kelvin":
                return (input-32)*5/9+273.15;

        }
        return 0.0;
    }
    public double checkReaumur(String str,double input)
    {
        switch(str)
        {
            case "Degree Celsius":
                return input*5/4;
            case "Degree Fahrenheit":
                return (input*9/4)+32;
            case "Degree Rankine":
                return (input*9/4)+491.67;
            case "Degree Kelvin":
                return (input*5/4)+273.15;

        }
        return 0.0;
    }
    public double checkRankine(String str,double input)
    {
        switch(str)
        {
            case "Degree Celsius":
                return (input-491.67)*5/9;
            case "Degree Fahrenheit":
                return (input)-459.67;
            case "Degree Reaumur":
                return (input-491.67)*4/9;
            case "Degree Kelvin":
                return (input*5/9);

        }
        return 0.0;
    }
    public double checkKelvin(String str,double input)
    {
        switch(str)
        {
            case "Degree Celsius":
                return (input-273.15);
            case "Degree Fahrenheit":
                return (input-273.15)*9/5+32;
            case "Degree Reaumur":
                return (input-273.15)*4/5;
            case "Degree Kelvin":
                return (input*9/5);

        }
        return 0.0;
    }
}