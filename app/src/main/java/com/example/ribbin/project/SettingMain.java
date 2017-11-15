package com.example.ribbin.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Ribbin on 13-Nov-17.
 */

public class SettingMain extends AppCompatActivity {
    ListView listView;
    String[] strings_setting = {"Add Type", "List Type", "Edit Type", "Delete Type"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_setting);
        listView = findViewById(R.id.listView);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, strings_setting);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                if (arg2 == 0) {
                    Toast.makeText(getApplicationContext(), "เลือก" + arg2, Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), FormType.class);
                    startActivity(i);


                } else if (arg2 == 1) {
                    Toast.makeText(getApplicationContext(), "เลือก" + arg2, Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), ListofType.class);
                    startActivity(i);

                } else if (arg2 == 2) {
                    Toast.makeText(getApplicationContext(), "เลือก" + arg2, Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(), SpinnerList.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "เลือก" + arg2, Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
