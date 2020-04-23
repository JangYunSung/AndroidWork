package com.gamil.ahqksu45.profilemanager;

import java.io.Serializable;

// 회원정보를 데이터를 담을 클래스
public class Profile implements Serializable {
    String profileid;
    String name;
    String phonenum ;
    String address ;
    String jumin;
    String profileno;
    String bank;
    String email ;
    String card ;
    String bigo ;


    public Profile() {
    }

    public Profile(String profileid, String name, String phonenum, String address,
                   String jumin, String profileno, String bank, String email, String card, String bigo) {
        this.profileid = profileid;
        this.name = name;
        this.phonenum = phonenum;
        this.address = address;
        this.jumin = jumin;
        this.profileno = profileno;
        this.bank = bank;
        this.email = email;
        this.card = card;
        this.bigo = bigo;
    }

    public String getProfileid() {
        return profileid;
    }

    public void setProfileid(String profileid) {
        this.profileid = profileid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJumin() {
        return jumin;
    }

    public void setJumin(String jumin) {
        this.jumin = jumin;
    }

    public String getProfileno() {
        return profileno;
    }

    public void setProfileno(String profileno) {
        this.profileno = profileno;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getBigo() {
        return bigo;
    }

    public void setBigo(String bigo) {
        this.bigo = bigo;
    }
} // end profile
