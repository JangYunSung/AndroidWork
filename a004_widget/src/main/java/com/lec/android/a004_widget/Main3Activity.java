package com.lec.android.a004_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {


    CheckBox cd1,cd2,cd3,cd4;
    TextView tvResult;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        cd1 = findViewById(R.id.cd1);
        cd2 = findViewById(R.id.cd2);
        cd3 = findViewById(R.id.cd3);
        cd4 = findViewById(R.id.cd4);
        tvResult = findViewById(R.id.tvResult);


        Button btnComplete = findViewById(R.id.btnComplete);

        // 버튼을 클릭하면 체크된 내용들만 결과 출력하기
        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = "";
                if(cd1.isChecked()) result += cd1.getText();
                if(cd2.isChecked()) result += cd2.getText();
                if(cd3.isChecked()) result += cd3.getText();
                if(cd4.isChecked()) result += cd4.getText();

                tvResult.setText("선택결과 : " +result);

            }
        });

        cd1.setOnCheckedChangeListener(new CdListener());
        cd2.setOnCheckedChangeListener(new CdListener());
        cd3.setOnCheckedChangeListener(new CdListener());
        cd4.setOnCheckedChangeListener(new CdListener());



    }

    class CdListener implements CompoundButton.OnCheckedChangeListener{

        // CheckBox 의 '상태'가 변할때 마다 호출되는 메소드
        // isChecked : true < -check 상태 , false <- uncheck 상태
        //
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            int count = 0 ;
            if (cd1.isChecked()) count++;
            if (cd2.isChecked()) count++;
            if (cd3.isChecked()) count++;
            if (cd4.isChecked()) count++;
            tvResult.setText(count + "개 선택");
        }
    }



}














