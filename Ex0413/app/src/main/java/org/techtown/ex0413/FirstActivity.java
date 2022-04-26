package org.techtown.ex0413;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class FirstActivity extends AppCompatActivity {

    Button btnFirst,btnFirst2,btnCapture;
    EditText adtData;


    //액티비티 결과 수신에 대한 기능 구현
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    //화면 전환했던 액티비티로부터 데이터를 받아온 후 실행할 로직을 구현
                    //데이터는 result객체로부터 꺼내올 수 있음

                    //result.getResultCode() : 결과코드를 반환하는 메서드 > result_ok or result_cancled
                    //result.getData() : Intent()에 저장된 데이터를 반환하는 메서드
                    if(result.getResultCode()==RESULT_OK){//정상적으로 처리가 된 상황
                        Intent intent = result.getData(); //getintent()와 같은 역할입니다

                        Log.d("FirstActivity",intent.getStringExtra("msg"));

                    }
                }

            }
    );

    ActivityResultLauncher<Intent> lancher_capture = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    //어떤 이벤트에서 되돌아오는지 없다

                    if(result.getResultCode() == RESULT_OK){
                        //bundle은 key.value로 되어있는 구조
                        Bundle bundle = result.getData().getExtras();

                        //사진을 찍었을 때 안드로이드 내부에 bundle공간에 저장
                        //"data"라는 이름으로 bitmap타입의 사진데이터가 저장됨
                        //get()은 Object로 변환해주기 때문에 bitmap타입으로 다운캐스팅팅
                       Bitmap bitmap = (Bitmap)bundle.get("data");

                        ImageView img = findViewById(R.id.imageView);
                        img.setImageBitmap(bitmap);

                    }
                }
            }

    );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        btnFirst = findViewById(R.id.btnFirst);
        btnFirst2 = findViewById(R.id.btnFirst2);
        adtData= findViewById(R.id.edtData);
        btnCapture=findViewById(R.id.btnCapture);

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String data = adtData.getText().toString();

                //secondActivity로 이동하는 기능 구현
                //왜?!
                //Intent(현재 액티비티명.this ,화면 전환할 액티비티명.class)
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);

                //intent객체에 전달할 데이터 저장
                intent.putExtra("data",data);
                intent.putExtra("num",10);


                //intent객체를 실행시키는 메소드
                startActivity(intent);
            }
        });

        btnFirst2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FirstActivity.this,ThirdActivity.class);

                //ThirdActivity를 실행한 후 결과에 대한 처리는
                //onActivityResult()에서 수신할 수 있도록 실행하는 메소드드
               launcher.launch(intent);

            }
        });

        btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //mediastore을 이용해서 카메라를 띄워보겟습니다
                //실행해줄 객체를 먼저 해야겟죠(위로!)

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                lancher_capture.launch(intent);


            }
        });


    }
}