package com.example.allen.kcalendar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.HashMap;
import java.util.Map;

abstract class SQLHelper extends SQLiteOpenHelper {
    private String table_name;

    SQLHelper(Context context, String target_table) {
        super(context, "calendar", null, 1);
        table_name = target_table;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + table_name + " ("
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

    abstract void   create(HashMap<String, String> dataHash);
    abstract String read(int id, String column);
    abstract void   update(HashMap<String, String> update_data_hash, int id);
    abstract void   delete(int id);
}
