package com.example.ribbin.project;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListofType extends AppCompatActivity {
    private ListView listView;
      private SQLiteDatabase mDb;
    private MyOpenHelper mHelper;
    private Cursor mCursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listof_type);
        listView = findViewById(R.id.lv01221);


        mHelper = new MyOpenHelper(this);
        mDb = mHelper.getWritableDatabase();
        mCursor = mDb.rawQuery("SELECT * FROM typeTable ", null);

        ArrayList<String> str = new ArrayList<String>();
        mCursor.moveToFirst();

        while (!mCursor.isAfterLast()) {
            str.add(mCursor.getString(mCursor.getColumnIndex(MyOpenHelper.COL_TYPE)) + "\n"
                    + "Piece : " + mCursor.getString(mCursor.getColumnIndex(MyOpenHelper.COL_ID))
            );
            mCursor.moveToNext();
        }

        ArrayAdapter<String> adapterDir = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str);
        listView.setAdapter(adapterDir);
    }


}


