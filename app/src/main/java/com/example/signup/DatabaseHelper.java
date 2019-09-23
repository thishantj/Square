package com.example.signup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    //public static final String DATABASE_NAME ="square.db";
    public static final String TABLE_NAME ="user";
    public static final String COL_1 ="name";
    public static final String COL_2 ="address";
    public static final String COL_3 ="tel";
    public static final String COL_4 ="username";
    public static final String COL_5 ="password";



    public DatabaseHelper(Context context) {
        super(context, "square.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(name text, address text, tel integer, username text primary key, password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS user");
        //onCreate(db);

    }

    public boolean insertData(String name, String address, int tel, String username, String password)
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

    public boolean updateD(String name, String address, int tel, String username, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COL_1, name);
        cv.put(COL_2, address);
        cv.put(COL_3, tel);
        cv.put(COL_4, username);
        cv.put(COL_5, password);

        db.update("user", cv, "username = ?", new String[]{username});
        return true;
    }

    public Integer deleteData(String username)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"username = ?",new String[] {username});
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
