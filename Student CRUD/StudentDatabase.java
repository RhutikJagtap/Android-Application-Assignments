package com.example.studentcrud;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class StudentDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "studentDB.db";
    public static final String TABLE_NAME = "student";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";

    public StudentDatabase(@Nullable Context context) {

        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student(id int primary key,name text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS student");
        onCreate(db);
    }

    //User define Method
    public boolean insertData(int id, String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID, id);
        contentValues.put(COLUMN_NAME, name);
        db.insert("student", null, contentValues);
        return true;
    }


    //User define Method
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select *from student", null);
        return cursor;
    }


     //User define Method
    public boolean updateData(String new_id, String new_name) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, new_name);
        database.update(TABLE_NAME, contentValues, "id=?", new String[]{new_id}); //where id is the not field from method
        return true;
    }

    //User define Method
    public Integer deleteData(Integer id) {
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete("student", "id=?", new String[]{String.valueOf(id)});
    }

}
