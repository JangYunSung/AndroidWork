package com.lec.android.loginprofile;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class ManagementActivity extends AppCompatActivity {

    //TextView userListTextView;
    private ListView listView;

    private ArrayList<MemberDTO> members;
    private ArrayList<MemberDTO> saveList;
    private UserListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);


        //  userListTextView=(TextView)findViewById(userListTextView);
        listView=(ListView)findViewById(R.id.listView);


        Intent intent=getIntent();

        if(intent!=null) {

     /*        Bundle membersBundle = intent.getBundleExtra("members");
             membsers=(ArrayList<MemberDTO>) membersBundle.get("members");
*/
            //검색처리에서 members 를 클리어 할 때 saveList 도 클리어 되는 현상 때문에
            //데이터를 다르게 처리 하였다.
            //=>오류 Bundle 에서 오류 가 있어서 변경


            members=new ArrayList<>();
            saveList = new ArrayList<>();

            String membersData =intent.getStringExtra("members");
            String saveListData =intent.getStringExtra("saveList");
            members=parsing(membersData);
            saveList=parsing(saveListData);


            adapter =new UserListAdapter(ManagementActivity.this, members, this, saveList);
            listView.setAdapter(adapter);


/*
            StringBuilder builder = new StringBuilder();
            for (MemberDTO dto : membsers) {

                builder.append("아이디 : "  + dto.getUserID()+"\n");
                builder.append( "이름 : " + dto.getUserName() +"\n");
                builder.append("패스워드 : " + dto.getUserPassword() +"\n");
                builder.append("나이 : " +dto.getUserAge() + "\n");
                builder.append("--------------------------------------\n\n\n");

            }
*/


        }


        EditText search =(EditText)findViewById(R.id.search);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                searchUser(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }


    public void searchUser(String search){
        //검색에 글자를 입력하면 members 리스트는 제거
        members.clear();

        Toast.makeText(ManagementActivity.this, "memberSize : " + members.size() + " ,  saverList Size :" +
                saveList.size()+" ", Toast.LENGTH_SHORT).show();

        //saver List 에서 검색 목록을 찾은 후 이것을
        //members 에 데이터를 담는다.
        for(int i=0; i<saveList.size(); i++){

            if(saveList.get(i).getUserID().contains(search)){
                members.add(saveList.get(i));
                Log.i("TT", String.valueOf(i));
                //Toast.makeText(ManagementActivity.this, String.valueOf(i), Toast.LENGTH_SHORT).show();
            }
        }

        // 데이터가 갱신 되었음을 어댑터에 알린다.
        adapter.notifyDataSetChanged();

    }



    public  ArrayList<MemberDTO> parsing(String data) {

        ArrayList<MemberDTO> arrayList=new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = new JSONArray(jsonObject.getString("response"));


            for (int i = 0; i < jsonArray.length(); i++) {

                MemberDTO member = new MemberDTO();

                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
                member.setUserID(jsonObject1.getString("userID"));
                member.setUserName(jsonObject1.getString("userName"));
                member.setUserPassword(jsonObject1.getString("userPassword"));
                member.setUserAge(jsonObject1.getInt("userAge"));

                if (!member.getUserID().equals("admin")) {
                    arrayList.add(member);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return arrayList;
    }


}
