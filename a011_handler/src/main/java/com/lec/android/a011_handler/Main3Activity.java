package com.lec.android.a011_handler;
/**
 * • 작업 스케쥴링:
 *   ▫ 작업스레드의 실행 시점을 조절하여, 작업 로드가 많은 작업을 나중으로 미룸으로써
 *     응용프로그램이 '끊김'없이 실행될수 있도록할수 있다.
 *
 *  •  Handler 사용한 구현 방법:
 *        boolean sendMessageAtTime (Message msg, uptimeMillis)
 *        boolean sendEmptyMessageAtTime (what, uptimeMillis)
 *        boolean sendMessageDelayed (Message msg, long delayMillis)
 *        boolean sendEmptyMessageDelayed (what, long delayMillis)
 *        boolean postAtTime (Runnable r, uptimeMillis)
 *        boolean postDelayed (Runnable r, long delayMillis)
 *        boolean postAtFrontOfQueue(Runnable r)
 *
 *        xxxAtFrontOfQueue – 큐의 가장 앞에 메세지를 삽입합니다.
 *        xxxAtTime – 지정한 시간으로 설정하여 큐에 삽입합니다.
 *        xxxDelayed – 현재시간으로부터 지정한 시간만큼 뒤로 설정하여 큐에 삽입합니다.
 *
 *  •  java.util.Timer, java.util.TimerTask 사용한 구현 방법:
 *
 */



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
}
