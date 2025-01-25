package unit_converter;

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

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class LengthActivity extends AppCompatActivity {

    String spinner1Text, spinner2Text;
    List<String> list1 = Arrays.asList("Kilometre", "Metre", "Centimetre", "Millimetre", "Micrometre", "Nanometre", "Mile", "Yard", "Foot", "Inch", "Decimetre");

    Spinner unitFromSpinner;
    Spinner unitToSpinner;
    EditText valueInput;
    Button convertButton,reset;
    TextView resultText;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_length);

        valueInput = findViewById(R.id.valueInput);
        unitFromSpinner = findViewById(R.id.unitFromSpinner);
        unitToSpinner = findViewById(R.id.unitToSpinner);
        convertButton = findViewById(R.id.convertButton);
        resultText = findViewById(R.id.resultTextView);
        reset=findViewById(R.id.resetbtn);


        unitFromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                unitFromSpinner.setDropDownWidth(400);
                spinner1Text = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        unitToSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                unitToSpinner.setDropDownWidth(400);
                spinner2Text = adapterView.getItemAtPosition(i).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, list1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitFromSpinner.setAdapter(adapter1);
        unitToSpinner.setAdapter(adapter1);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputValue = valueInput.getText().toString();
                if (inputValue.isEmpty()) {
                    Toast.makeText(LengthActivity.this, "Please enter a value", Toast.LENGTH_SHORT).show();
                    return;
                }

                double inputVal = Double.parseDouble(inputValue);
                double result=0;

                if (inputVal== -1) {
                    Toast.makeText(LengthActivity.this, "Invalid unit selected", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(spinner1Text=="Kilometre")
                {
                    result = checkForKm( inputVal, spinner2Text);
                    resultText.setText(result + " " + spinner2Text);
                }
                else if(spinner1Text=="Metre")
                {
                    result = checkForMetre( inputVal, spinner2Text);
                    result = Math.round(result * 1e6) / 1e6;
                    resultText.setText(result + " " + spinner2Text);

                }
                else if(spinner1Text=="Centimetre")
                {
                    result = checkForCentimetre( inputVal, spinner2Text);
                    result = Math.round(result * 1e6) / 1e6;
                    resultText.setText(result + " " + spinner2Text);

                }
                else if(spinner1Text=="Milimetre")
                {
                    result = checkForMillimetre( inputVal, spinner2Text);
                    result = Math.round(result * 1e6) / 1e6;
                    resultText.setText(result + " " + spinner2Text);

                }
                else if(spinner1Text=="Micrometre")
                {
                    result = checkForMicrometre( inputVal, spinner2Text);
                    result = Math.round(result * 1e6) / 1e6;
                    resultText.setText(result + " " + spinner2Text);

                }
                else if(spinner1Text=="Nanoometre")
                {
                    result = checkForNanometre( inputVal, spinner2Text);
                    result = Math.round(result * 1e6) / 1e6;
                    resultText.setText(result + " " + spinner2Text);

                }
                else if(spinner1Text=="Mile")
                {
                    result = checkForMile( inputVal, spinner2Text);
                    result = Math.round(result * 1e6) / 1e6;
                    resultText.setText(result + " " + spinner2Text);

                }
                else if(spinner1Text=="Yard")
                {
                    result = checkForYard( inputVal, spinner2Text);
                    result = Math.round(result * 1e6) / 1e6;
                    resultText.setText(result + " " + spinner2Text);

                }
                else if(spinner1Text=="Foot")
                {
                    result = checkForFoot( inputVal, spinner2Text);
                    result = Math.round(result * 1e6) / 1e6;
                    resultText.setText(result + " " + spinner2Text);

                }
                else if(spinner1Text=="Inch")
                {
                    result = checkForInch( inputVal, spinner2Text);
                    result = Math.round(result * 1e6) / 1e6;
                    resultText.setText(result + " " + spinner2Text);

                }
                else if(spinner1Text=="Decimetre")
                {
                    result = checkForDecimetre( inputVal, spinner2Text);
                    result = Math.round(result * 1e6) / 1e6;
                    resultText.setText(result + " " + spinner2Text);

                }

                InputMethodManager im=(InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

                if(im!=null&& getCurrentFocus()!=null)

                {
                     im.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
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


    public double checkForKm(double km, String otherUnit) {
        switch (otherUnit) {
            case "Metre":
                return 1000 * km;

            case "Centimetre":
                return km * 100000;

            case "Millimetre":
                return km * 1000000;

            case "Micrometre":
                return km * 1000000000;

            case "Nanometre":
                return km * 1000000000000.0;

            case "Mile":
                return km * 0.621371;

            case "Yard":
                return km * 1093.613;

            case "Foot":
                return km * 3280.84;

            case "Inch":
                return km * 39370.0787;

            case "Decimetre":
                return km * 10000;

            default:
                return -1;
        }
    }
    public double checkForMetre(double m, String otherUnit) {
        switch (otherUnit) {
            case "Kilometre":
                return  m*0.0011;

            case "Centimetre":
                return m * 100;

            case "Millimetre":
                return m * 1000;

            case "Micrometre":
                return m * 1000000;

            case "Nanometre":
                return m * 1000000000.0;

            case "Mile":
                return m * 0.621371;

            case "Yard":
                return m * 1093.613;

            case "Foot":
                return m * 3280.84;

            case "Inch":
                return m * 39370.0787;

            case "Decimetre":
                return m * 10;

            default:
                return -1;
        }
    }
    public double checkForCentimetre(double value, String unit) {
        switch (unit) {
            case "Kilometre":
                return value * 100000;

            case "Centimetre":
                return value;

            case "Millimetre":
                return value * 0.1;

            case "Micrometre":
                return value * 0.0001;

            case "Nanometre":
                return value * 0.0000001;

            case "Mile":
                return value * 160934.4;

            case "Yard":
                return value * 91.44;

            case "Foot":
                return value * 30.48;

            case "Inch":
                return value * 2.54;

            case "Decimetre":
                return value * 10;

            default:
                return -1;
        }
    }
    public double checkForMillimetre(double value, String unit) {
        switch (unit) {
            case "Kilometre":
                return value / 1000000;

            case "Centimetre":
                return value / 10;

            case "Millimetre":
                return value;

            case "Micrometre":
                return value * 1000;

            case "Nanometre":
                return value * 1000000;

            case "Mile":
                return value / 1609344;

            case "Yard":
                return value / 914.4;

            case "Foot":
                return value / 304.8;

            case "Inch":
                return value / 25.4;

            case "Decimetre":
                return value / 100;

            default:
                return -1;
        }
    }
    public double checkForMicrometre(double value, String unit) {
        switch (unit) {
            case "Kilometre":
                return value / 1000000000;

            case "Centimetre":
                return value / 10000;

            case "Millimetre":
                return value / 1000;

            case "Micrometre":
                return value;

            case "Nanometre":
                return value * 1000;

            case "Mile":
                return value / 1609344000;

            case "Yard":
                return value / 914400;

            case "Foot":
                return value / 304800;

            case "Inch":
                return value / 25400;

            case "Decimetre":
                return value / 10000;

            default:
                return -1;
        }
    }
    public double checkForNanometre(double value, String unit) {
        switch (unit) {
            case "Kilometre":
                return value / 1000000000000.0;

            case "Centimetre":
                return value / 10000000;

            case "Millimetre":
                return value / 1000000;

            case "Micrometre":
                return value / 1000;

            case "Nanometre":
                return value;

            case "Mile":
                return value / 1609344000000.0;

            case "Yard":
                return value / 914400000;

            case "Foot":
                return value / 304800000;

            case "Inch":
                return value / 25400000;

            case "Decimetre":
                return value / 10000000;

            default:
                return -1;
        }
    }
    public double checkForMile(double value, String targetUnit) {
        switch (targetUnit) {
            case "Kilometre":
                return value / 0.621371;
            case "Centimetre":
                return value * 160934.4;
            case "Millimetre":
                return value * 1609344;
            case "Micrometre":
                return value * 1609344000;
            case "Nanometre":
                return value * 1609344000000.0;
            case "Mile":
                return value;
            case "Yard":
                return value * 1760;
            case "Foot":
                return value * 5280;
            case "Inch":
                return value * 63360;
            case "Decimetre":
                return value * 1609344;

            default: return -1;
        }
    }
    public double checkForYard(double value, String targetUnit) {
        switch (targetUnit) {
            case "Kilometre":
                return value / 1093.613;
            case "Centimetre":
                return value * 91.44;
            case "Millimetre":
                return value * 914.4;
            case "Micrometre":
                return value * 914400;
            case "Nanometre":
                return value * 914400000;
            case "Mile":
                return value / 1760;
            case "Yard":
                return value;
            case "Foot":
                return value * 3;
            case "Inch":
                return value * 36;
            case "Decimetre":
                return value * 9.144;
            default: return -1;
        }
    }
    public double checkForFoot(double value, String targetUnit) {
        switch (targetUnit) {
            case "Kilometre":
                return value / 3280.84;
            case "Centimetre":
                return value * 30.48;
            case "Millimetre":
                return value * 304.8;
            case "Micrometre":
                return value * 304800;
            case "Nanometre":
                return value * 304800000;
            case "Mile":
                return value / 5280;
            case "Yard":
                return value / 3;
            case "Foot":
                return value;
            case "Inch":
                return value * 12;
            case "Decimetre":
                return value * 3.048;
            default: return -1;
        }
    }
    public double checkForInch(double value, String targetUnit) {
        switch (targetUnit) {
            case "Kilometre":
                return value / 39370.0787;
            case "Centimetre":
                return value * 2.54;
            case "Millimetre":
                return value * 25.4;
            case "Micrometre":
                return value * 25400;
            case "Nanometre":
                return value * 25400000;
            case "Mile":
                return value / 63360;
            case "Yard":
                return value / 36;
            case "Foot":
                return value / 12;
            case "Inch":
                return value;
            case "Decimetre":
                return value / 10;
            default: return -1;
        }
    }
    public double checkForDecimetre(double value, String targetUnit) {
        switch (targetUnit) {
            case "Kilometre":
                return value / 10000;
            case "Centimetre":
                return value * 10;
            case "Millimetre":
                return value * 100;
            case "Micrometre":
                return value * 10000;
            case "Nanometre":
                return value * 10000000;
            case "Mile":
                return value / 1609344;
            case "Yard":
                return value / 914.4;
            case "Foot":
                return value / 304.8;
            case "Inch":
                return value / 25.4;
            case "Decimetre":
                return value;
            default: return -1;
        }
    }

}
