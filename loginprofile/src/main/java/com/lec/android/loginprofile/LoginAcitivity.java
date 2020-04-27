package com.lec.android.loginprofile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

//로그인 초기 화면
public class LoginActivity extends AppCompatActivity {


    EditText idText, passwordText;
    Button loginButton;

    TextView registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);


        idText =(EditText)findViewById(R.id.idText);
        passwordText =(EditText)findViewById(R.id.pswordText);
        registerBtn =(TextView)findViewById(R.id.registerBtn);
        loginButton=(Button)findViewById(R.id.loginButton);



        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String userID=idText.getText().toString();
                final String userPassword=passwordText.getText().toString();


                Response.Listener<String> responseListenser =new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try{

                            JSONObject jsoneRessponse=new JSONObject(response);
                            boolean succcess=jsoneRessponse.getBoolean("success");
                            if(succcess){
                                String userID= jsoneRessponse.getString("userID");
                                String userPassword=jsoneRessponse.getString("userPassword");
                                Intent intent=new Intent(LoginActivity.this, MainActivity.class);
                                intent.putExtra("userID", userID);
                                intent.putExtra("userPassword", userPassword);
                                LoginActivity.this.startActivity(intent);
                            }else{
                                AlertDialog.Builder builder=new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("로그인에 실패하였습니다.");
                                builder.setNegativeButton("다시 시도", null);
                                builder.create();
                                builder.show();
                            }

                        }catch(Exception e){

                        }

                    }
                };

                LoginRequest loginRequest= new LoginRequest(userID, userPassword, responseListenser);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);



            }
        });

    }
}