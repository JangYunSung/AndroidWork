package com.lec.android.profilemanager3;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.Contacts;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity imple  {



//    특히 둘째 줄 클래스가 자동으로 임포트되지 않으면 수동으로 넣어준다.



            TextView textView;



    protected void onCreate(Bundle savedInstanceState) {

//    	...

        super.onCreate(savedInstanceState);
        textView = (TextView) findViewById(R.id.textView);


        ArrayList<String> phoneLists = phoneBook();

        Collections.sort(phoneLists);

        for (String item : phoneLists) textView.append("\n" + item);

    }



//    이하의 메소드는 참고 페이지에서 베껴와서 수정한 것이다.



    private Cursor getURI() {

        // 주소록 URI

        Uri people = Contacts.CONTENT_URI;



        // 검색할 컬럼 정하기

        String[] projection = new String[] { Contacts._ID, Contacts.DISPLAY_NAME, Contacts.HAS_PHONE_NUMBER };



        // 쿼리 날려서 커서 얻기

        String[] selectionArgs = null;

        String sortOrder = ContactsContract.Contacts.DISPLAY_NAME + " COLLATE LOCALIZED ASC";



        return getContentResolver().query(people, projection, null, selectionArgs, sortOrder);

    }



//    위 메소드와 비교하여 아래 메소드의 '컬럼명으로 컬럼 인덱스 찾기'는 불필요한 듯하여 주석처리하고 ... int id = cursor.getInt(0);



    public ArrayList<String> phoneBook() {

        ArrayList<String> phoneLists = new ArrayList<String>();



        try {

            Cursor cursor = getURI();                    // 전화번호부 가져오기



            int end = cursor.getCount();                // 전화번호부의 갯수 세기



            String [] name = new String[end];    // 전화번호부의 이름을 저장할 배열 선언

            String [] phone = new String[end];    // 전화번호부의 이름을 저장할 배열 선언

            int count = 0;



            if(cursor.moveToFirst()) {

                // 컬럼명으로 컬럼 인덱스 찾기

                // int idIndex = cursor.getColumnIndex("_id");



                do {

                    // 요소값 얻기

                    int id = cursor.getInt(0);

                    // int id = cursor.getInt(idIndex);

                    String phoneChk = cursor.getString(2);

                    if (phoneChk.equals("1")) {

                        Cursor phones = getContentResolver().query(

                                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,

                                null,

                                ContactsContract.CommonDataKinds.Phone.CONTACT_ID

                                        + " = " + id, null, null);



                        while (phones.moveToNext()) {

                            phone[count] = phones

                                    .getString(phones

                                            .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                        }

                    }

                    name[count] = cursor.getString(1);



                    // 개별 연락처 삭제

                    // rowNum = getBaseContext().getContentResolver().delete(RawContacts.CONTENT_URI, RawContacts._ID+ " =" + id,null);



                    // 개별 연락처 수집

                    phoneLists.add("\n" + String.format("% 4d", id) +", [이름] " + name[count]+", [번호] " + phone[count] + "\n");

                    // textView.append("\n" + id +", [이름] " + name[count]+", [번호] " + phone[count] + "\n");

                    count++;



                } while(cursor.moveToNext() || count > end);

            }

        }

        catch (Exception e) {}



        return phoneLists;

    }

}
