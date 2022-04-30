package org.techtown.ex0428_thread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    TextView tvNumber;
    Button btnStart;

    TextView tvNumber2;
    Button btnStart2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNumber = findViewById(R.id.tvNumber);
        btnStart = findViewById(R.id.btnStart);

        tvNumber2 = findViewById(R.id.tvNumber2);
        btnStart2 = findViewById(R.id.btnStart2);

        //3 Thread 객체 생성




        //실행시키는 메소드 start
        //thread.start();


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimerThread thread = new TimerThread(tvNumber);
                thread.start();
                btnStart.setEnabled(false);

            }
        });

        btnStart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimerThread thread2 = new TimerThread(tvNumber2);
                thread2.start();
                btnStart2.setEnabled(false);
            }
        });



    }

    //Thread(스레드)
    //하나의 프로세스 내에서 작업을 처리하는 작은 단위
    //Main Thread 이외의 작업을 별도로 처리할 때 활용

    //Main Thread의 역할
    //안드로이드 앱은 실행시 화면이 뜨고~ 등
    //UI를 업데이트 하는 역할

    //2
    class TimerThread extends Thread{ //스레드 상속
        //run을 오버라이드

        //8.핸들러 설정?
        TimerHandler handler = new TimerHandler();
        TextView tv;

        public TimerThread(TextView tv){
            this.tv = tv;
        }


        public  void  run(){

            //실행할 로직 정의
            //버튼 눌렀을 때 자동 카운트 기능
            //
            for(int i =0;i<10;i++){
                Log.d("TimerThread","카운트"+(i+1));

                //5.id변수 넣어주면 여기 값이 들어가는 상태
                //tvNumber.setText(String.valueOf(i+1));

                //7.Handler의 값을 전달해줘야한다 -> Message객체를 전달
                Message msg = new Message();
                msg.arg1 = i+1;
                msg.obj = tv;
                //TextView -> Object로 업캐스팅되서 저장
                //message객체 전송
                handler.sendMessage(msg);
                //값을 어떤 변수에 담아줬는냐 기억!


                //4. 1초
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }//end class

    //핸들러 만들기
    class TimerHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            //틀 만들기 끝!
            //sub Thread에서 처리한 결과를  UI에서 업데이트 할 때
            //HandlerMessage()안에 정의하면 된다.
            int count = msg.arg1;
            TextView tv= (TextView) msg.obj; // obj타입으로 저장된 textview객체를 다운캐스팅


            //tvNumber.setText(String.valueOf(count)); //정수니까 바로 넣으면 x > String.valueof()
            //timerThread 객체생성 시 넘겨받은 TextView 객체에 내용을 업데이트
            tv.setText(String.valueOf(count));
        }
    }



    //
    class TimerThread2 extends Thread{ //스레드 상속
        //run을 오버라이드

        //8.핸들러 설정?
        TimerHandler2 handler = new TimerHandler2();


        public  void  run(){

            //실행할 로직 정의
            //버튼 눌렀을 때 자동 카운트 기능
            //
            for(int i =0;i<10;i++){
                Log.d("TimerThread","카운트"+(i+1));

                //5.id변수 넣어주면 여기 값이 들어가는 상태
                //tvNumber.setText(String.valueOf(i+1));

                //7.Handler의 값을 전달해줘야한다 -> Message객체를 전달
                Message msg = new Message();
                msg.arg1 = i+1;
                //message객체 전송
                handler.sendMessage(msg);
                //값을 어떤 변수에 담아줬는냐 기억!


                //4. 1초
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }//end class

    //핸들러 만들기
    class TimerHandler2 extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            //틀 만들기 끝!
            //sub Thread에서 처리한 결과를  UI에서 업데이트 할 때
            //HandlerMessage()안에 정의하면 된다.
            int count = msg.arg1;
            tvNumber2.setText(String.valueOf(count)); //정수니까 바로 넣으면 x > String.valueof()
        }
    }
    //


}