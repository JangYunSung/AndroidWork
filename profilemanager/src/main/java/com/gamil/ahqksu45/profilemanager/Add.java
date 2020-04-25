package com.gamil.ahqksu45.profilemanager;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Add extends AppCompatActivity {


    ArrayList<Profile> se = new ArrayList<Profile>() {

    };


    String tableName = "profile";
    int dbVersion = 1;
    String dbName = "profile.db";
    MySQLiteOpenHelper helper;
    SQLiteDatabase db;
    EditText etprofileid, etname, etaddress , etjumin , etemail ,etprofileno ,etphonenum, etcardnum,etbank ,etbigo;
    Button btninsert, btnback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);

        etprofileid = findViewById(R.id.etprofileid);
        etprofileno = findViewById(R.id.etprofileno);
        etname= findViewById(R.id.etname);
        etphonenum = findViewById(R.id.etphonenum);
        etaddress = findViewById(R.id.etaddress);
        etjumin = findViewById(R.id.etjumin);
        etemail = findViewById(R.id.etemail);
        etcardnum = findViewById(R.id.etcardnum);
        etbank = findViewById(R.id.etbank);
        etbigo = findViewById(R.id.etbigo);




        btninsert = findViewById(R.id.btninsert);
        btnback = findViewById(R.id.btnback);

        helper = MySQLiteOpenHelper.getInstance(
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

//        btnback.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), Main.class);
//                startActivity(intent);
//            }
//        });




        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String profileid = etprofileid.getText().toString();
                String name = etname.getText().toString();
                String phonenum = etphonenum.getText().toString();
//                int phonenum = Integer.parseInt(etphonenum.getText().toString());
                String address = etaddress.getText().toString();
                String jumin = etjumin.getText().toString();
//                int jumin = Integer.parseInt(etjumin.getText().toString());
                String profileno = etprofileno.getText().toString();
                String bank = etbank.getText().toString();
                String email = etemail.getText().toString();
                String card = etcardnum.getText().toString();
//                int card = Integer.parseInt(etcardnum.getText().toString());
                String bigo = etbigo.getText().toString();


                if("".equals(name)){

                    return;
                }
//
//
                int aphonenum = 0;
                int bjumin = 0;
                int ccard = 0;
                try{
                    aphonenum = Integer.parseInt(phonenum);
                    bjumin = Integer.parseInt(jumin);
                    ccard = Integer.parseInt(card);

                } catch (NumberFormatException e){

                }
//
                insert(profileid, name, aphonenum, address ,bjumin , profileno, bank, email , ccard , bigo);
                Log.d("myapp", "파일에 등록완료");
            }
        });





    }//on Create()





    void insert(String profileid , String name, int phonenum ,String address,
                int jumin, String profileno , String bank , String email , int card , String bigo){

        ContentValues values = new ContentValues();   // name-value 쌍으로 저장하는 객체

        // 키, 값의 쌍으로 데이터 입력
        values.put("profileid", profileid);
        values.put("name", name);
        values.put("phonenum", phonenum);
        values.put("address", address);
        values.put("jumin", jumin);
        values.put("profileno", profileno);
        values.put("bank", bank);
        values.put("email", email );
        values.put("card", card);
        values.put("bigo", bigo);

        // INSERT INTO tableName (name, age, address) values (?, ?, ?)
        // 리턴값은 auto-generated key 값 실패하면 -1 리턴
        long result = db.insert(tableName,
                null,
                values);

        Log.d("myapp", result + "개 row INSERT 성공");

    };









}