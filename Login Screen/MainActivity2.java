package com.example.loginscreen;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends Activity {
    TextView tv1;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv1=findViewById(R.id.t1);
        String msg=getIntent().getStringExtra("success");
        tv1.setText("Congratulations "+msg);

    }

}
