package com.example.activitylifecycle;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    String tag = "Events";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(tag, "OnCreate Method Called");
    }

    public void onStart() {
        super.onStart();
        Log.d(tag, "onStart() Method Called");
    }

    public void onRestart() {
        super.onRestart();
        Log.d(tag, "onRestart() Method Called");
    }

    public void onResume() {
        super.onResume();
        Log.d(tag, "onResume() Method Called");
    }

    public void onPause() {
        super.onPause();
        Log.d(tag, "onPause() Method Called");
    }

    public void onStop() {
        super.onStop();
        Log.d(tag, "onStop() Method Called");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(tag, "onDestroy() Method Called");
    }
}