package com.naver.ahqksu45.android.profilemanager2;

import android.provider.ContactsContract;

public class AdderssInfo {

    private String name;
    private String phone;


    public AdderssInfo() {
    }

    public AdderssInfo(String name, String phone) {
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
}
