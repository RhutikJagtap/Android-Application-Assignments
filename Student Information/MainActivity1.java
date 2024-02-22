package com.example.studentinformation;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity1 extends Activity {

    EditText e1, e2, e3, e4, e5, e6;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        e1 = findViewById(R.id.fn);
        e2 = findViewById(R.id.midn);
        e3 = findViewById(R.id.ln);
        e4 = findViewById(R.id.dob);
        e5 = findViewById(R.id.addr);
        e6 = findViewById(R.id.eid);
        btn = findViewById(R.id.submit);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str1 = e1.getText().toString();
                String str2 = e2.getText().toString();
                String str3 = e3.getText().toString();
                String str4 = e4.getText().toString();
                String str5 = e5.getText().toString();
                String str6 = e6.getText().toString();

                Toast.makeText(getApplicationContext(), "Submit Button Click", Toast.LENGTH_SHORT).show();

                String str = "First Name : " + str1 + "\n Middle Name : " + str2 + "\n Last Name : " + str3 + "\n Date of Birth : " + str4 + "\n Address : " + str5 + "\n Email-ID : " + str6;

                Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                i.putExtra("msg", str);
                startActivity(i);
            }
        });
    }

}