package com.example.alertdialogbox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);

        builder.setTitle("Android Programming");
        builder.setMessage("Click Outside the Dialog Box to close me");
        builder.show();
    }
}

//not require any xml file for Alert Dialog Box
