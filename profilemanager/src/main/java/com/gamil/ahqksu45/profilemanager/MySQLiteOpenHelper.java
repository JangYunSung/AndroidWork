package com.gamil.ahqksu45.profilemanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

// SQLiteOpenHelper
// 안드로이드에서 SQLite3 데이터베이스를 좀더 쉽게(?) 사용할수 있도록 제공되는 클래스
public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    private MySQLiteOpenHelper(@Nullable Context context, @Nullable String name,
                              @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        Log.d("myapp", "SQLiteOpenHelper 생성");
    }
    String tableName = "profile";
    //제일 먼저 할것!
    //생성자를 private 로 만들어야 한다!
    private static MySQLiteOpenHelper instance = null;
    public static MySQLiteOpenHelper getInstance(@Nullable Context context, @Nullable String name,
                                                 @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        if(instance == null) {
            instance = new MySQLiteOpenHelper(context , name , factory , version); //인스턴스 생성!
        }
        return instance;
    }





    // 앱설치후 최초에 데이터베이스가 '없는경우', 데이터 베이스 생성을 위해 호출되는 콜백
    // 주로 DDL 등 테이블 생성하는 코드 작성
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("myapp", "SQLiteOpenHelper] onCreate() 호출");

//        (profileid, name, phonenum, address, jumin, profileno,bank,email,card,bigo)
        String sql = "CREATE TABLE profile (" +
                "profileid TEXT PRIMARY KEY, " +
                "name TEXT NOT NULL, " +
                "phonenum INTEGER, " +
                "address TEXT," +
                "jumin INTEGER NOT NULL," +
                "profileno TEXT," +
                "bank TEXT," +
                "email TEXT," +
                "card INTEGER," +
                "bigo TEXT"+
                ")";

        db.execSQL(sql);
    }

    // 데이터베이스의 '버젼' 이 바뀌었을때 호출되는 콜백 메소드
    // '버젼' 이 바뀌었을때  기존에 설치 운영되고 있는 데이터베이스르 어떻게 변경할 것인지 작성
    //  각 버젼의 변경 내용들을 버젼마다 작성해야 함.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("myapp", "SQLiteOpenHelper] onUpgrade호출:" + oldVersion + "->" + newVersion);

        String sql = "DROP TABLE IF EXISTS profile";   // 기존 테이블 삭제
        db.execSQL(sql);
        onCreate(db);   // 다시 테이블 생성

    }


    void select(){
        // SELECT 문을 위한 query() 메소드
        Cursor c = this.getWritableDatabase().query(tableName, null, null, null, null, null, null);
        while(c.moveToNext()){
            String profileid = c.getString(0);
            String name = c.getString(1);
            String phonenum = c.getString(2);
            String address = c.getString(3);
            String jumin = c.getString(4);
            String profileno = c.getString(5);
            String bank = c.getString(6);
            String email = c.getString(7);
            String card = c.getString(8);
            String bigo = c.getString(9);

            String msg = String.format("id: %s \n name: %s \n  phonenum: %d \n " +
                    "address: %s \n  jumin: %d \n profileno: %s \n bank: %s \n email: %s \n " +
                    "card: %s \n bigo: %s", profileid, name, phonenum, address, jumin,profileno,bank,email,card,bigo);



//             .add(new Profile(profileid, name, phonenum, address, jumin,profileno,bank,email,card,bigo));



            Log.d("myapp", msg);
        } // end while




//        return items;
    }

}
