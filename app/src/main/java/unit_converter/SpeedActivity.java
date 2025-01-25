package unit_converter;

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

public class SpeedActivity extends AppCompatActivity {

    List<String> speedUnits = Arrays.asList(
            "Metre/second (m/s)",
            "Kilometre/second (km/s)",
            "Kilometre/hour (km/h)",
            "Speed of light (c)",
            "Mile/hour (mph)",
            "Mach (Ma)",
            "Inch/second (in/s)"
    );

    EditText valueInput;
    Spinner unitFromSpinner, unitToSpinner;
    Button convertButton, resetting;
    TextView resultTextView;

    String selectedUnitFrom, selectedUnitTo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spped);

        valueInput = findViewById(R.id.valueInput);
        unitFromSpinner = findViewById(R.id.unitFromSpinner);
        unitToSpinner = findViewById(R.id.unitToSpinner);
        convertButton = findViewById(R.id.convertButton);
        resetting = findViewById(R.id.resetbtn);
        resultTextView = findViewById(R.id.resultTextView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, speedUnits);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        unitFromSpinner.setAdapter(adapter);
        unitToSpinner.setAdapter(adapter);

        unitFromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedUnitFrom = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        unitToSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedUnitTo = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        convertButton.setOnClickListener(view -> {
            String input = valueInput.getText().toString().trim();
            if (input.isEmpty()) {
                Toast.makeText(SpeedActivity.this, "Please enter a valid input", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                double inputVal = Double.parseDouble(input);
                double result = convertSpeed(selectedUnitFrom, selectedUnitTo, inputVal);
                resultTextView.setText(String.format("%.4f %s", result, selectedUnitTo));
            } catch (NumberFormatException e) {
                Toast.makeText(SpeedActivity.this, "Invalid input format", Toast.LENGTH_SHORT).show();
            }

            InputMethodManager imm=(InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            if(imm!=null)
            {
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
            }
        });

        resetting.setOnClickListener(view -> {
            unitFromSpinner.setSelection(0);
            unitToSpinner.setSelection(0);
            valueInput.setText("");
            resultTextView.setText("");
        });
    }

    public double convertSpeed(String fromUnit, String toUnit, double input) {
        if (fromUnit.equals(toUnit)) return input;

        switch (fromUnit) {
            case "Metre/second (m/s)":
                return msToAll(toUnit, input);
            case "Kilometre/second (km/s)":
                return ksToAll(toUnit, input);
            case "Kilometre/hour (km/h)":
                return khToAll(toUnit, input);
            case "Speed of light (c)":
                return spToAll(toUnit, input);
            case "Mile/hour (mph)":
                return mhToAll(toUnit, input);
            case "Inch/second (in/s)":
                return isToAll(toUnit, input);
            case "Mach (Ma)":
                return maToAll(toUnit, input);
        }
        return 0.0;
    }

    public double msToAll(String str, double input) {
        switch (str) {
            case "Kilometre/second (km/s)":
                return input * 0.001;
            case "Kilometre/hour (km/h)":
                return input * 3.6;
            case "Speed of light (c)":
                return input / 299792458;
            case "Mile/hour (mph)":
                return input * 2.23694;
            case "Mach (Ma)":
                return input / 343;
            case "Inch/second (in/s)":
                return input * 39.3701;
        }
        return 0.0;
    }

    public double ksToAll(String str, double input) {
        switch (str) {
            case "Metre/second (m/s)":
                return input * 1000;
            case "Kilometre/hour (km/h)":
                return input * 3600;
            case "Speed of light (c)":
                return input / 299792.458;
            case "Mile/hour (mph)":
                return input * 2236.94;
            case "Mach (Ma)":
                return input * 2.9387;
            case "Inch/second (in/s)":
                return input * 39370.1;
        }
        return 0.0;
    }

    public double khToAll(String str, double input) {
        switch (str) {
            case "Metre/second (m/s)":
                return input / 3.6;
            case "Kilometre/second (km/s)":
                return input / 3600;
            case "Speed of light (c)":
                return input / 1079252848.8;
            case "Mile/hour (mph)":
                return input * 0.621371;
            case "Mach (Ma)":
                return input * 0.000816297;
            case "Inch/second (in/s)":
                return input * 10.9361;
        }
        return 0.0;
    }

    public double spToAll(String str, double input) {
        switch (str) {
            case "Metre/second (m/s)":
                return input * 299792458;
            case "Kilometre/second (km/s)":
                return input * 299792.458;
            case "Kilometre/hour (km/h)":
                return input * 1079252848.8;
            case "Mile/hour (mph)":
                return input * 670616629.384;
            case "Mach (Ma)":
                return input * 880991.1;
            case "Inch/second (in/s)":
                return input * 1.1802852e10;
        }
        return 0.0;
    }

    public double mhToAll(String str, double input) {
        switch (str) {
            case "Metre/second (m/s)":
                return input * 0.44704;
            case "Kilometre/second (km/s)":
                return input * 0.00044704;
            case "Speed of light (c)":
                return input / 670616629.384;
            case "Kilometre/hour (km/h)":
                return input * 1.60934;
            case "Mach (Ma)":
                return input * 0.000131151;
            case "Inch/second (in/s)":
                return input * 17.6;
        }
        return 0.0;
    }

    public double isToAll(String str, double input) {
        switch (str) {
            case "Metre/second (m/s)":
                return input * 0.0254;
            case "Kilometre/second (km/s)":
                return input * 0.0000254;
            case "Kilometre/hour (km/h)":
                return input * 0.09144;
            case "Speed of light (c)":
                return input / 1.1802852e10;
            case "Mile/hour (mph)":
                return input * 0.0568182;
            case "Mach (Ma)":
                return input * 0.000074175;
        }
        return 0.0;
    }

    public double maToAll(String str, double input) {
        switch (str) {
            case "Metre/second (m/s)":
                return input * 343;
            case "Kilometre/second (km/s)":
                return input * 0.343;
            case "Kilometre/hour (km/h)":
                return input * 1234.8;
            case "Speed of light (c)":
                return input / 880991.1;
            case "Mile/hour (mph)":
                return input * 767.269;
            case "Inch/second (in/s)":
                return input * 13503.937;
        }
        return 0.0;
    }
}
