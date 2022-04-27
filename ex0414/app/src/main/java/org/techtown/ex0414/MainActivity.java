package org.techtown.ex0414;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter adapter;
    ArrayList<String> list;

    Button btnRegister;
    EditText edtData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        list = new ArrayList<String>();
        edtData = findViewById(R.id.edtData);
        btnRegister = findViewById(R.id.btnRegister);

        list.add("떡복이");
        list.add("해물탕");
        list.add("간장찜닭");
        list.add("김치찜");
        list.add("닭볶음탕");
        list.add("부대찌개");
        list.add("계란후라이");
        list.add("버팔로윙");
        list.add("딸기생크림케이크");
        list.add("김치리조또");
        list.add("쫄병스넥");
        list.add("초밥");
        list.add("연어덮밥");
        list.add("콜라");
        list.add("사이다");
        list.add("환타");
        list.add("치즈스틱");
        list.add("치즈볼");


        //new ArrayAdapter(현재 액티비티명.this,레이아윳,데이터);
        //레이아웃: 리스트뷰에 보여질 아이템 뷰
        //데이터: 아이템뷰에 출력할 데이터
        adapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                list
        );

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int i, long l) {

                String data = list.get(i);
                Toast.makeText(MainActivity.this,
                        "선택한 항복: " + data,
                        Toast.LENGTH_SHORT).show();
            }
        });

        //롱클릭시 아이디를 삭제하는 기능 구현
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                                          @Override
                                          public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                                              Toast.makeText(MainActivity.this,"롱클릭!",Toast.LENGTH_LONG);

                                              String food = list.get(i);
                                              adapter.remove(food);
                                              return false;
                                          }
                                      });

                //버튼을 클릭했을 때 ListView에 데이터 저장
                btnRegister.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String food = edtData.getText().toString();
                        list.add(food);

                    }
                });

    }
}


