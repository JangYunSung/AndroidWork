package com.lec.android.a008_practice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PhonebookDetail extends AppCompatActivity {

    TextView tvName, tvage, tvaddr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonebook_detail);

        tvName = findViewById(R.id.tvname);
        tvaddr = findViewById(R.id.tvaddr);
        tvage = findViewById(R.id.tvage);

        Intent intent = getIntent();
        Phonebook pb = (Phonebook)intent.getSerializableExtra("pb");
        tvName.setText(pb.getName());
        tvaddr.setText(pb.getAddr());
        tvage.setText(pb.getAge());

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 리스트로 돌아가기
                finish();
            }
        });
    }
}











