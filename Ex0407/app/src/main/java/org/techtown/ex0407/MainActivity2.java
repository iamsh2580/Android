package org.techtown.ex0407;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener{

    Button add,minus,mul,div;
    TextView result;
    EditText text11,text22;
    String a,b;
    Integer result2;
    float result3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initView();

        add.setOnClickListener(this);
        minus.setOnClickListener(this);
        mul.setOnClickListener(this);
        div.setOnClickListener(this);



    }

    private void  initView() {
        result = findViewById(R.id.result);
        text11=findViewById(R.id.text11);
        text22=findViewById(R.id.text22);

        add=findViewById(R.id.add);
        minus=findViewById(R.id.minus);
        mul=findViewById(R.id.mul);
        div=findViewById(R.id.div);
    }

    @Override
    public void onClick(View view) {


        int viewId = view.getId();
        a=text11.getText().toString();
        b=text22.getText().toString();

        if(viewId ==R.id.add){

            result2=Integer.parseInt(a)+Integer.parseInt(b);
            result.setText("결과 : "+ result2);

        }else if(viewId==R.id.minus){

            result2=Integer.parseInt(a)-Integer.parseInt(b);
            result.setText("결과 : "+ result2);
        }else if(viewId==R.id.mul){

            result2=Integer.parseInt(a)*Integer.parseInt(b);
            result.setText("결과 : "+ result2);
        }else if(viewId==R.id.div){

            result3=Integer.parseInt(a)/(float)Integer.parseInt(b);
            result.setText("결과 : "+ result3);
        }

    }
}