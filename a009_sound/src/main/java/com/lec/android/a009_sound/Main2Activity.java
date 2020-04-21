package com.lec.android.a009_sound;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

public class Main2Activity extends AppCompatActivity {


    private ImageView btnPlay;
    private ImageView btnPause;
    private ImageView btnResume;
    private ImageView btnStop;
    SeekBar sb; // 음악 재생위치를 나타내는 시크바
    MediaPlayer mp;    // 음악 재생을 위한 객체


    int pos; //  재생위치
    boolean isTracking = false;
//    Thread 를상소하는 MyThread class 만들기
    class MyTread extends Thread{
//    run을 오버라이딩 // 행동을하는 메서드
        @Override
        public void run() {
            super.run();
            // SeekBar  가 음악재생시  , 움직이게 하기
//            미디어 플레이가 재생중(mp.isPalying)일때 계속 현재 재생중인
//            위치(mp.CurrentPosition)를  pos 라고하고
            while (mp.isPlaying()){  //현재 재생중이라면
               pos = mp.getCurrentPosition();  //현재 재생중인 위치 ms (int)
//                만약 트랙킹이 true 이라면 사용자에 의해서 시크바가 움직이는것이므로
//                 시크바가 위치하게 된곳에 pos인 현재재생중인 위치로 이동시킨다.
              if (!isTracking){
                  sb.setProgress(pos);   // SeekBar 이동 --> onProgressChanged() 호출함
              }
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //앱이 생성되어 실행될때
        // 레이아웃에 담겨있는 아이디들을 찾아서 담아주고
        btnPlay = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);
        btnResume = findViewById(R.id.btnResume);
        btnStop = findViewById(R.id.btnStop);
        sb = findViewById(R.id.sb);

        // 플레이버튼만 보이게끔 설정한다
        btnPlay.setVisibility(View.VISIBLE);
        btnPause.setVisibility(View.INVISIBLE);
        btnResume.setVisibility(View.INVISIBLE);
        btnStop.setVisibility(View.INVISIBLE);





        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            // SB값이 변경 될떄 마다 호출
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //음악이 끝까지 연주 완료 되었다면
                if(seekBar.getMax() == progress &&  !fromUser){
                    //시크바가 사용자의 의해서가 아니며 프로그램에 의해서 끝까지 도달한다면

                    //버튼이 플레이버튼만 보여진다.
                    btnPlay.setVisibility(View.VISIBLE);
                    btnPause.setVisibility(View.INVISIBLE);
                    btnResume.setVisibility(View.INVISIBLE);
                    btnStop.setVisibility(View.INVISIBLE);

                    if (mp != null) mp.stop();
                    //그리고 만약 미디어플레이어가 널이아니라면 스탑해준다

                }

            }

            // 드래그 시작 (트랙킹) 하면 호출
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                isTracking = true;
            }
            // 사용자에 의해서 움직인다


            // 드래그 마치면 (트랙킹 종료) 하면 호출
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                pos = seekBar.getProgress();

                //프로그램의 의해서 움직인다
                //  미디어플레이어가 null이 아니라면 시크바의 위치는 프로그램의 의해서 위치하게된다.
                if (mp != null) mp.seekTo(pos);

                isTracking = false;


            }
        });




        //플레이버튼은 클릭한다면 호출되는 메서드
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // MediaPlayer 객체 초기화, 재생

//               미디어플레이가 생성되어 실행되면 getApplicationContext() 화면에 제어권자가 음악파일을 가져와 틀어준다.
                mp = MediaPlayer.create(
                        getApplicationContext(),  //현재 화면의 제어권자
                        R.raw.chacha );            // 음악 파일 리소스
                mp.setLooping(false);             //true : 무한반복




                // 재생이 끝나면 호출되는 콜백 메서드
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) { //현재 연주 위치                //전체 길이..끝지점
                        Log.d("myapp" ,"연주종료"+ mp.getCurrentPosition()+" / " + mp.getDuration());
                        //재생이 완료되면 플레이 버튼만 활성화 된다.
                        btnPlay.setVisibility(View.VISIBLE);
                        btnPause.setVisibility(View.INVISIBLE);
                        btnResume.setVisibility(View.INVISIBLE);
                        btnStop.setVisibility(View.INVISIBLE);
                    }
                });



                //시작되
                mp.start(); //노래 재생 시작
                int duration = mp.getDuration(); // 음악 재생시간 (ms)

                sb.setMax(duration);// SeekBar 의 범위를 음악의 재생시간으로 설정
                new MyTread().start();// SeekBar 쓰레드 시작


                btnPlay.setVisibility(View.INVISIBLE);
                btnPause.setVisibility(View.VISIBLE);
                btnStop.setVisibility(View.VISIBLE);
            }
        });



        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 음악 종료
                pos = 0;

                if(mp != null){
                    mp.stop(); //재생멈춤
                    mp.seekTo(0);   //음악의 처음으로 이동
                    mp.release();    //자원 해제
                    mp = null;
                }
                sb.setProgress(0);   // SeekBar 도 초기 위치로

                btnPlay.setVisibility(View.VISIBLE);
                btnPause.setVisibility(View.INVISIBLE);
                btnResume.setVisibility(View.INVISIBLE);
                btnStop.setVisibility(View.INVISIBLE);

            }
        });

        // 일시 중지
         btnPause.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 pos = mp.getCurrentPosition(); //현재 재생중이던 위치 저장.

                 mp.pause(); //일시 중지

                 btnPause.setVisibility(View.INVISIBLE);
                 btnResume.setVisibility(View.VISIBLE);

             }
         });

         //멈춘 시점부터 재시작
        btnResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.seekTo(pos);  // 일시 정지시 위치로 이동.
                mp.start(); //재생시작
                new MyTread().start();  //SeekBar 이동 시작 (쓰레드)

                btnResume.setVisibility(View.INVISIBLE);
                btnPause.setVisibility(View.VISIBLE);


            }
        });





    }//end onCreate

    @Override
    protected void onPause() {
        super.onPause();
        if (mp != null){
            mp.release();
        }
        btnPlay.setVisibility(View.VISIBLE);
        btnPause.setVisibility(View.INVISIBLE);
        btnResume.setVisibility(View.INVISIBLE);
        btnStop.setVisibility(View.INVISIBLE);

    }


}//end Activity
