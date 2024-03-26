package com.example.loginformdatabase;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends Activity {

    LoginDatabase loginDatabase;
    EditText email, pwd;
    Button LogInBtn, SubmitBtn, showBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        loginDatabase = new LoginDatabase(this);

        LogInBtn = (Button) findViewById(R.id.logIn);
        SubmitBtn =(Button) findViewById(R.id.Submit);
        showBtn = (Button) findViewById(R.id.show);

        email =(EditText) findViewById(R.id.email);
        pwd =(EditText) findViewById(R.id.pwd);

        SubmitBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                boolean isInsertd = loginDatabase.insertData(email.getText().toString(),pwd.getText().toString());

                if (isInsertd) {
                    Toast.makeText(MainActivity2.this, "Form Successfully Submitted", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity2.this, "Something Error", Toast.LENGTH_LONG).show();
                }
            }
        });

        LogInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity1.class);
                startActivity(intent);
            }
        });

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = loginDatabase.getAllData();

                if (res.getCount() == 0) {
                    showMessage("Error", "Nothing Found");
                    return;
                }

                StringBuffer stringBuffer = new StringBuffer();
                while (res.moveToNext()) {
                    stringBuffer.append("Email :" + res.getString(0) + "\n");
                    stringBuffer.append("Password :" + res.getString(1) + "\n");
                    stringBuffer.append("======================\n");
                }

                //show all data
                showMessage("Form Data", stringBuffer.toString());

            }
        });

    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
