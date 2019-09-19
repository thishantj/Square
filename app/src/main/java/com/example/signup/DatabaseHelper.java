package com.example.signup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="square.db";
    public static final String TABLE_NAME ="user_table";
    public static final String COL_1 ="NAME";
    public static final String COL_2 ="ADDRESS";
    public static final String COL_3 ="TEL";
    public static final String COL_4 ="USERNAME";
    public static final String COL_5 ="PASSWORD";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        //find out database created or not
        //SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME +"(NAME TEXT, ADDRESS TEXT, TEL INTEGER, USERNAME TEXT, PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String name, String address, String tel, String username, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_1,name);
        cv.put(COL_2,address);
        cv.put(COL_3,tel);
        cv.put(COL_4,username);
        cv.put(COL_5,password);
        long result = db.insert(TABLE_NAME,null,cv);
        if (result == 1)
            return false;
        else
            return true;

    }

//    public Cursor getAllData()
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//        Cursor cu = db.rawQuery("select * from " + TABLE_NAME,null);
//        return cu;
//    }

    public boolean updateData(String name, String address, String tel, String username, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_1,name);
        cv.put(COL_2,address);
        cv.put(COL_3,tel);
        cv.put(COL_4,username);
        cv.put(COL_5,password);
        db.update(TABLE_NAME,cv,"USERNAME = ?",new String[]{username});
        return true;

    }

    public Integer deleteData(String username)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"USERNAME = ?",new String[] {username});
    }


    //checking unique username
    public Boolean chkUsername(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where username=?", new String[]{username});

        if (cursor.getCount() > 0){
            return false;
        }else {
            return true;
        }
    }

    //checking username and password for login
    public Boolean usernamePassword(String username, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from user where username=? and password=?", new String[]{username, password});

        if (cursor.getCount() > 0){
            return true;
        }else{
            return false;
        }
    }

}
