package org.techtown.ex0413;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    String tag="액티비티 생명주기";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(tag,"onCreate() 호출!");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(tag,"onStart() 호출!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag,"onResume() 호출!");


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag,"onPause() 호출!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag,"onStop() 호출!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag,"onDestroy() 호출!");
    }




}