package com.example.studentcrud;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText et1,et2;
    Button insertBtn,showBtn,updateBtn,deleteBtn;
    StudentDatabase stuDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stuDB=new StudentDatabase(this);

        et1= findViewById(R.id.id);
        et2= findViewById(R.id.name);

        insertBtn=findViewById(R.id.InsertButton);
        showBtn=findViewById(R.id.showButton);
        updateBtn=findViewById(R.id.updateButton);
        deleteBtn=findViewById(R.id.deleteButton);


        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int stu_id=Integer.parseInt(et1.getText().toString());
                String stu_name=et2.getText().toString();

                boolean isInserted=stuDB.insertData(stu_id,stu_name);

                if (isInserted)
                {
                    Toast.makeText(MainActivity.this,"Data Inserted Successfully ",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this,"Data Not Inserted",Toast.LENGTH_LONG).show();
                }
            }
        });


        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res=stuDB.getAllData();

                if (res.getCount()==0)
                {
                    showMessage("Error","Nothing Found");
                    return;
                }

                StringBuffer stringBuffer = new StringBuffer();
                while (res.moveToNext()) {
                    stringBuffer.append("Student Id :" + res.getString(0) + "\n");
                    stringBuffer.append("Student Name :" + res.getString(1) + "\n");
                    stringBuffer.append("======================\n");
                }

                //show all data
                showMessage("Student Data", stringBuffer.toString());

            }

        });


        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              boolean updated=  stuDB.updateData(et1.getText().toString(),et2.getText().toString());

              if(updated)
              {
                  Toast.makeText(MainActivity.this,"Data Updated",Toast.LENGTH_LONG).show();
              }else {
                  Toast.makeText(MainActivity.this,"Data Not Updated",Toast.LENGTH_LONG).show();
              }

            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Integer delete= stuDB.deleteData(Integer.valueOf(et1.getText().toString()));

             if (delete==0)
             {
                 Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
             }else {
                 Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
             }

            }
        });

    }
    public void showMessage(String title,String message) {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
