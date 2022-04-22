package org.techtown.ex0407;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity4 extends AppCompatActivity {

    ImageView img;
    Button btnPre,btnNext;
    int cnt=0;

    //이미지 배열 생성
    int[] imgArr ={R.drawable.sujin1,R.drawable.sujin2,R.drawable.sujin3};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        img = findViewById(R.id.img);
        img.setImageResource(imgArr[1]);
        btnPre=findViewById(R.id.btnPre);
        btnNext=findViewById(R.id.btnNext);

        //이전!!!
        btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                --cnt;
                if(cnt==-1){
                    img.setImageResource(imgArr[0]);

                }else if(cnt==-2){
                    img.setImageResource(imgArr[2]);

                }else{
                    img.setImageResource(imgArr[1]);
                    cnt=0;
                }

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cnt++;
                if(cnt==1){
                    img.setImageResource(imgArr[2]);
                }else if(cnt==2){
                    img.setImageResource(imgArr[0]);
                }else{
                    img.setImageResource(imgArr[1]);
                    cnt=0;
                }





            }
        });


    }



}