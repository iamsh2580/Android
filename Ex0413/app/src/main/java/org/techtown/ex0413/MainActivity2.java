package org.techtown.ex0413;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    Button btnWeb, btnCamera, btnDial, btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        /*1. 버튼객체 파인드 뷰로 초기화*/
        btnWeb = findViewById(R.id.btnWeb);
        btnCamera = findViewById(R.id.btnCamera);
        btnDial = findViewById(R.id.btnDial);
        btnCall = findViewById(R.id.btnCall);

        //익명 클래스
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1.intent 객체생성
                //암시적 인텐트 방식 > action이 반드시 정의되어야 함
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/search?q=한수진"));
                //2.액티비티 인스턴스 시작
                startActivity(intent);
            }
        });

        //카메라
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });

        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:01011111111"));
                startActivity(intent);
            }
        });

        //바로 전화를 걸어줍니다.
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:01011111111"));


                //녹음, 전화걸기, 주소록접근, 위치정보접근 등 사용자의 민감한 기능이나 데이터를
                //사용해야 하는 경우는 아래와 같이 권한을 체크하고 요청하는 로직을 정의해줘야함

                //액티비티에서 실행하는 경우 -> 권한체크
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    //권한요청
                    ActivityCompat.requestPermissions(
                            MainActivity2.this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            0);

                    return;
                }

                startActivity(intent);
            }
        });
    }
}