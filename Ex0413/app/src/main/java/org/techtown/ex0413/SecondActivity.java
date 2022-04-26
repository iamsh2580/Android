package org.techtown.ex0413;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    Button btnSecond;
    TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnSecond = findViewById(R.id.btnSecond);
        tvData = findViewById(R.id.tvData);

        //클릭전에 해야해서 위에다?
        //intent 객체생성
        //인텐트에 저장된 객체를 ? 할 수 있다.
        //접근화면에서는 getIntent();

        //intent에 저장된 데이터 접근 시 get타입명Extra(name) 호출
        //기본데이터타입의 데이터 접근 시 defaultValue를 설정해야 한다
        Intent intent = getIntent();
        tvData.setText(intent.getStringExtra("data")+intent.getIntExtra("num",0));

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this,FirstActivity.class) ;
                startActivity(intent);

                //현재 액티비티를 종료하는 메소드
                finish();

            }
        });

    }
}