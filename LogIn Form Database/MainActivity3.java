package com.example.loginformdatabase;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity3 extends Activity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        textView=(TextView) findViewById(R.id.tv);
        String username=getIntent().getStringExtra("username");
        textView.setText("Congratulations Your are Successfully Login using UserName "+username);
    }
}
