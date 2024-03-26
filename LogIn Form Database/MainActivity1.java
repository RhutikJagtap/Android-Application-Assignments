package com.example.loginformdatabase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity1 extends Activity {

    LoginDatabase loginDatabase;
    EditText emailId,pass;
    Button LogIn,SignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginDatabase=new LoginDatabase(this);

        LogIn=(Button) findViewById(R.id.logIn);
        SignIn=(Button) findViewById(R.id.signIn);

        emailId=(EditText) findViewById(R.id.email);
        pass=(EditText) findViewById(R.id.pwd);



        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=emailId.getText().toString();
                String pwd=pass.getText().toString();

               boolean isLogin= loginDatabase.Login(email,pwd);

                if(isLogin) {
                    Toast.makeText(MainActivity1.this,"Successfully Login",Toast.LENGTH_LONG).show();
                    Intent i=new Intent(getApplicationContext(),MainActivity3.class);
                    i.putExtra("username",email);
                    startActivity(i);
                }else if (email.equals("")&&pwd.equals("")){
                    Toast.makeText(MainActivity1.this,"Enter UserName and Password Both ",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity1.this,"Invalid UserName and Password",Toast.LENGTH_LONG).show();
                }

            }
        });


        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
            }
        });

    }


}

