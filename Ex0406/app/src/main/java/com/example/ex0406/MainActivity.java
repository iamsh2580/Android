package com.example.ex0406;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//인터페이스 구현을 통해 이벤트 적용
// : 유사한 기능을 구현할 때 사용하면 된다
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
//    인터페이스는 다 추상메서드로 만들어져있어 구현을 해야한다 무조건! > 그래서 위에 빨간줄

    //onClick()메소드에서 두 객체변수를 사용하기 위해 전역변수로 선언
    TextView tvMsg;
    EditText editText;
    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //*setContentView()로 UI화면이 생성된 이후에
        //findViewById() 메소드를 사용하여 View의 id값을 참조할 수 있다
        tvMsg = findViewById(R.id.tvMsg);
        editText = findViewById(R.id.edtMsg);
        layout = findViewById(R.id.layout);
        Button btnChange = findViewById(R.id.btnChange);
        Button btnBgChange = findViewById(R.id.btnBgChange);

        //TextView의 text값 접근 -> Log.d()를 활용하여 출력
        //출력결과: Logcat 창 or Run창
        //Log 활용: 결과값 확인, 서버통신 데이터 확인
        Log.d("MainActivity_tvMsg", tvMsg.getText().toString());

        //onClick()가 동작되도록 Button 객체에 이벤트 설정
        //this: OnclickListener를 구현한 MainActivity를 가리킴
        btnChange.setOnClickListener(this);
        btnBgChange.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){

        //이벤트가 발생한 View의 id값을 변수에 저장
        int viewId = view.getId();

        //클릭이벤트 발생 시 동작할 로직 구현
        Log.d("MainActivity_event", "클릭이벤트발생!");

        if(viewId == R.id.btnChange){ //"텍스트변경" 버튼인 경우
            //EditText에 입력된 내용을 TextView에 설정
            //1. EditText에 입력된 텍스트 가져오기
            String msg = editText.getText().toString();

            //2. TextView에 설정
            tvMsg.setText(msg);
        }else{ //"배경색변경" 버튼인 경우

            layout.setBackgroundColor(Color.parseColor("#55ff0000"));

            
        }


    }
}
