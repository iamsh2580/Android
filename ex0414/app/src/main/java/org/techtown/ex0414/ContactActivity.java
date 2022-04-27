package org.techtown.ex0414;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {

    ListView lvContact; //데이터 뿌려주는 뷰
    ContactAdapter adapter; //우리가 만든
    ArrayList<ContactVO> list; //넘겨줄 데이터 set 정의


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        lvContact = findViewById(R.id.lvContact);
        list = new ArrayList<ContactVO>();

        for(int i = 0;i<20;i++){
            list.add(new ContactVO(R.drawable.ic_launcher_background,
                    "스인재"+(i+1),"010-2222-2222"));
        }

        adapter = new ContactAdapter(ContactActivity.this,
                R.layout.list_item,
                list);

        lvContact.setAdapter(adapter);
    }
}