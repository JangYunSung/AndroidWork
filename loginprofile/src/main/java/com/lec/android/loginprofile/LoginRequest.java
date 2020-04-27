package com.lec.android.loginprofile;


import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by choi on 2017-05-02.
 */

public class LoginRequest extends StringRequest {

    final static private String URL="http://braverokmc2.dothome.co.kr/Login.php";

    private Map<String, String> parameters;

/*    public RegisterRequest(int method, String url,
                           Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }*/

    public LoginRequest(String userID, String userPassword,
                        Response.Listener<String> listener){

        super(Method.POST, URL, listener, null);
        try {
            //한글 깨짐 방지
            //  String st=URLEncoder.encode(userName, "UTF-8");

            parameters=new HashMap<>();
            parameters.put("userID", userID);
            parameters.put("userPassword", userPassword);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    protected Map<String, String> getParams() {
        return parameters;
    }


}

