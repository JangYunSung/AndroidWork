package com.gamil.ahqksu45.profilemanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main extends AppCompatActivity {

    ProfileAdapter adapter;  // Adapter 객체
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        rv = findViewById(R.id.rv);

        // RecyclerView 를 사용하기 위해서는 LayoutManager 지정해주어야 한다.
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        //RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);

        rv.setLayoutManager(layoutManager);

        // Adapter객체 생성
        adapter = new ProfileAdapter();



        rv.setAdapter(adapter);

        // 메뉴에 추가하기 버튼을 누르면 추가하는 화면으로 이동한다.
        ImageButton ibadd = findViewById(R.id.ibadd);
        ibadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Add.class);
                startActivity(intent);
            }
        });


        // 메뉴 검색하기 버튼을 누르면 search 된 edit 값을 기준으로 사이클러뷰를 보이게한다.
        ImageButton ibsearch = findViewById(R.id.ibsearch);
        ibsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
            }
        });






//        파일에서 읽어와 아이템장착해서 보여주기

    }//end onCreate


}
