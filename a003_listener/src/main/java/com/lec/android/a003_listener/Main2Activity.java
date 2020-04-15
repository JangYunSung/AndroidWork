package com.lec.android.a003_listener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0,
            btnadd, btndiv, btnmul, btnsub, btnequlas, btnClear,btndel,btnjum;

    TextView text;
    EditText edit;

    Double a;
    int operator = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn0 = (Button) findViewById(R.id.btn0);
        btnadd = (Button) findViewById(R.id.btnadd);
        btnmul = (Button) findViewById(R.id.btnmul);
        btndiv = (Button) findViewById(R.id.btndiv);
        btnsub = (Button) findViewById(R.id.btnsub);
        btnequlas = (Button) findViewById(R.id.btnequals);
        btnClear = (Button) findViewById(R.id.btnClear);
        btndel = (Button) findViewById(R.id.btndel);
        btnjum = (Button) findViewById(R.id.btnjum);

        text = (TextView) findViewById(R.id.t1);
        edit = (EditText) findViewById(R.id.e1);

        OnClickListener cl = new OnClickListener() {


            @Override
            public void onClick(View v) {




                    if(v == btn1) {
                        edit.setText(edit.getText().toString() + 1);
                    } else if (v == btn2) {
                        edit.setText(edit.getText().toString() + 2);
                    } else if (v == btn3) {
                        edit.setText(edit.getText().toString() + 3);
                    } else if (v == btn4) {
                        edit.setText(edit.getText().toString() + 4);
                    } else if (v == btn5) {
                        edit.setText(edit.getText().toString() + 5);
                    } else if (v == btn6) {
                        edit.setText(edit.getText().toString() + 6);
                    } else if (v == btn7) {
                        edit.setText(edit.getText().toString() + 7);
                    } else if (v == btn8) {
                        edit.setText(edit.getText().toString() + 8);
                    } else if (v == btn9) {
                        edit.setText(edit.getText().toString() + 9);
                    } else if (v == btn0) {
                        edit.setText(edit.getText().toString() + 0);
                    } else if (v == btnjum) {
                        edit.setText(edit.getText().toString() + ".");
                    } else if (v == btndel) {
                        edit.setText(edit.getText().toString().substring(0,edit.getText().length()-1));
                    } else if (v == btnadd) {
                        a = Double.valueOf(0+edit.getText().toString().trim());
                        operator = 1;
                    } else if (v == btndiv) {
                        a = Double.valueOf(0+edit.getText().toString().trim());
                        operator = 2;
                    } else if (v == btnmul) {
                        a = Double.valueOf(0+edit.getText().toString().trim());
                        operator = 3;
                    } else if (v == btnsub) {
                        a = Double.valueOf(0+edit.getText().toString().trim());

                        operator = 4;
                    } else if (v == btnequlas) {
                        edit.setText("");
                        if (operator == 1) {
                            a += Double.valueOf(0+edit.getText().toString().trim());
                            edit.setText(Double.toString(a).substring(0,edit.getText().length()+3));
                        } else if (operator == 2) {
                            a /= Double.valueOf(0+edit.getText().toString().trim());
                            edit.setText(Double.toString(a).substring(0,edit.getText().length()+3));
                        } else if (operator == 3) {
                            a *= Double.valueOf(0+edit.getText().toString().trim());
                            edit.setText(Double.toString(a).substring(0,edit.getText().length()+3));
                        } else if (operator == 4) {
                            a -= Double.valueOf(0+edit.getText().toString().trim());
                            edit.setText(Double.toString(a).substring(0,edit.getText().length()+3));
                        }

                    } else if (v == btnClear) {
                        edit.setText("");
                    }


                }




        };
        btn1.setOnClickListener(cl);
        btn2.setOnClickListener(cl);
        btn3.setOnClickListener(cl);
        btn4.setOnClickListener(cl);
        btn5.setOnClickListener(cl);
        btn6.setOnClickListener(cl);
        btn7.setOnClickListener(cl);
        btn8.setOnClickListener(cl);
        btn9.setOnClickListener(cl);
        btn0.setOnClickListener(cl);
        btnadd.setOnClickListener(cl);
        btndiv.setOnClickListener(cl);
        btnmul.setOnClickListener(cl);
        btnsub.setOnClickListener(cl);
        btnequlas.setOnClickListener(cl);
        btnClear.setOnClickListener(cl);
        btndel.setOnClickListener(cl);
        btnjum.setOnClickListener(cl);
        }

}