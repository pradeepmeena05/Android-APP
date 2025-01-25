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

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;


public class AgeActivity extends AppCompatActivity {

    public int month_val1, month_val2, day1, day2;
    Spinner spinner1, spinner2, spinner4, spinner5;
    Button btn1, btn2;
    TextView Text1, Text2, Text3, Text4, Text5, Text6, Text7;
    EditText editT1, editT2;
    String text1, text2, text4, text5;


    List<String> months = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_age);

        spinner1 = findViewById(R.id.spinner1);

        spinner2 = findViewById(R.id.spinner2);
        spinner4 = findViewById(R.id.spinner4);
        spinner5 = findViewById(R.id.spinner5);
        Text1 = findViewById(R.id.Text1);
        Text2 = findViewById(R.id.Text2);
        Text3 = findViewById(R.id.Text3);
        Text4 = findViewById(R.id.Text4);
        Text5 = findViewById(R.id.Text5);
        Text6 = findViewById(R.id.Text6);
        Text7 = findViewById(R.id.Text7);
        editT1 = findViewById(R.id.editT1);
        editT2 = findViewById(R.id.editT2);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                spinner1.setDropDownWidth(500);
                spinner1.setGravity(300);
                text1 = parent.getItemAtPosition(position).toString();

                month_val1 = check(text1);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                //Toast.makeText(AgeActivity.this, "Select Month", Toast.LENGTH_SHORT).show();
            }
        });
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, months);
        adapter1.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner1.setAdapter(adapter1);


        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner2.setDropDownWidth(500);
                spinner2.setGravity(300);
                text2 = parent.getItemAtPosition(position).toString();
                // Toast.makeText(AgeActivity.this, text, Toast.LENGTH_SHORT).show();


                day1 = Integer.parseInt(text2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Optional: Handle no selection
                //Toast.makeText(AgeActivity.this, "Select Month", Toast.LENGTH_SHORT).show();
            }
        });
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, numbers);
        adapter2.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner2.setAdapter(adapter2);


        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner4.setDropDownWidth(500);
                spinner4.setGravity(300);
                text4 = parent.getItemAtPosition(position).toString();
//                Toast.makeText(AgeActivity.this, text, Toast.LENGTH_SHORT).show();
                month_val2 = check(text4);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                //Toast.makeText(AgeActivity.this, "Select Month", Toast.LENGTH_SHORT).show();
            }
        });
        ArrayAdapter<String> adapter4 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, months);
        adapter4.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner4.setAdapter(adapter4);


        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinner5.setDropDownWidth(500);
                spinner5.setGravity(300);
                text5 = parent.getItemAtPosition(position).toString();
                //Toast.makeText(AgeActivity.this, text, Toast.LENGTH_SHORT).show();
//                if(text.isEmpty())
//                {
//                    Toast.makeText(AgeActivity.this, "Invalid!_Day", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    day2=Integer.parseInt(text);
//                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Optional: Handle no selection
                //Toast.makeText(AgeActivity.this, "Select Month", Toast.LENGTH_SHORT).show();
            }
        });
        ArrayAdapter<String> adapter5 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, numbers);
        adapter5.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner5.setAdapter(adapter5);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String eT1 = editT1.getText().toString().trim();
                int Year_Val1 = 0;

                if (!eT1.isEmpty()) {
                    Year_Val1 = Integer.parseInt(eT1);
                }
                String eT2 = editT2.getText().toString().trim();
                int Year_Val2 = 0;

                if (!eT2.isEmpty()) {
                    Year_Val2 = Integer.parseInt(eT2);
                }
//                if (month_val2 == 1 &&
//                        month_val1 == 1 &&
//                        day1 == 1 &&
//                        day2 == 1 &&
//                        Year_Val2 == 0 &&
//                        Year_Val1 == 0) {
//                    Toast.makeText(AgeActivity.this, "Please select a valid day, month, or year.", Toast.LENGTH_SHORT).show();
//                }


                if (Year_Val1 != 0 && Year_Val2 != 0) {
                    int Total_Year = Math.abs(Year_Val1 - Year_Val2);
                    Text2.setText("Total Year's" + " " + Total_Year);
                    Text3.setText("Total Week's" + " " + Total_Year * 52);
                    Text4.setText("Total Day's" + " " + (Total_Year * 365));
                    Text5.setText("Total Hour's" + " " + (Total_Year * 8760));
                    Text6.setText("Total Mintu's" + " " + (Total_Year * 525600));
                    Text7.setText("Total Second's" + " " + (Total_Year * 3.154e+7));

                }
                if (Year_Val1 != 0 && Year_Val2 != 0) {
                    int total_month = 0;
                    if (Year_Val1 > Year_Val2 || (Year_Val1 == Year_Val2 && month_val1 >= month_val2)) {
                        total_month = (Year_Val1 - Year_Val2) * 12 + (month_val1 - month_val2);
                        Text1.setText("Total Month's" + " " + total_month);
                        text1 = "";
                        text4 = "";
                        Year_Val1 = 0;
                        Year_Val2 = 0;
                    } else {
                        total_month = (Year_Val2 - Year_Val1) * 12 + (month_val2 - month_val1);
                        Text1.setText("Total Month's" + " " + total_month);
                        text1 = "";
                        text4 = "";
                        Year_Val1 = 0;
                        Year_Val2 = 0;
                    }
                }

                InputMethodManager im = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                if (im != null && getCurrentFocus() != null) {
                    im.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                }


