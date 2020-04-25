package com.gmail.ahqksu45.android.profile_manager;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ListView IvAddressList;
    ArrayAdapter addressAdapter;
    ArrayList<MyData> addressList;

    public final static int SUB_ACTIVITY_1 = 100;
    public final static int SUB_ACTIVITY_2 = 101;

    MyData selectedData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addressList = new ArrayList<MyData>(); // 원본데이터 저장
        addressList.add(new MyData("이름 ", "번호"));

        //어뎁터 생성
        addressAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, addressList);

        // 어탭터와 리스트뷰를 연결
        IvAddressList = (ListView) findViewById(R.id.listview);
        IvAddressList.setAdapter(addressAdapter);

        // 리스트 항복 롱클릭 시 새로운 Activity를 호출하며 현재 클릭한 항복의 연락처를 전달
        IvAddressList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                selectedData = addressList.get(position);

                Intent intent = new Intent(MainActivity.this, Sub2Activity.class);
                //롱클릭하여 선택한 데이터값을 저장하여 intent 넘겨줌
                intent.putExtra("name", selectedData.getName());
                intent.putExtra("phone", selectedData.getPhone());

                // MyData 객체 (Serializable 구현 객체 ) 를 직접 intent 에 넣고자 할 경우
                // intent.putExtra("my_data" , selectedData) ;
                startActivityForResult(intent, SUB_ACTIVITY_2);
                return true;
            }
        });

    }//end onCrate

    public void onClick(View v) { // 번호 추가 버튼 클릭시
        switch (v.getId()) {
            case R.id.btnAdd:
                Intent intent = new Intent(this, Sub1Activity.class);
                startActivityForResult(intent, SUB_ACTIVITY_1);
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //반환 결과 확인 부분, 호출한 액티비티를 종료하고 결과값을 전달 받으면 자동으로 호출됨
        // StartActivityForResult() 호출 시 사용한 RequsetCode 일치 검사
        // 마지막 매개변수 data는 결과값을 담고 있는 intent
        if (requestCode == SUB_ACTIVITY_1) {
            //결과 코드 검사
            switch (resultCode) {
                case RESULT_OK:
                    String name = data.getStringExtra("name");
                    String phone = data.getStringExtra("phone");
                    // ListView 의 원본 데이터에 삽입 후 adapter 갱신
                    addressList.add(new MyData(name, phone));
                    addressAdapter.notifyDataSetChanged();
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(this, "Canceled!!!", Toast.LENGTH_SHORT).show();
                    break;
            }
        } else if (requestCode == SUB_ACTIVITY_2) {
            switch (resultCode) {
                case RESULT_OK:
                    //선택된 selectedData에 새로 입력받아 저장된 intent의 값으로 저장함
                    selectedData.setName(data.getStringExtra("name"));
                    selectedData.setPhone(data.getStringExtra("phone"));
                    //데이터가 변경되었음을 어댑터에게 알려준다
                    addressAdapter.notifyDataSetChanged();
                    break;
                case RESULT_CANCELED:
                    Toast.makeText(this, "Canceled!!!! ", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}//end Activity



