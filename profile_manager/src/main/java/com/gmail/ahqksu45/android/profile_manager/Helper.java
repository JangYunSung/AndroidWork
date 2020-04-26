package com.gmail.ahqksu45.android.profile_manager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

// SQLiteOpenHelper
    public class Helper extends SQLiteOpenHelper {
        private Helper(@Nullable Context context, @Nullable String name,
                       @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
            Log.d("myapp", "SQLiteOpenHelper 생성");
        }
        String tableName = "profile";
        //제일 먼저 할것!
        //생성자를 private 로 만들어야 한다!
        private static Helper instance = null;
        public static Helper getInstance(@Nullable Context context, @Nullable String name,
                                         @Nullable SQLiteDatabase.CursorFactory factory, int version) {
            if(instance == null) {
                instance = new Helper(context , name , factory , version); //인스턴스 생성!
            }
            return instance;
        }





        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.d("myapp", "SQLiteOpenHelper] onCreate() 호출");

//        (profileid, name, phonenum, address, jumin, profileno,bank,email,card,bigo)
            String sql = "CREATE TABLE profile (" +
//                    "profileid TEXT PRIMARY KEY, " +
                    "name TEXT NOT NULL, " +
                    "phonenum INTEGER " +
//                    "address TEXT," +
//                    "jumin INTEGER NOT NULL," +
//                    "profileno TEXT," +
//                    "bank TEXT," +
//                    "email TEXT," +
//                    "card INTEGER," +
//                    "bigo TEXT"+
                    ")";

            db.execSQL(sql);
        }

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
//                String profileid = c.getString(0);
                String name = c.getString(1);
                String phonenum = c.getString(2);
//                String address = c.getString(3);
//                String jumin = c.getString(4);
//                String profileno = c.getString(5);
//                String bank = c.getString(6);
//                String email = c.getString(7);
//                String card = c.getString(8);
//                String bigo = c.getString(9);

                String msg = String.format("id: %s \n name: %s \n  phonenum: %d \n " +
                        "address: %s \n  jumin: %d \n profileno: %s \n bank: %s \n email: %s \n " +
                        "card: %s \n bigo: %s",
//                        profileid,
                        name, phonenum
//                        ,address, jumin,profileno,bank,email,card,bigo
                );



//             .add(new Profile(profileid, name, phonenum, address, jumin,profileno,bank,email,card,bigo));



                Log.d("myapp", msg);
            } // end while




//        return items;
        }

    }


