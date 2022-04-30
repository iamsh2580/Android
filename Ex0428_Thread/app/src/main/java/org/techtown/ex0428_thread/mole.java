package org.techtown.ex0428_thread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

//남은 시간 카운트 기능을 구현하시오(Thread,Handler활용)


//31.메뉴를 구성해놓고 화면만 전환하는 Fragment기법


public class mole extends AppCompatActivity {

    ImageView[] moreArr = new ImageView[9];
    TextView tvTime, tvCount;
    int score;
    boolean isPlaying = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moal);

        tvTime = findViewById(R.id.tvTime);
        tvCount = findViewById(R.id.tvCount);


        //////////////////////시간
        mole.TimerThread2 thread2 = new mole.TimerThread2();
        thread2.start();
        //btnStart2.setEnabled(false);
        //////////////////////시간


        //동적으로 리소스 아이디 접근 후, imageView 초기화
        for (int i = 0; i < moreArr.length; i++) {

            //25.포스라는 상수를 새롭게 선언
            final int pos = i;

            //getPackageName:해당 이름에대한 값을 불러올 수 있음(정수타입)
            //img1~img9까지의 리소스id접근
            int resId = getResources().getIdentifier("img" + (i + 1), "id", getPackageName());
            moreArr[i] = findViewById(resId);

            //23
            //imageView에 tag설정
            //tag:View에 대한 상태값 저장
            //모든 뷰들은 태그라는 값을 정의할 수 있다. 태그에 상태값을 정해두면 어떤 상태인가 정의 가능
            moreArr[i].setTag("down");

            //11.
            MoreMoveThread thread = new MoreMoveThread(i);
            thread.start();

            //22.두더지( ImageView)를 클릭했을 때 이벤트 구현
            //imgview는 moreArr에 들어있다.
            moreArr[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(mole.this, "잡았다 홍성채 요놈!", Toast.LENGTH_SHORT).show();

                    //24.익명 클래스 방식으로 이벤트 구현 > 즉, 클래스나 마찬가지
                    //이 익명클래스에서 i=10으로 바꾸면 문제가 생기니까
                    //이런 부분을 방지하고자 일반 변수는 접근할 수 없다 따라서 i는 오류 > 상수 정의가 필요
                    String status = moreArr[pos].getTag().toString();

                    //26.두더지의 상태체크 ->잡은 개수를 업데이트(증/감)
                    //카운트 기능을 구현하시오
                    //쌤 답) int count = Integer.parseInt(tvCount.getText().toString());
                    if (status.equals("up")) {
                        tvCount.setText(String.valueOf(score++));
                        //count+=1;
                    } else {
                        if (score > 0) {
                            tvCount.setText(String.valueOf(score--));
                            //count-=1;
                        }
                    }
                    //tvCount.setText(String.valueOf(count));
                }
            });

        }


    }//end

    //1.thread 만들기 : 두더지를 움직이게 하는 thread
    class MoreMoveThread extends Thread {

        //7.핸들러 정의
        MoreMoveHandler handler = new MoreMoveHandler();
        int more_pos;

        public MoreMoveThread(int more_pos) {
            this.more_pos = more_pos;
        }

        //2.run메소드 호출:thread 상속받기위한 필수 메소드
        @Override
        public void run() {

            //두더지가 위,아래 머물러 있는 시간을 랜덤으로 생성
            //random객체 활용
            Random ran = new Random();

            while (isPlaying) {
                int downTime = ran.nextInt(1500) + 500;
                int upTime = ran.nextInt(1500) + 500;

                //20.아래 머물러 있는 시간
                try {
                    Thread.sleep(downTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //두더지를 움직이는 로직을 구현하자!

                //4.message객체 생성
                //저장해야할 데이터: 두더지 번호,변경할 두더지 이미지, 두더지 상태
                Message msg = new Message();
                //5.1번째 두더지를 넣어준다
                msg.arg1 = more_pos;
                //6.이미지 값을 넣어준다
                msg.arg2 = R.drawable.upsc;
                msg.obj = "up";

                //8.
                handler.sendMessage(msg);

                /////////////////////////////////////////22.여길 while로 묶으면 계속 움직임
                //21.위에 머물러 있는 시간
                try {
                    Thread.sleep(upTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //15.이미지랑 상태가 바껴야한다.
                msg = new Message();
                msg.arg1 = more_pos;
                msg.arg2 = R.drawable.downsc;
                msg.obj = "down";

                handler.sendMessage(msg);
/////////////////////////////////////////////////////////
            }//end while
        }
    }//end

    //3.핸들러 정의(handleMessage까지만)
    class MoreMoveHandler extends Handler {

        //21.생성자
        //t생성을 할 때, 몇 번재 두더지 번호인지 알면 그 두더지에 대한 움직임을 줄 수 있다.
        @Override
        public void handleMessage(@NonNull Message msg) {
            //두더지가 움직이게 반영하는것?
            //9
            int pos = msg.arg1; //두더지 번호 >
            int img = msg.arg2;
            String status = (String) msg.obj;

            //10.반영 시켜준다
            //이미지를 바꿔주는 setImageResource메소드
            moreArr[pos].setImageResource(img);
            moreArr[pos].setTag(status); //up down상태값 저장
        }
    }


    /////////////////////////////////시간초 만들기 시작
    class TimerThread2 extends Thread { //스레드 상속
        //run을 오버라이드

        //8.핸들러 설정?
        mole.TimerHandler2 handler = new mole.TimerHandler2();

        public void run() {
            //실행할 로직 정의
            //버튼 눌렀을 때 자동 카운트 기능
            //
            for (int i = 30; i >= 0; i--) {
                //Log.d("TimerThread","카운트"+(i+1));
                //5.id변수 넣어주면 여기 값이 들어가는 상태
                //tvNumber.setText(String.valueOf(i+1));
                //7.Handler의 값을 전달해줘야한다 -> Message객체를 전달
                Message msg = new Message();
                msg.arg1 = i;
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
    class TimerHandler2 extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            //틀 만들기 끝!
            //sub Thread에서 처리한 결과를  UI에서 업데이트 할 때
            //HandlerMessage()안에 정의하면 된다.
            int timeCount = msg.arg1;
            tvTime.setText(String.valueOf(timeCount)); //정수니까 바로 넣으면 x > String.valueof()

            //0초가 되었을 때 두더지 움직임 정지
            if(timeCount==0){
                isPlaying=false;
            }
        }
    }
    ////////////////////////////시간초 만들기 끝


}