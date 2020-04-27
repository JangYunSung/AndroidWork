package com.lec.android.loginprofile;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by choi on 2017-05-09.
 */

public class DeleteRequest extends StringRequest {

    final static private String URL="http://braverokmc2.dothome.co.kr/Delete.php";
    private Map<String, String> parameter;

//    public DeleteRequest(String userID,
//                         Response.Listener<String> listener) {
//
//        super(Method.POST, URL, listener, null);
//
//        try {
//            parameter=new HashMap<>();
//            parameter.put("userID", userID);
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }

    @Override
    protected Map<String, String> getParams()  {
        return parameter;
    }


}