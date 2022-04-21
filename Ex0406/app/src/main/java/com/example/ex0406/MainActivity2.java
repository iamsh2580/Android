package com.example.ex0406;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{

    ConstraintLayout layout2;
    Button btnrChange, btngChange, btnbChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //View 초기화
        layout2 = findViewById(R.id.layout2);

        btnrChange = findViewById(R.id.btnrChange);
        btngChange = findViewById(R.id.btngChange);
        btnbChange = findViewById(R.id.btnbChange);

        //각 버튼에 onClick() 연결
        //this는 메인을 가리킨다 > onclick과 연결지어 동작
        btnrChange.setOnClickListener(this);
        btngChange.setOnClickListener(this);
        btnbChange.setOnClickListener(this);
    }


    @Override
    public void onClick(View view){

        //이벤트가 발생한 View의 id값을 변수에 저장
        int viewId = view.getId();

        if(viewId == R.id.btnrChange){
            layout2.setBackgroundColor(Color.RED);
        }else if(viewId == R.id.btngChange){ //"배경색변경" 버튼인 경우
            layout2.setBackgroundColor(Color.GREEN);
        }else{
            layout2.setBackgroundColor(Color.BLUE);
        }
    }
}