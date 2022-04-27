package org.techtown.ex0414;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import org.techtown.ex0414.ProductAdapter;
import org.techtown.ex0414.ProductVO;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {
    ListView lv_product;
    ProductAdapter adapter;
    ArrayList<ProductVO> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_item);

        lv_product = findViewById(R.id.lv_product);
        list = new ArrayList<ProductVO>();
        //리스트 ID를 동적으로 접근하는 방법
        for(int i =0; i<11; i++){
            //리소스객체접근.리소스ID반환메소드(리소스ID, 리소스타입, 패키지명)
            int imgId = getResources().getIdentifier("item"+(i+1), "drawable",getPackageName());
            int strId = getResources().getIdentifier("item"+(i+1), "string",getPackageName());
            list.add(new ProductVO(imgId,strId,"10"));

        }

        adapter = new ProductAdapter(
                ProductActivity.this,
                R.layout.product_item,
                list);
        lv_product.setAdapter(adapter);

    }
}