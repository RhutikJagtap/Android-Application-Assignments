package com.example.optionsmenu;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class Option extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem m1=menu.add(1,1,1,"add");
        {
            m1.setAlphabeticShortcut('a');
        }
        menu.add(1,2,2,"settings");
        menu.add(1,3,3,"Info");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getTitle().toString())
        {
            case "add":
                Toast.makeText(getBaseContext(),"You Clicked on add",Toast.LENGTH_SHORT).show();
                break;
            case "Info":
                Toast.makeText(getBaseContext(),"You Clicked on Info",Toast.LENGTH_SHORT).show();
                break;

            case "settings":
                Toast.makeText(getBaseContext(),"You Clicked on Settings",Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
