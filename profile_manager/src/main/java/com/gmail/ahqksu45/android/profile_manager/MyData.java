package com.gmail.ahqksu45.android.profile_manager;

import java.io.Serializable;

public class MyData implements Serializable {

    private String name;
    private String phone;

    public MyData() {
    }

    public MyData(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //MyData 를 문자열로 출력할 시 호출
    public String toString(){
        return String.format("name: %s \n phone: %s" , name ,phone);
    }


}
