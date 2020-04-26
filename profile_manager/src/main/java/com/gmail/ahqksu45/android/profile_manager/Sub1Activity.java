package com.gmail.ahqksu45.android.profile_manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Sub1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btnSave:
                EditText etName = (EditText)findViewById(R.id.etName);
                EditText etPhone = (EditText)findViewById(R.id.etPhone);

                //입력받은 값을 intent 에 저장 putExtra 이용하여 자료 저장)

                Intent resultIntent = new Intent();
                //파일에 있는 내용을 저장하기 ---
                resultIntent.putExtra("name",etName.getText().toString());
                resultIntent.putExtra("phone",etPhone.getText().toString());

                //setResult : 결과값 설정 - 결과 코드 , 결과값을 갖고 있는 intent

                setResult(RESULT_OK, resultIntent);
                break;

            case RESULT_CANCELED:
                setResult(RESULT_CANCELED);
                break;
        }
        finish(); // 현재 액티비티 종료하면서 결과값 전달달
    }


}
