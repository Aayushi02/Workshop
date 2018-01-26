package com.example.lenovo.workshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String Name = "Signup.db";
    public static final String Table_Name = "Authentication";
    public static final String col1 = "user_name";
    public static final String col2 = "password";
    public static final String col3 = "phone";
    public static final String col4 = "email";

    public DatabaseHelper(Context context) {
        super(context, Table_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
sqLiteDatabase.execSQL("Create Table " + Table_Name + " (user_name TEXT PRIMARY KEY,password INTEGER,phone INTEGER,email INTEGER) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists " + Table_Name);
        onCreate(sqLiteDatabase);
    }
    public boolean insert_data(String username, String password, String phone, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col1, username);
        cv.put(col2, password);
        cv.put(col3, phone);
        cv.put(col4, email);
        long result = db.insert(Table_Name, null, cv);
        db.close();
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public String searchpass(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select user_name, password from " + Table_Name;
        Cursor r = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if (r.moveToFirst()) {
            do {
                a = r.getString(0);
                if (a.equals(username)) {
                    b = r.getString(1);
                    break;
                }

            } while (r.moveToNext());
        }
        db.close();
        return b;
    }
}
