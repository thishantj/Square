package com.example.signup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelperorder extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "square.db";
    public static final String TABLE_NAME = "orders";
    public static final String column_1 = "Order_ID";
    public static final String column_2 = "Items";
    public static final String column_3 = "Personal_Preferances";
    public static final String column_4 = "Total_Price";


    public DatabaseHelperorder(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table orders(Order_ID INTEGER PRIMARY KEY AUTOINCREMENT, Items String, Personal_Preferances String, Total_Price INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);

    }
    public boolean insertData(String items, String personal_preferances, String total_price){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues ();
        contentValues.put(column_2,items);
        contentValues.put(column_3,personal_preferances);
        contentValues.put(column_4,total_price);
        long result=db.insert(TABLE_NAME,null,contentValues);
        if( result == -1)
            return false;
        else
            return true;
    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select* from "+TABLE_NAME,null);
        return res;
    }
}
