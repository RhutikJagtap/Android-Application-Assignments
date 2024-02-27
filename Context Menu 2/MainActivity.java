package com.example.contextmenu2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    TextView tv1;
    Button b1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.e1);
        b1 = findViewById(R.id.btn);
        tv1 = findViewById(R.id.r1);
        b1.setOnCreateContextMenuListener(this);

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(1, 1, 1, "Factorial");
        menu.add(1, 2, 2, "Sum of Digit");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int num = Integer.parseInt(et1.getText().toString());
        switch (item.getTitle().toString()) {
            case "Factorial":
                long fact = 1;
                for (int i = 1; i <= num; i++) {
                    fact = fact * i;
                }
                tv1.setText("Factorail of a " + num + " is " + fact);
                Toast.makeText(getBaseContext(), "Factorial calculated ", Toast.LENGTH_SHORT).show();
                break;

            case "Sum of Digit":

                int sum = 0;
                int original_num = num;

                while (num > 0) {
                    int digit = num % 10;
                    sum = sum + digit;
                    num = num / 10;
                }
                tv1.setText("Sum of digit of Number " + original_num + " is " + sum);
                Toast.makeText(getBaseContext(), "Sum of Digit ", Toast.LENGTH_SHORT).show();
                break;

        }


        return super.onContextItemSelected(item);
    }
}