package com.lec.android.loginprofile;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by choi on 2017-05-08.
 */

public class UserListAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<MemberDTO> memberList;
    private LayoutInflater inflater;

    private Activity activity;
    private ArrayList<MemberDTO> saveList;


    public UserListAdapter(Context mContext, ArrayList<MemberDTO> memberList, Activity parentAtivity,
                           ArrayList<MemberDTO> saveList
    ) {
        this.mContext = mContext;
        this.memberList = memberList;
        inflater=(LayoutInflater)mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
        activity=parentAtivity;
        this.saveList=saveList;
    }

    @Override
    public int getCount() {
        return memberList.size();
    }

    @Override
    public Object getItem(int position) {
        return memberList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {

        if(convertView==null){
            convertView=inflater.inflate(R.layout.user, parent, false);
        }

        TextView userID =(TextView)convertView.findViewById(R.id.userID);
        TextView userName =(TextView)convertView.findViewById(R.id.userName);
        TextView userPassword=(TextView)convertView.findViewById(R.id.userPassword);
        TextView userAge =(TextView)convertView.findViewById(R.id.userAge);

        userID.setText("아이디 : " +memberList.get(position).getUserID());
        userName.setText("이름 : " +memberList.get(position).getUserName());
        userPassword.setText("패스워드 : "+ memberList.get(position).getUserPassword());
        userAge.setText("나이 : " + memberList.get(position).getUserAge());



        Button button =(Button)convertView.findViewById(R.id.deleteButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Toast.makeText(activity, "e" +position, Toast.LENGTH_SHORT).show();


                Response.Listener<String> responseListener =new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {

                        try{
                            JSONObject jsonResposne =new JSONObject(response);
                            boolean success=jsonResposne.getBoolean("success");
                            if(success){

                                //검색 처리를 위한 saveList 제거
                                //현재 memberList i 값과 검색 처리를 위한 i 값이 다르다.
                                //즉 memberList 는 검색 결과 데이터 만 담겨 있고
                                //saverList 는 전체 데이터가 담겨 있기 때문이다.
                                for(int i=0; i<saveList.size(); i++){
                                    if(saveList.get(i).getUserID().equals(
                                            memberList.get(position).getUserID().toString())){
                                        saveList.remove(i);
                                        break;
                                    }
                                }

                                //ArrayList 에서 해당부분 제거
                                memberList.remove(position);

                                //어댑터에 알려줌
                                notifyDataSetChanged();
                            }

                        }catch (Exception e){
                            e.printStackTrace();
                        }

                    }
                };

                // Toast.makeText(activity, userID.getText().toString(), Toast.LENGTH_SHORT).show();

                DeleteRequest deleteRequest =new DeleteRequest(memberList.get(position).getUserID().toString(), responseListener);
                RequestQueue queue= Volley.newRequestQueue(activity);
                queue.add(deleteRequest);


            }
        });


/*
        if((position%2)==1){
          //  convertView.setBackgroundColor(0xffff8800);

        }else {
            convertView.setBackgroundColor(0xff748790);
        }
*/

        return convertView;
    }




}
