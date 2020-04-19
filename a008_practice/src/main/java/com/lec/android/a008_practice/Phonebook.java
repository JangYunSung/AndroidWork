package com.lec.android.a008_practice;

import java.io.Serializable;

// 전화번호부 데이터를 담을 클래스
public class Phonebook implements Serializable {
    String name; // 이름
    String age; // 전화번호
    String addr; // 이메일

    // 제맘 알죠?
    public Phonebook() {
    }

    public Phonebook(String name, String phone, String email) {
        this.name = name;
        this.age = phone;
        this.addr = email;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
} // end Phonebook
