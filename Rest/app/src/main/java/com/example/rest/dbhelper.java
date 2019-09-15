package com.example.rest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class dbhelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "quotation.db";
    public static final String TABLE_NAME = "food.db";
    public static final String COL_1 = "foodID";
    public static final String COL_2 = "foodName";
    public static final String COL_3 = "foodPrice";

    public dbhelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
       // SQLiteDatabase  db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME + "(foodID INTEGER PRIMARY KEY AUTOINCREMENT, foodName TEXT, foodPrice INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
        
        //
        

    }
}
