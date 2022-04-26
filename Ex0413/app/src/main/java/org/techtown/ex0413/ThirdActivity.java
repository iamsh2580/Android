package org.techtown.ex0413;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity {


    EditText edtMsg;
    Button btnThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        edtMsg = findViewById(R.id.edtMsg);
        btnThird = findViewById(R.id.btnThird);

        btnThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String msg = edtMsg.getText().toString();

                Intent intent  = new Intent();
                intent.putExtra("msg",msg);

                //setResult():Intent객체를 액티비티 결과값으로 안드로이드 시스템에 저장(설정?)
                //RESULT_OK: 정상적으로 처리했을 때의 결과코드 (많이 쓸것같네요)
                //RESULT_CANCELED:비정상적으로 처리햇을 때의 결과 코드
                setResult(RESULT_OK,intent);

                //이거 수업 다시 들어라 11시 수업
                finish();
            }
        });
    }
}