package com.example.signup;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    //public static final String DATABASE_NAME ="square.db";
    public static final String TABLE_NAME ="user";
    public static final String COL_1 ="name";
    public static final String COL_2 ="address";
    public static final String COL_3 ="tel";
    public static final String COL_4 ="nic";



    public DBHelper(Context context) {
        super(context, "square.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(name text, address text, tel integer, nic text primary key)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS user");
        //onCreate(db);

    }

    public boolean insertData(String name, String address, int tel, String nic)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_1,name);
        cv.put(COL_2,address);
        cv.put(COL_3,tel);
        cv.put(COL_4,nic);

        long result = db.insert(TABLE_NAME,null,cv);
        if (result == 1)
            return false;
        else
            return true;

    }



    public boolean updateData(String name, String address, int tel, String nic)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_1,name);
        cv.put(COL_2,address);
        cv.put(COL_3,tel);
        cv.put(COL_4,nic);

        db.update(TABLE_NAME,cv,"USERNAME = ?",new String[]{nic});
        return true;

    }

    public Integer deleteData(String nic)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"NIC = ?",new String[] {nic});
    }

}
