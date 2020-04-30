package com.gmail.ahqksu45.android.profilemanagerm;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddProfileActivity extends AppCompatActivity implements View.OnClickListener{

    EditText nameView , emailView , phoneView ;
    Button addBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_profile);

        nameView = (EditText)findViewById(R.id.add_name);
        emailView = (EditText)findViewById(R.id.add_email);
        phoneView = (EditText)findViewById(R.id.add_phone);
        addBtn = (Button) findViewById(R.id.add_btn);

        addBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name = nameView.getText().toString();
        String email = emailView.getText().toString();
        String phone = phoneView.getText().toString();

        if (name == null || name.equals("")){
            Toast t = Toast.makeText(this, R.string.add_name_null, Toast.LENGTH_SHORT);
            t.show();
        }else{
            DBHelper helper = new DBHelper(this);
            SQLiteDatabase db = helper.getWritableDatabase();
            db.execSQL("insert into tb_profile(name, email , phone) values (?,?,?)",
                new String[]{name , email , phone});
            db.close();

            finish();
        }



    }
}
