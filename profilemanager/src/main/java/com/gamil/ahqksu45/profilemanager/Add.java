package com.gamil.ahqksu45.profilemanager;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Add extends AppCompatActivity {

    String dbName = "profile.db";
    int dbVersion = 1;
    MySQLiteOpenHelper helper;
    SQLiteDatabase db;
    String tableName = "profile";
    EditText etname, etaddress , etjumin , etemail , etprofileid,etprofileno ,etphonenum,etcardnum,etbank ,etbigo;
    Button btninsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);

        btninsert = findViewById(R.id.btninsert);

        helper = new MySQLiteOpenHelper(
                this,
                dbName,
                null,
                dbVersion
        );

        try{
            db = helper.getWritableDatabase();
        } catch(SQLiteException e){
            e.printStackTrace();
            Log.e("myapp", "데이터 베이스를 열수 없슴");  // Logcat 의 error 에 표시됨.
        }

        Button btnChild1 = findViewById(R.id.addback);
        btnChild1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main.class);
                startActivity(intent);
            }
        });




        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String profileid = etprofileid.getText().toString();
                String name = etname.getText().toString();
                String phonenum = etphonenum.getText().toString();
                String address = etaddress.getText().toString();
                String jumin = etjumin.getText().toString();
                String profileno = etprofileno.getText().toString();
                String bank = etbank.getText().toString();
                String email = etemail.getText().toString();
                String card = etcardnum.getText().toString();
                String bigo = etbigo.getText().toString();



                if("".equals(name)){

                    return;
                }


                int a = 0;
                int b = 0;
                int c = 0;
                try{
                    a = Integer.parseInt(phonenum);
                    b = Integer.parseInt(jumin);
                    c = Integer.parseInt(card);

                } catch (NumberFormatException e){

                }

                insert(profileid, name, a, address ,b , profileno, bank, email , c , bigo);

            }
        });





    }//on Create()
    void insert(String profileid , String name, int phonenum ,String address,
                int jumin, String profileno , String bank , String email , int card , String bigo){

        ContentValues values = new ContentValues();   // name-value 쌍으로 저장하는 객체

        // 키, 값의 쌍으로 데이터 입력
        values.put("profileid", profileid);
        values.put("name", name);
        values.put("age", phonenum);
        values.put("address", address);
        values.put("jumin", jumin);
        values.put("profileno", profileno);
        values.put("bank", bank);
        values.put("email", email );
        values.put("card", card);
        values.put("bigo", bigo);

        // INSERT INTO tableName (name, age, address) values (?, ?, ?)
        // 리턴값은 auto-generated key 값 실패하면 -1 리턴
        long result = db.insert(tableName, null, values);

        Log.d("myapp", result + "개 row INSERT 성공");

    };
}