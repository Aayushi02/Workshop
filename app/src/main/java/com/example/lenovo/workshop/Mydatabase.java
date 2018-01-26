package com.example.lenovo.workshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Lenovo on 26-01-2018.
 */

public class Mydatabase extends SQLiteOpenHelper {
    public static final String databasename = "Worshop.db";
    public static String Table_name = new String();
    public static final String col1 = "Workshop_name";

    public Mydatabase(Context context, String tablename) {
        super(context, tablename, null, 1);
        this.Table_name = tablename;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("Create Table " + Table_name + " (Workshop_name TEXT UNIQUE) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + Table_name);
        onCreate(sqLiteDatabase);

    }
    public boolean insert_data(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col1, name);
        long result = db.insertWithOnConflict(Table_name,null,cv,SQLiteDatabase.CONFLICT_REPLACE);
        db.close();
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res= db.rawQuery("select * from "+Table_name,null);
        return  res;
    }
}
