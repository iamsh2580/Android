package org.techtown.ex0407;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button button,button2;
    TextView num;
    int count =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        num= findViewById(R.id.num);
        num.setText(count+"");
        button =findViewById(R.id.button);
        button2 =findViewById(R.id.button2);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        int viewId=view.getId();



        if(viewId==R.id.button){
            count++;
            num.setText(count+"");
        }else{
            if( count<=0){
                count=0;
            }else{
                count--;
            }

            num.setText(String.valueOf(count));
        }
    }
}