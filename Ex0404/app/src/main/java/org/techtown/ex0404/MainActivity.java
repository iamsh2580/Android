package org.techtown.ex0404;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //onCreate:화면을 생성해준다 어떤것을? 밑의 setContentView를!
        //이 안에 기능적인것을 구현해나간다.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //oncreate에 의해 실행될때 여기있는 layout(화면)중 activitymain을 띄우겠다
        //위 메소드를 통해 화면이 떠진다


    }
}