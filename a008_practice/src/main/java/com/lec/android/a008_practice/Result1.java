//package com.lec.android.a008_practice;
//
//import android.content.Intent;
//import android.os.Bundle;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class Result1 extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//
//        Intent intent = getIntent();
//        String name = intent.getStringExtra("name");
//        String age = intent.getStringExtra("age");
//        String addr = intent.getStringExtra("addr");
//
//        intent.putExtra("name", name);
//        intent.putExtra("age",age);
//        intent.putExtra("addr",addr);
//
//        // 호출한 화면에 값 되돌려 주기
//        setResult(RESULT_OK, intent);
//
//        finish();  // onDestroy() 와 동일
//    }
//}
