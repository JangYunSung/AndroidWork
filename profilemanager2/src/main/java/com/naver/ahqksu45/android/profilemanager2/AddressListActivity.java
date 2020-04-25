package com.naver.ahqksu45.android.profilemanager2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AddressListActivity extends AppCompatActivity {

    private ListView addrList;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addresslistactivity);

        databaseHelper = new DatabaseHelper(this);

        setTitle("Profile Book");

        ActionBar actionBar =getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        addrList = (ListView)findViewById(R.id.addrList);

        List<AdderssInfo> addressList = new ArrayList<AdderssInfo>();
        addressList= databaseHelper.selectAddressData();

        addrList.setAdapter(new AddrListAdaptor(addressList, this));

    }
}
