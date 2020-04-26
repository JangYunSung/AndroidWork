package com.lec.android.databasetest;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2;
    TextView textView;

    String databaseName, tableName;

    Toast toast;

    SQLiteDatabase database;
    CustomerDatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1=(EditText)findViewById(R.id.editText1);
        editText2=(EditText)findViewById(R.id.editText2);
        textView=(TextView)findViewById(R.id.text1);

    }


    public void onClick(View v){

        switch (v.getId()){

            case R.id.button1:
                databaseName=editText1.getText().toString();
                try {
                   /* //데이터 베이스가 없으면 생성 또는 존재하면 오픈
                    database =openOrCreateDatabase(databaseName, Context.MODE_PRIVATE, null);*/

                    //databaseHelper= new CustomerDatabaseHelper(getApplicationContext(), databaseName, null, 1);
                    //버전 2로 업그레이드 할 경우
                    databaseHelper= new CustomerDatabaseHelper(getApplicationContext(), databaseName, null, 2);
                    database=databaseHelper.getWritableDatabase();

                    println("데이터베이스를 열었습니다. : " + databaseName);

                }catch (Exception e){
                    e.printStackTrace();
                }
                break;


            case R.id.button2:
                // createTable();
                break;


            //데이터 삽입하기
            case R.id.button3:

                try{
                    if(tableName==null){
                        tableName=editText2.getText().toString();
                    }

                    if(database!=null){

                        String sql =String.format(
                                "insert into "+tableName + "  ( name, age, mobile )" +
                                        " values ( '%s',  %d, '%s' )",  "홍길동", 33, "01038141136");

                        database.execSQL(sql);
                    }
                    println("데이터가 삽입 되었습니다.");

                }catch (Exception e){
                    println("데이터베이스를 먼저 열어여 합니다.");
                    e.printStackTrace();
                }
                break;

            //데이터 조회하기
            case R.id.button4:
                try{
                    if(tableName==null){
                        tableName=editText2.getText().toString();
                    }
                    if(database!=null){
                        String sql ="select name, age, mobile from " +tableName ;
                        Cursor cursor =database.rawQuery(sql, null);
                        int count =cursor.getCount();
                        for(int i=0; i<count; i++){
                            cursor.moveToNext();
                            String name =cursor.getString(0);
                            int age =cursor.getInt(1);
                            String mobile =cursor.getString(2);
                            println("레코드 # "+ i+" :  " + name + " ," + age + " ," + mobile);
                        }
                        if(cursor!=null) cursor.close();
                    }
                }catch(Exception e){
                    println("데이터베이스를 먼저 열어여 합니다.");
                    e.printStackTrace();
                }
                break;


        }

    }



    private void println(String data){
        textView.append(data +"\n");
    }


  /*  SQLiteDatabase db;
    //  Context.MODE_PRIVATE : 단독 사용 모드
    public SQLiteDatabase dbConn(){
        //데이터베이스를 오픈하거나 생성
        db=this.openOrCreateDatabase("product.db", Context.MODE_PRIVATE, null);

        //테이블이 존재하지 않으면  create
        // 자동증가컬럼은 자료형을 integer 로 하고 primary key 로 설정
        Log.v("메시지",  "dbConn() start");
        try{

            String sql ="CREATE TABLE if not exists " + tableName + " ( " +
                    " _id integer PRIMARY KEY AUTOINCREMENT , " +
                    " name text, " +
                    " age integer," +
                    " mobile text " +
                    " ) ";

            db.execSQL(sql);  // select 이외의 쿼리

        }catch (Exception e){
            e.printStackTrace();
            Log.v("메시지",  "dbConn() execSQL : " + e.getMessage());
        }

        return db;
    }

    public void list(){

        List<Customer>  items =new ArrayList<>();
        SQLiteDatabase db =null;
        Cursor cursor =null; //결과셋, 레코드셋

        try{

            db =dbConn();
            // select * from product 로 * 를 쓰지말고 컬럼이름을 나열 해야 한다.
            // 왜냐 하면 cursor.getInt(0); 컬럼 이름은 사용할 수 없음 때문이다.
            String sql ="select name, age, mobile from " +tableName ;

            // select 쿼리를 실행하여 결과셋을 커서에 리턴함
            // execSQL()  - select  이외의 쿼리
            // rawQuery() - select 쿼리 전용
            // rawQuery(sql , null) - null 자리에 조건 검색 을 쓰면 된다.
            // 그러나 쿼리에 조건절을 써도 된다.
            cursor =db.rawQuery(sql, null);
            //커서.moveToNext() 다음 레코드가 존재하면 true 리턴
            while(cursor.moveToNext()){
                //커서.get자료형(컬럼의 인텍스) 0 부터, 컬럼 이름은 사용할 수 없음
                String name =cursor.getString(0);
                int age =cursor.getInt(1);
                String mobile =cursor.getString(2);
                println("레코드 #  :  " + name + " ," + age + " ," + mobile);
              //  items.add(new ProductDTO(id, product_name, price, amount));

            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(cursor!=null) cursor.close();
            if(db !=null)db.close();
        }

    }


*/


    class CustomerDatabaseHelper extends SQLiteOpenHelper {

        public CustomerDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }


        @Override
        public void onOpen(SQLiteDatabase db) {
            super.onOpen(db);
            String str="Helper 의 onOpen() 호출됨";
            toastShow(str);
            println(str);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            // 처음인 경우 onCreate 생성
            String str="Helper 의 onCreate() 호출됨";
            toastShow(str);
            println(str);


            createTable(db);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // 처음인 경우 onCreate 생성
            String str="Helper 의 onUpgrade() 호출됨"+oldVersion +" -> " + newVersion;
            toastShow(str);
            println(str);


            //기존에 테이블이 존재하는 경우 업그레이드 된 테이블을 생성 시킴
            changeTable(db);

        }
    }



    public void createTable(SQLiteDatabase db){
        tableName=editText2.getText().toString();
        try {
            if(db!=null){
                // 내부에서 기본적으로 사용하는 경우 인덱스 밑줄
                // if not exists 테이블이 존재하면 생성 하지 않는다.
                db.execSQL("CREATE TABLE if not exists " + tableName + " ( " +
                        " _id integer PRIMARY KEY AUTOINCREMENT , " +
                        " name text, " +
                        " age integer," +
                        " mobile text " +
                        " ) ");
            }
            println("테이블을 생성하였습니다. "+ tableName);
        }catch (Exception e){
            println("데이터베이스를 먼저 열어야 합니다.");
            e.printStackTrace();
        }
    }


    public void changeTable(SQLiteDatabase db){
        try{
            if(db!=null){
                String sql =" CREATE TABLE if not exists " + "PRODUCT" + " (" +
                        " _id integer PRIMARY key AUTOINCREMENT , " +
                        " name text, " +
                        " price  integer" +
                        " )";
                db.execSQL(sql);
            }
            println("테이블을 생성하였습니다. "+ "PRODUCT");
        }catch (Exception e){
            println("데이터베이스를 먼저 열어야 합니다.");
            e.printStackTrace();
        }
    }



    public void toastShow(String str ){

        if(toast==null){
            toast=Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT);
        }else{
            toast.setText(str);
        }
        toast.show();
    }



}