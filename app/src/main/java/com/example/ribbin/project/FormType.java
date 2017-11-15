package com.example.ribbin.project;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class FormType extends AppCompatActivity {
    private String saveType;
    private EditText edtType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_form);
        edtType = findViewById(R.id.editText);
    }

    public void clickSave(View view) {

        saveType = edtType.getText().toString();
        if (saveType.equals("")) {
            showAlert();
        } else {
            showLog();
            confirmData();
        }
    }

    private void confirmData() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm?");
        builder.setMessage("Confirm to save " + saveType + "To type");
        builder.setCancelable(false);
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss();
            }
        });
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                upDatatoSQLite();
                Intent ii = new Intent(FormType.this, ListofType.class);
                startActivity(ii);
            }
        });
        builder.show();
    }

    private void upDatatoSQLite() {
        TypeTABLE typeTABLE = new TypeTABLE(this);
        String string = typeTABLE.addNewValueToSQLite(saveType);

        edtType.setText("");
        Toast.makeText(FormType.this, "Finish", Toast.LENGTH_SHORT);
    }

    private void showAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("HaveSpace");
        builder.setMessage("Fill in the blank");
        builder.setCancelable(false);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {

                dialog.dismiss();


            }
        });
        builder.show();
    }


    private void showLog() {
        Log.d("TYPEEEEEEEE", "" + saveType);
    }
}
