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

public class TimeActivity extends AppCompatActivity {
    String spinner1Text, spinner2Text;
    List<String> timeUnits = Arrays.asList("Millisecond", "Second", "Minute", "Hour", "Day", "Week", "Month", "Quarter", "Year", "Decade");

    Spinner unitFromSpinner;
    Spinner unitToSpinner;
    EditText valueInput;
    Button convertButton, reset;
    TextView resultText;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        valueInput = findViewById(R.id.valueInput);
        unitFromSpinner = findViewById(R.id.unitFromSpinner);
        unitToSpinner = findViewById(R.id.unitToSpinner);
        convertButton = findViewById(R.id.convertButton);
        resultText = findViewById(R.id.resultTextView);
        reset = findViewById(R.id.resetbtn);

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

        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, timeUnits);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitFromSpinner.setAdapter(adapter1);
        unitToSpinner.setAdapter(adapter1);

        convertButton.setOnClickListener(view -> {
            String inputValue = valueInput.getText().toString();
            if (inputValue.isEmpty()) {
                Toast.makeText(TimeActivity.this, "Please enter a value", Toast.LENGTH_SHORT).show();
                return;
            }

            double inputVal;
            try {
                inputVal = Double.parseDouble(inputValue);
            } catch (NumberFormatException e) {
                Toast.makeText(TimeActivity.this, "Please enter a valid number", Toast.LENGTH_SHORT).show();
                return;
            }

            double result;
            switch (spinner1Text) {
                case "Millisecond":
                    result = checkForMili(inputVal, spinner2Text);
                    break;
                case "Second":
                    result = checkForSec(inputVal, spinner2Text);
                    break;
                case "Minute":
                    result = checkForMin(inputVal, spinner2Text);
                    break;
                case "Hour":
                    result = checkForHour(inputVal, spinner2Text);
                    break;
                case "Day":
                    result = checkForDay(inputVal, spinner2Text);
                    break;
                case "Week":
                    result = checkForWeek(inputVal, spinner2Text);
                    break;
                case "Month":
                    result = checkForMonth(inputVal, spinner2Text);
                    break;
                case "Year":
                    result = checkForYear(inputVal, spinner2Text);
                    break;
                case "Quarter":
                    result = checkForQuar(inputVal, spinner2Text);
                    break;
                case "Decade":
                    result = checkForDecade(inputVal, spinner2Text);
                    break;
                default:
                    result = 0.0;
                    break;
            }
            result = Math.round(result * 1e6) / 1e6;
            resultText.setText(result + " " + spinner2Text);

            InputMethodManager im = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            if (im != null && getCurrentFocus() != null) {
                im.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        });

        reset.setOnClickListener(view -> {
            unitFromSpinner.setSelection(0);
            unitToSpinner.setSelection(0);
            valueInput.setText("");
            resultText.setText("");
        });
    }

    public double checkForMili(double input, String str) {
        switch (str) {
            case "Second":
                return input / 1000;
            case "Minute":
                return input / 60000;
            case "Hour":
                return input / 3600000;
            case "Day":
                return input / 86400000;
            case "Week":
                return input / 604800000;
            case "Month":
                return input / 2629746000.0;
            case "Quarter":
                return input / 7889238000.0;
            case "Year":
                return input / 31556952000.0;
            case "Decade":
                return input / 315569520000.0;
            default:
                return 0.0;
        }
    }

    public double checkForSec(double input, String str) {
        switch (str) {
            case "Millisecond":
                return input * 1000;
            case "Minute":
                return input / 60;
            case "Hour":
                return input / 3600;
            case "Day":
                return input / 86400;
            case "Week":
                return input / 604800;
            case "Month":
                return input / 2629746;
            case "Quarter":
                return input / 7889238;
            case "Year":
                return input / 31556952;
            case "Decade":
                return input / 315569520;
            default:
                return 0.0;
        }
    }

    public double checkForMin(double input, String str) {
        switch (str) {
            case "Millisecond":
                return input * 60000;
            case "Second":
                return input * 60;
            case "Hour":
                return input / 60;
            case "Day":
                return input / 1440;
            case "Week":
                return input / 10080;
            case "Month":
                return input / 43800;
            case "Quarter":
                return input / 131400;
            case "Year":
                return input / 525600;
            case "Decade":
                return input / 5256000;
            default:
                return 0.0;
        }
    }

    public double checkForHour(double input, String str) {
        switch (str) {
            case "Millisecond":
                return input * 3600000;
            case "Second":
                return input * 3600;
            case "Minute":
                return input * 60;
            case "Day":
                return input / 24;
            case "Week":
                return input / 168;
            case "Month":
                return input / 730;
            case "Quarter":
                return input / 2190;
            case "Year":
                return input / 8760;
            case "Decade":
                return input / 87600;
            default:
                return 0.0;
        }
    }

    public double checkForDay(double input, String str) {
        switch (str) {
            case "Millisecond":
                return input * 86400000;
            case "Second":
                return input * 86400;
            case "Minute":
                return input * 1440;
            case "Hour":
                return input * 24;
            case "Week":
                return input * 7;
            case "Month":
                return input * 30.44;
            case "Quarter":
                return input * 91.31;
            case "Year":
                return input * 365.25;
            case "Decade":
                return input * 3652.5;
            default:
                return 0.0;
        }
    }

    public double checkForWeek(double input, String str) {
        switch (str) {
            case "Millisecond":
                return input * 604800000;
            case "Second":
                return input * 604800;
            case "Minute":
                return input * 10080;
            case "Hour":
                return input * 168;
            case "Day":
                return input * 7;
            case "Month":
                return input / 4.34524;
            case "Quarter":
                return input / 13.0357;
            case "Year":
                return input / 52.1775;
            case "Decade":
                return input / 521.775;
            default:
                return 0.0;
        }
    }

    public double checkForMonth(double input, String str) {
        switch (str) {
            case "Millisecond":
                return input * 2629746000.0;
            case "Second":
                return input * 2629746;
            case "Minute":
                return input * 43800;
            case "Hour":
                return input * 730;
            case "Day":
                return input * 30.44;
            case "Week":
                return input * 4.34524;
            case "Quarter":
                return input / 3;
            case "Year":
                return input / 12;
            case "Decade":
                return input / 120;
            default:
                return 0.0;
        }
    }

    public double checkForYear(double input, String str) {
        switch (str) {
            case "Millisecond":
                return input * 31556952000.0;
            case "Second":
                return input * 31556952;
            case "Minute":
                return input * 525600;
            case "Hour":
                return input * 8760;
            case "Day":
                return input * 365.25;
            case "Week":
                return input * 52.1775;
            case "Month":
                return input * 12;
            case "Quarter":
                return input * 4;
            case "Decade":
                return input * 10;
            default:
                return 0.0;
        }
    }

    public double checkForQuar(double input, String str) {
        switch (str) {
            case "Millisecond":
                return input * 7889238000.0;
            case "Second":
                return input * 7889238;
            case "Minute":
                return input * 131480;
            case "Hour":
                return input * 2190;
            case "Day":
                return input * 91.31;
            case "Week":
                return input * 13.0357;
            case "Month":
                return input * 3;
            case "Year":
                return input / 4;
            case "Decade":
                return input / 40;
            default:
                return 0.0;
        }
    }

    public double checkForDecade(double input, String str) {
        switch (str) {
            case "Millisecond":
                return input * 315569520000.0;
            case "Second":
                return input * 315569520;
            case "Minute":
                return input * 5256000;
            case "Hour":
                return input * 87600;
            case "Day":
                return input * 3652.5;
            case "Week":
                return input * 521.775;
            case "Month":
                return input * 120;
            case "Quarter":
                return input * 40;
            case "Year":
                return input * 10;
            default:
                return 0.0;
        }
    }
}
