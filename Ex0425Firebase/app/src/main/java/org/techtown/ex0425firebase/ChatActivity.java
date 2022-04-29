package org.techtown.ex0425firebase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;

public class ChatActivity extends AppCompatActivity {

    ListView ChatList;
    ChatAdapter adapter;
    ArrayList<ChatVO> list;

    EditText edtMsg;
    Button btnSend;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);


        ChatList = findViewById(R.id.ChatList);
        edtMsg = findViewById(R.id.edtMsg);
        btnSend = findViewById(R.id.btnSend);
        list = new ArrayList<>();

        String currentId = getIntent().getStringExtra("login_id");
        Log.d("CharActivity","현재 로그인한 아이디 : "+currentId);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef  = database.getReference("talk");

        //1.버튼 클릭 시 입력된 메세지를 파이어베이스 데이터베이스에 저장
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //현재 시간 구하기(스마트폰시간)
                //SimpleDateFormat -> java.uitl 패키지 선택해야 합니다~ 감사합니다..ㅠ
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                String time = sdf.format(cal.getTime());


                String msg = edtMsg.getText().toString();

                //저장시 채워넣는 push
                myRef.push().setValue(new ChatVO(R.drawable.ic_launcher_background,
                        currentId,
                        msg,
                        time));
            }
        });


        //2. 파이어베이스 데이터베이스에 저장된 데이터를 가져온 후 list객체에 저장
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                //읽어올때는 자료형 맞춰서
                ChatVO vo = snapshot.getValue(ChatVO.class);
                //객체를 어디에 저장할까요? list!
                list.add(vo);
                //갱신 시켜주는 작업
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        ChatList = findViewById(R.id.ChatList);
        list = new ArrayList<>();

        adapter = new ChatAdapter(ChatActivity.this,
                R.layout.chat_item,
                list,
                currentId);

        ChatList.setAdapter(adapter);
    }
}