//
//                 if(day1 == day2 || month_val1 == month_val2 || Year_Val1 == Year_Val2) {
//                     if(month_val1 == month_val2) {
//                         Toast.makeText(AgeActivity.this, "Month's are same", Toast.LENGTH_SHORT).show();
//                     } else if(Year_Val2 == Year_Val1) {
//                         Toast.makeText(AgeActivity.this, "Year's are same", Toast.LENGTH_SHORT).show();
//                     } else {
//                         Toast.makeText(AgeActivity.this, "Day's are same", Toast.LENGTH_SHORT).show();
//                     }
//                 }

//                 else {
//                         if(Year_Val1==Year_Val2 && month_val1<=month_val2) {
//                             Text1.setText(String.valueOf("Total_Month's " + String.valueOf(+month_val2 - month_val1 + 1)));
//                             text1 = "";
//                             text4 = "";
//                             Year_Val2=0;
//                             Year_Val2=0;
//                         }
//                         else if(Year_Val1==Year_Val2&& month_val1>=month_val2) {
//                              Toast.makeText(AgeActivity.this,"Select Month "+text4+" First",Toast.LENGTH_SHORT).show();
//                             text1 = "";
//                             text4 = "";
//                             Year_Val2=0;
//                             Year_Val2=0;
//                         } else if (Year_Val1!=Year_Val2&& month_val1>month_val2) {
//                             int year_diff=Math.abs(Year_Val1-Year_Val2);
//                             Text1.setText(String.valueOf("Total_Month's " + String.valueOf(((12 - month_val1+1) + month_val2)*year_diff)));
//                             text1 = "";
//                             text4 = "";
//                             Year_Val2=0;
//                             Year_Val2=0;
//
//                         }
//                         else if (Year_Val1!=Year_Val2&& month_val1<month_val2) {
//                             int year_diff=Math.abs(Year_Val1-Year_Val2);
//                             Text1.setText(String.valueOf("Total_Month's " + String.valueOf(((12 - month_val1 + 1) + month_val2) * year_diff)));
//                             text1 = "";
//                             text4 = "";
//                             Year_Val2 = 0;
//                             Year_Val2 = 0;
//                         }
//                         else if (Year_Val1!=Year_Val2&& month_val1>month_val2) {
//                             int year_diff=Math.abs(Year_Val1-Year_Val2);
//                             Text1.setText(String.valueOf("Total_Month's " + String.valueOf(((12 - month_val1 + 1) + month_val2) * year_diff)));
//                             text1 = "";
//                             text4 = "";
//                             Year_Val2 = 0;
//                             Year_Val2 = 0;
//                         }
//                         else if (Year_Val1!=Year_Val2&& month_val1==month_val2) {
//                             int year_diff=Math.abs(Year_Val1-Year_Val2);
//                             Text1.setText(String.valueOf("Total_Month's " + String.valueOf( 12* year_diff)));
//                             text1 = "";
//                             text4 = "";
//                             Year_Val2 = 0;
//                             Year_Val2 = 0;
//                         }
//                 }


            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editT1.setText(" ");
                editT2.setText(" ");
                spinner1.setSelection(0);
                spinner2.setSelection(0);
                spinner4.setSelection(0);
                spinner5.setSelection(0);
                Text1.setText(" ");
                Text2.setText(" ");
                Text3.setText(" ");
                Text4.setText(" ");
                Text5.setText(" ");
                Text6.setText(" ");
                Text7.setText(" ");

            }
        });


    }


    public int check(String str) {
        str = str.toLowerCase();
        int current_month = 0;
        switch (str) {
            case "january":
                current_month = 1;
                break;
            case "february":
                current_month = 2;
                break;
            case "march":
                current_month = 3;
                break;
            case "april":
                current_month = 4;
                break;
            case "may":
                current_month = 5;
                break;
            case "june":
                current_month = 6;
                break;
            case "july":
                current_month = 7;
                break;
            case "august":
                current_month = 8;
                break;
            case "september":
                current_month = 9;
                break;
            case "october":
                current_month = 10;
                break;
            case "november":
                current_month = 11;
                break;
            case "december":
                current_month = 12;
                break;
            default:
                Toast.makeText(AgeActivity.this, "Invalid month selected", Toast.LENGTH_SHORT).show();
                break;
        }
        return current_month;
    }
}