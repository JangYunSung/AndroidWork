package com.gmail.ahqksu45.android.profilemanagerm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button testBtn;
    FloatingActionButton addBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        testBtn=(Button)findViewById(R.id.main_test_btn);
        addBtn = (FloatingActionButton)findViewById(R.id.fab);


//        testBtn.setOnClickListener(this);
        addBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==addBtn){
            Intent intent = new Intent(this, AddProfileActivity.class);
            startActivity(intent);
        }else if (v== testBtn){
            Intent intent = new Intent(this, ReadProfileActivity.class);
            startActivity(intent);
        }
    }
}
