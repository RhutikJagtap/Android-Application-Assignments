package com.example.loginscreen;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity1 extends Activity {

    EditText et1, et2;
    Button bt1;
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        et1 = findViewById(R.id.e);
        et2 = findViewById(R.id.p);
        bt1 = findViewById(R.id.l1);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String em = et1.getText().toString();
                String pw = et2.getText().toString();

                if (em.equals("rhutikjagtap68@gamil.com") && pw.equals("rj@123")) {
                    Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                    msg="Successfully Login";
                    i.putExtra("success", msg);
                    startActivity(i);

                } else if (em.equals("") || pw.equals("")) {
                    Toast.makeText(getBaseContext(), "Enter username and Password Both", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getBaseContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}