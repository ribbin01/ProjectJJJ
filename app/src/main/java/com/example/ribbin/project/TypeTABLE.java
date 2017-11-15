package com.example.ribbin.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Ribbin on 13-Nov-17.
 */

public class TypeTABLE {

    private MyOpenHelper myOpenHelper;
    private SQLiteDatabase writeSQLite, readSQLite;
    public static final String TABLE_TYPE = "typeTable";
    public static final String COLUMN_TYPE_ID = "_type_id";
    public static final String COLUMN_TYPE = "type";


    public TypeTABLE(Context context) {
        myOpenHelper = new MyOpenHelper(context);
        writeSQLite = myOpenHelper.getWritableDatabase();
        readSQLite = myOpenHelper.getReadableDatabase();
    }


    public Cursor readAllData() {
        Cursor cursor = readSQLite.rawQuery("SELECT _type_id , type FROM typeTable", null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        return cursor;

    }


    public String addNewValueToSQLite(String str) {
        ContentValues contentValues;
        contentValues = new ContentValues();//
        contentValues.put(COLUMN_TYPE, str);//
        writeSQLite.insert(TABLE_TYPE, null, contentValues);
        return contentValues.toString();


    }


}
