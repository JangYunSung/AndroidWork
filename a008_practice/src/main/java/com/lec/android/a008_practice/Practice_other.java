//package com.lec.android.a008_practice;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.RecyclerView;
//
//
//public class Practice_other extends AppCompatActivity {
//
//    EditText etname, etage, etaddr;    //입력받을애들
//    TextView tvname1, tvage1, tvaddr1;
//    RecyclerView rv;
//    Button btninsert;
//
//    private final int REQUEST_CODE_Result1 = 101;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.practice_other);
//
//        etname = findViewById(R.id.etname);
//        etage = findViewById(R.id.etage);
//        etaddr = findViewById(R.id.etaddr);
//        btninsert = findViewById(R.id.btninsert);
//        tvname1 = findViewById(R.id.tvname);
//        tvage1 = findViewById(R.id.tvage);
//        tvaddr1 = findViewById(R.id.tvaddr);
//        rv = findViewById(R.id.rv);
//
//
//        btninsert.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                String a = etname.getText().toString().trim();
//                String b = etage.getText().toString().trim();
//                String c = etaddr.getText().toString().trim();
//
//                Intent intent = new Intent(getApplicationContext(), Result1.class);
//                intent.putExtra("name", a);
//                intent.putExtra("name", b);
//                intent.putExtra("name", c);
//
//                // 일반적인 화면전환
//                // startActivity(intent);
//
//                // 값을 돌려받기 위한 화면전환
//                startActivityForResult(intent, REQUEST_CODE_Result1);
//
//
//            }
//        });
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if(resultCode == RESULT_OK){  // 정상 반환이 경우
//
//            switch (requestCode){
//                case REQUEST_CODE_Result1:
//                    String a = data.getStringExtra("name");
//                    String b = data.getStringExtra("age");
//                    String c = data.getStringExtra("addr");
//
//                    tvname1.setText(a);
//                    tvage1.setText(b);
//                    tvaddr1.setText(c);
//                    break;
//            }
//
//
//        } else {
//            // 정상 결과가 아닌 경우 처리
//        }
//
//    }
//
//
//
//
//
//
//}