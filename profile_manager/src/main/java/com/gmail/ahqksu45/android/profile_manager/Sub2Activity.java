package com.gmail.ahqksu45.android.profile_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Sub2Activity extends AppCompatActivity {
        EditText etSelectedName, etSelectedPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);



        // getIntent : 전달 받은 intent 가져옴
        Intent receivedIntent = getIntent();

        // getStringExtra : intent에 putExtra() 를 사용하여 저장한 값을 추출
        String name = receivedIntent.getStringExtra("name");
        String phone = receivedIntent.getStringExtra("phone");

        //새로 입력 수정된 EditText를 set
        etSelectedName = (EditText) findViewById(R.id.etSelectedName);
        etSelectedPhone = (EditText) findViewById(R.id.etSelectedPhone);


    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnupdate:
                Intent resultIntent = new Intent();




                // 새로 수정된 editText 값을 받기위해 전역변수로 빼고 수정된 값을 intent 에 저장
                resultIntent.putExtra("name", etSelectedName.getText().toString());
                resultIntent.putExtra("phone", etSelectedPhone.getText().toString());
                //setResult : 결과값 설정 - 결과 코드 , 결과값을 갖고 있는 intent
                setResult(RESULT_OK, resultIntent);
                break;

            case R.id.sub2cancel:
                setResult(RESULT_CANCELED); //취소 결과값 설정
                break;


        }
        finish();
    }


}

