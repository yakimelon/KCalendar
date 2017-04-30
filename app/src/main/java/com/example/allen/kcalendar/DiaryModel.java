package com.example.allen.kcalendar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashMap;
import java.util.Map;

// TODO: もうちょい綺麗にする (DRY, マジックナンバー等)
class DiaryModel extends SQLHelper {
    private SQLiteDatabase db = this.getWritableDatabase();

    DiaryModel(Context context) {
        super(context, "diary");
    }

    @Override
    public void create(HashMap<String, String> create_data_hash) {
        ContentValues value = new ContentValues();
        for(Map.Entry<String, String> e : create_data_hash.entrySet()) {
            value.put(e.getKey(), e.getValue());
        }
        db.insert("diary", null, value);
    }

    // TODO: 条件指定出来るようにする
    @Override
    public String read(int id, String column) {
        Cursor cursor = db.query("diary", new String[] {"id", "title", "description", "month", "day"}, "id=" + id, null, null, null, null);
        cursor.moveToNext();
        return cursor.getString(cursor.getColumnIndex(column));
    }

    @Override
    public void update(HashMap<String, String> update_data_hash, int id) {
        ContentValues value = new ContentValues();
        for( Map.Entry<String, String> e : update_data_hash.entrySet() ) {
            value.put(e.getKey(), e.getValue());
        }
        db.update("diary", value, "id=?", new String[]{String.valueOf(id)});
    }

    @Override
    public void delete(int id) {
        db.delete("diary", "id="+id, null);
    }

}

