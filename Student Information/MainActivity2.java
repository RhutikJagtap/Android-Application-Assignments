package com.example.studentinformation;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends Activity {
    TextView ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ans = findViewById(R.id.ed1);
        String str = getIntent().getStringExtra("msg");
        ans.setText(str);

    }
}
