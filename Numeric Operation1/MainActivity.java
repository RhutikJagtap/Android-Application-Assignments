package com.example.numericoperation1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText et1, ans;
    RadioGroup radioGroup;
    RadioButton radioButton1, radioButton2, radioButton3, radioButton4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.rdGp1);
        radioButton1 = (RadioButton) findViewById(R.id.rdb1);
        radioButton2 = (RadioButton) findViewById(R.id.rdb2);
        radioButton3 = (RadioButton) findViewById(R.id.rdb3);
        radioButton4 = (RadioButton) findViewById(R.id.rdb4);

        et1 = (EditText) findViewById(R.id.et1);
        ans = (EditText) findViewById(R.id.et2);

        Button button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calculate();

            }
        });
    }

    //user define method
    private void calculate() {
        int num = Integer.parseInt(et1.getText().toString());

        if (radioButton1.isChecked()) {
            if (num % 2 == 0) {
                ans.setText(num + " is Even Number");
            } else {
                ans.setText(num + " is Odd Number");
            }

        } else if (radioButton2.isChecked()) {
            if (num > 0) {
                ans.setText(num + " is Positive Number");
            } else {
                ans.setText(num + " is Negative Number");
            }

        } else if (radioButton3.isChecked()) {
            long square;
            square = (long) num * num;
            ans.setText("Square of " + num + " is " + square);
        } else {
            long fact = 1;
            for (int i = 1; i <= num; i++) {
                fact = fact * i;
            }
            ans.setText("Factorial of " + num + " is " + fact);
        }
    }

}