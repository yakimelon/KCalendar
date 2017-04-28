package com.example.allen.kcalendar;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            // TODO: CRUD はクラス作ってそこから使いたい
            SQLiteDatabase db = new SQLHelper(getApplicationContext()).getWritableDatabase();
            ContentValues value = new ContentValues();
            value.put("title", "test!!");
            long n = db.insert("diary", null, value);
            Log.d("999", "Insert成功？");
            Log.d("111", String.valueOf(n));
            Cursor cursor = db.query("diary", new String[] {"id", "title", "description", "month", "day"}, null, null, null, null, null);
            cursor.moveToLast();
            Log.d("999", "出力結果");
            Log.d("999", cursor.getString(cursor.getColumnIndex("title")));
        } catch (Exception e) {
             Log.d("111", e.getMessage());
        }
    }
}
