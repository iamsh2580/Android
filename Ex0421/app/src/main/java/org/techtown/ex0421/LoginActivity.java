package org.techtown.ex0421;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    //설정
    EditText edtId,edtPw;
    Button loginBtn,joinBtn;

    //통신 위해서
    RequestQueue queue;
    StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //초기화
        edtId = findViewById(R.id.edtId);
        edtPw = findViewById(R.id.edtPw);
        loginBtn = findViewById(R.id.loginBtn);
        joinBtn =findViewById(R.id.joinBtn);


        queue = Volley.newRequestQueue(LoginActivity.this);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int method = Request.Method.POST;
                String server_url = "http://222.102.104.180:8081/android/Login";

                request = new StringRequest(
                        method,
                        server_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(LoginActivity.this,"로그인성공>>"+response,
                                        Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(LoginActivity.this,"로그인실패>>"+error.toString(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                ){
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        //key와 value형태로 데이터를 저장하는 자료 구조 --> map
                        Map<String, String> param = new HashMap<>();
                        param.put("id",edtId.getText().toString());
                        param.put("pw",edtPw.getText().toString());

                        return param;
                    }
                };
                queue.add(request);
            }
        });
        //클릭 이벤트
        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //화면 이동
                Intent intent = new Intent(LoginActivity.this,JoinActivity.class);
                startActivity(intent);
            }
        });


    }
}