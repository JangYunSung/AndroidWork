package com.naver.ahqksu45.android.profilemanager2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etName , etTel;
    private Button btnInsertData , btnShowAllData;

    private DatabaseHelper databaseHelper = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);

        etName = (EditText) findViewById(R.id.etName);
        etTel = (EditText) findViewById(R.id.etTel);

        btnInsertData = (Button) findViewById(R.id.btnInsertData);
        btnShowAllData = (Button) findViewById(R.id.btnShowAllData);

        btnInsertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //getString(R.string.INSERT_QUEST);
                String name = etName.getText().toString();
                String phone = etTel.getText().toString();

               AdderssInfo adderssInfo = new AdderssInfo();
               adderssInfo.setName(name);
               adderssInfo.setName(phone);

               databaseHelper.insertAddressData(adderssInfo);




            }
        });

        btnShowAllData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddressListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }


    private  void showDialog(String message){

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("!");
        builder.setMessage(message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }


}

