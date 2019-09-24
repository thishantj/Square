package com.example.signup;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelperAPP extends SQLiteOpenHelper {

    static final String DATABASE_NAME ="squareA.db";
    public static final String TABLE_NAME ="user";
    public static final String COL_1 ="apptid";
    public static final String COL_2 ="apptdetails";
    public static final String COL_3 ="date";
    public static final String COL_4 ="time";



    public DBHelperAPP(Context context) {
        super(context, "squareA.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(apptid text primary key, apptdetails text, date integer, time text )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);

    }

    public boolean insertData(String apptid, String apptdetails, int date, String time)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_1,apptid);
        cv.put(COL_2,apptdetails);
        cv.put(COL_3,date);
        cv.put(COL_4,time);

        long result = db.insert(TABLE_NAME,null,cv);
        if (result == 1)
            return false;
        else
            return true;

    }

    public boolean updateData(String apptid, String apptdetails, int date, String time)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_1,apptid);
        cv.put(COL_2,apptdetails);
        cv.put(COL_3,date);
        cv.put(COL_4,time);

        db.update(TABLE_NAME,cv,"apptid = ?",new String[]{apptid});
        return true;

    }

    public Integer deleteData(String apptid)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"apptid = ?",new String[] {apptid});
    }

}
