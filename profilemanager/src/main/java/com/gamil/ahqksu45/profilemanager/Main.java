package com.gamil.ahqksu45.profilemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


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
//
//        try {
//            FileInputStream is = openFileInput("profile.txt");
//            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//
//            StringBuffer data = new StringBuffer();
//            String str = reader.readLine();  //파일에서 한줄을 읽어 오기
//            while (str != null) {
//                data.append(str + "\n");
//                str = reader.readLine();  //읽어드릴께 null일때까지
//            }// end while
//            tvResult.setText(data);
//            reader.close();
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }//end onCreate


}
