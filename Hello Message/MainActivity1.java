package com.example.hellomessage;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity1 extends Activity {

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        button = findViewById(R.id.btn1);
        editText = findViewById(R.id.e1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();
                Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                i.putExtra("msg", message);
                startActivity(i);
            }
        });

    }
}