package com.naver.ahqksu45.android.profilemanager2;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DatabaseHelper {
    private static SQLiteDatabase db;
    private Context context;

    public DatabaseHelper(Context context){
        this.context = context;
        if (DatabaseHelper.db == null){
            DatabaseHelper.db = context.openOrCreateDatabase("profile", context.MODE_PRIVATE, null);
            this.createTable();
        }

    }

    public void changeContext(Context context){
        this.context = context;
    }


    private void createTable() {

        if (!isExistsTable()){

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

    }

    private boolean isExistsTable() {
        String sql = "SELECT COUNT(NAME)" +
                "FROM sqlite_master " +
                "WHERE type = 'table' " +
                "AND name = 'profile";


        Cursor c = db.rawQuery(sql,null);
        if (c.moveToNext()){
            return  c.getInt(0) > 0 ;
        }
        return false;

    }


    public void insertAdderssData(AdderssInfo adderssInfo){

        Log.d("profile QUERY " , "insert DB!!!!" );

        String sql = context.getString(R.string.INSER_QUERY);
        sql = String.format(sql,""+adderssInfo.getName(),adderssInfo.getPhone()
                //더추가
        );


        Log.d("profile QUERY " , sql );
        db.execSQL(sql);
    }


}

