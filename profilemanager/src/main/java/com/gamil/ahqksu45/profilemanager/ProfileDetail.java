package com.gamil.ahqksu45.profilemanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileDetail extends AppCompatActivity {

    TextView tvprofileid, tvname, tvphonenum, tvaddress, tvjumin ,
            tvprofileno, tvbank, tvemail , tvcard, tvbigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_detail);


        tvprofileid = findViewById(R.id.tvprofileid);
        tvname = findViewById(R.id.tvname);
        tvphonenum = findViewById(R.id.tvphonenum);
        tvaddress = findViewById(R.id.tvaddr);
        tvjumin = findViewById(R.id.tvjumin);
        tvprofileno = findViewById(R.id.tvprofileno);
        tvbank = findViewById(R.id.tvbank);
        tvemail = findViewById(R.id.tvemail);
        tvcard = findViewById(R.id.tvcardnum);
        tvbigo = findViewById(R.id.tvbigo);


        Intent intent = getIntent();
        Profile pf = (Profile)intent.getSerializableExtra("pf");
        tvprofileid.setText(pf.getProfileid());
        tvname.setText(pf.getName());
        tvphonenum.setText(pf.getPhonenum());
        tvaddress.setText(pf.getAddress());
        tvjumin.setText(pf.getJumin());
        tvprofileno.setText(pf.getProfileno());
        tvbank.setText(pf.getBank());
        tvemail.setText(pf.getEmail());
        tvcard.setText(pf.getCard());
        tvbigo.setText(pf.getBigo());





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











