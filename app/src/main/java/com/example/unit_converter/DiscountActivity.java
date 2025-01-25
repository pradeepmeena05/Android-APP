package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DiscountActivity extends AppCompatActivity {

    EditText original_price, discount_percentage;
    TextView final_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount);

        original_price = findViewById(R.id.original_price);
        discount_percentage = findViewById(R.id.discount_percentage);
        final_price = findViewById(R.id.final_price);

        discount_percentage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String original = original_price.getText().toString();
                String dis = discount_percentage.getText().toString();

                if (!original.isEmpty() && !dis.isEmpty()) {
                    double originalPrice = Double.parseDouble(original);
                    double discount = Double.parseDouble(dis);
                    double finalPrice = originalPrice * (1 - (discount / 100));
                    final_price.setText(String.format("%.2f", finalPrice));
                } else {
                    final_price.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        original_price.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String original = original_price.getText().toString();
                String dis = discount_percentage.getText().toString();

                if (!original.isEmpty() && !dis.isEmpty()) {
                    double originalPrice = Double.parseDouble(original);
                    double discount = Double.parseDouble(dis);
                    double finalPrice = originalPrice * (1 - (discount / 100));
                    final_price.setText(String.format("%.2f", finalPrice));
                } else {
                    final_price.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }
}
