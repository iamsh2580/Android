package org.techtown.ex0407;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity3 extends AppCompatActivity {


    ImageView imageView;
    Button btnChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        imageView = findViewById(R.id.imageView);
        btnChange = findViewById(R.id.btnChange);

        //익명 클래스 방식의 이벤트 처리
        //버튼의 독립적인 기능을 구현할 때
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imageView.setVisibility(View.INVISIBLE);

            }
        });


    }
}