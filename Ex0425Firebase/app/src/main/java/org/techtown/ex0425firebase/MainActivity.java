package org.techtown.ex0425firebase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Person;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Write a message to the database
        //fd쓰기 위해서 객체 정보가 필요해 객체 정보 받아오는 로직
        //Connection conn = DriverManager.getConnection();
        //파이어베이스 데이터베이스 객체 생성
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        //데이터베이스 내 데이터를 참조하는 객체
        //해당 참조경로가 없는 경우 =->새롭게 생성
        //참조경로가 있을 경우 =-> 데이터를 참조(접근?)
        DatabaseReference myRef = database.getReference("message");



        //이 객체에서
        //myRef.setValue("Hello, World!"); 문자열 저장
        //3번
        myRef.setValue(new PersonVO("홍0동",25,true));

        //4번
        //랜덤키를 생성하여 데이터를 저장
        myRef.push().setValue(new PersonVO("홍0동",25,true));

        //5번
        //메시지 경로 안에 여러 개의 데이터를 읽어와야 할 경우
        //채팅앱도 valueDataListener가 아니라
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                PersonVO value = snapshot.getValue(PersonVO.class);

                Log.d(TAG,"Value is "+value);
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






        // 읽어오는 법
        //데이터베이스 내 변경사항이 발생했을 떄 (이벤트)
        //2번
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            //dataSnapshot:데이터가 저장됐을때 형태를 마치 스냅샷처럼 찍는다
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                //getvalue라는 메소드에 어떤 형태의 ?메소드?를 저장 할것인가
                //getValue(클래스 타입 정의) -> 클래스 타입에 맞춰 데이터를 읽어오는 메소드
                //String value = dataSnapshot.getValue(String.class);
                //객체 데이터를 읽어올 떄
                PersonVO value = dataSnapshot.getValue(PersonVO.class);

                //string으로 읽어오겠다 해서.. 실제 저장되는 홍0동은 personvo타입임
                //저장했던 타입 그대로 읽어와야 저장 가능
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });



    }




}