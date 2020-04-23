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
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Add extends AppCompatActivity {

    String dbName = "profile.db";
    int dbVersion = 1;
    MySQLiteOpenHelper helper;
    static SQLiteDatabase db;
    static String tableName = "profile";
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

        Button btnback = findViewById(R.id.btnback);
        btnback.setOnClickListener(new View.OnClickListener() {
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
    void select(){
        // SELECT 문을 위한 query() 메소드
        Cursor c = db.query(tableName, null, null, null, null, null, null);
        while(c.moveToNext()){
            String id = c.getString(0);
            String name = c.getString(1);
            Number phonenum = c.getInt(2);
            String address = c.getString(3);
            Number jumin = c.getInt(4);
            String profileno = c.getString(5);
            String bank = c.getString(6);
            String email = c.getString(7);
            String card = c.getString(8);
            String bigo = c.getString(9);

            String msg = String.format("id: %s \n name: %s \n  phonenum: %d \n " +
                    "address: %s \n  jumin: %d \n profileno: %s \n bank: %s \n email: %s \n " +
                    "card: %s \n bigo: %s", id, name, phonenum, address, jumin,profileno,bank,email,card,bigo);



            Log.d("myapp", msg);
        } // end while


        //키보드 내리기
        InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);




    }




}