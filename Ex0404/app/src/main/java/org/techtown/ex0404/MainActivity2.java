package org.techtown.ex0404;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //xml파일을 보여주기 위해 r파일로 접근?

        //TextView를 참조하는 객체를 생성
        //되도록 id이름과 자바변수 이름을 같게 해주는게 좋다
        //view를 초기화 한다(★★★★★)
        //중간에 = 대입연산자 / 저장을 목적으로
        //그래야 초기화가 제대로 되며 사용가능
        //뷰를 제어하기 위해서는 뷰를 초기화하는게 가장 중요하고 첫번재!
        TextView tvData = findViewById(R.id.tvData);

        //TextView의 text 변경
        tvData.setText("가능한~ 텍스트뷰 초기화");

        //TextView의 배경색 변경
        //1.정해진 색상 활용
        //tvDAta.setBackgroundColor(Color.BLUE)
        //2.16진수로 색상 적용
        tvData.setBackgroundColor(Color.parseColor("#ff0000"));

        //TextView의 글자색 변경
        tvData.setTextColor(Color.WHITE);

        //TextVIew의 글자색 변경2
        tvData.setTextColor(Color.parseColor("#ff0000"));

    }
}