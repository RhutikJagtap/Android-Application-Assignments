package com.example.loginformdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class LoginDatabase extends SQLiteOpenHelper {
    public  static  final String DATABASE_NAME="LoginForm.db";
    public  static  final String TABLE_NAME="login";
    public  static  final String COLUMN_ID="username";
    public  static  final String COLUMN_NAME="password";

    public LoginDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table login(username text primary key,password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS login");
        onCreate(db);
    }

    //User defined Method
    public  boolean insertData(String uname,String pwd)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN_ID,uname);
        contentValues.put(COLUMN_NAME,pwd);
        db.insert("login",null,contentValues);
        return true;
    }


    //User Defined Method
    public Cursor getAllData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select *from login",null);
        return  res;
    }


    public boolean Login(String user, String pass) throws SQLException
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor mCursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE username=? AND password=?", new String[]{user,pass});
        if (mCursor != null) {
            if (mCursor.getCount() > 0) {
                return true;
            }
        }
        return false;
    }



}
