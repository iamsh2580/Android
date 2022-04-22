package org.techtown.ex0407;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity6 extends AppCompatActivity {

    Button shake;
    ImageView dice1,dice2;

    TextView num1,num2;
    int a,b;
    int rdnum1,rdnum2;

    int[] imgArr ={R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        shake = findViewById(R.id.shake);
        dice1=findViewById(R.id.dice1);
        dice2 = findViewById(R.id.dice2);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);

        shake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random random = new Random();

                rdnum1 = random.nextInt(6)+1;
                rdnum2 = random.nextInt(6)+1;

                num1.setText(String.valueOf(rdnum1));
                num2.setText(String.valueOf(rdnum2));

                dice1.setImageResource(imgArr[(rdnum1)-1]);
                dice2.setImageResource(imgArr[(rdnum2)-1]);




            }
        });







    }





}