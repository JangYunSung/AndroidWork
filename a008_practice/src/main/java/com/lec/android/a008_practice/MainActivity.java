package com.lec.android.a008_practice;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    EditText etname, etage, etaddr;
    PhonebookAdapter adapter;  // Adapter 객체
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice_other);
        etname = findViewById(R.id.etname);
        etage = findViewById(R.id.etage);
        etaddr = findViewById(R.id.etaddr);
        rv = findViewById(R.id.rv);

        // RecyclerView 를 사용하기 위해서는 LayoutManager 지정해주어야 한다.
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        //RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);

        rv.setLayoutManager(layoutManager);

        // Adapter객체 생성
        adapter = new PhonebookAdapter();


        rv.setAdapter(adapter);   // RecyclerView 에 Adapter 장착!

        Button btnInsert = findViewById(R.id.btninsert);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertData(v);
                etname.setText("");
                etage.setText("");
                etaddr.setText("");

            }
        });



    } // end onCreate()

    // 데이터 가져오기



    protected void insertData(View v){
//        int idx = .next();
//        D.FACEID[idx], D.NAME[idx], D.PHONE[idx], D.EMAIL[idx])
        // 리스트 맨 앞에 추가
        adapter.addItem(0, new Phonebook(etname.getText().toString(),etage.getText().toString(),etaddr.getText().toString()));
        adapter.notifyDataSetChanged();  // 데이터변경을 Adapter 에 알리고, 리스트뷰에 반영.
    }







} // end Activity








