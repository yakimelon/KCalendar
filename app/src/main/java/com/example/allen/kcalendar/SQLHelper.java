package com.example.allen.kcalendar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLHelper extends SQLiteOpenHelper {
    SQLHelper(Context context){
        super(context, "calendar", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE diary ("
                +"id INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"title string,"
                +"description string,"
                +"month string,"
                +"day string"
                +")";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
