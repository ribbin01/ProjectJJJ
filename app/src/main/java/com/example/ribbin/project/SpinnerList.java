package com.example.ribbin.project;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Ribbin on 15-Nov-17.
 */

public class SpinnerList extends AppCompatActivity {
    private Spinner spinnerList;
    private SQLiteDatabase mDb;
    private MyOpenHelper mHelper;
    private Cursor mCursor;
    private String showType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_spinner);

        spinnerList = findViewById(R.id.spinner);


        mHelper = new MyOpenHelper(this);
        mDb = mHelper.getWritableDatabase();
        mCursor = mDb.rawQuery("SELECT * FROM typeTable ", null);

        ArrayList<String> str = new ArrayList<String>();
        mCursor.moveToFirst();

        while (!mCursor.isAfterLast()) {
            str.add(mCursor.getString(mCursor.getColumnIndex(MyOpenHelper.COL_TYPE)));
            mCursor.moveToNext();
        }

        ArrayAdapter<String> adapterDir = new ArrayAdapter(this, android.R.layout.simple_list_item_1, str);
        spinnerList.setAdapter(adapterDir);
        spinnerList.setOnItemClickListener();




    }




}



