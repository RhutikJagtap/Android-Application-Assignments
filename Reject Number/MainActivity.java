package com.example.rejectnumbers;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button b;
    TextView tv;
    EditText et1, et2;
    int n1, n2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button) findViewById(R.id.b);
        tv = (TextView) findViewById(R.id.tv);

        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(et1.getText().toString());
                int n2 = Integer.parseInt(et2.getText().toString());

                try{

                    if(n1>10 && n2>10){
                        Toast.makeText(MainActivity.this, "Number is greater than 10 enter 2 new numbers ", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        tv.setText(n1 + " " + n2);
                    }
                }
                catch (NumberFormatException ne){
                    Log.d("error", "error");
                }
            }
        });
    }
}
