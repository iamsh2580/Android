package org.techtown.ex0414;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {

    Context context;
    int item_layout;
    ArrayList<ProductVO> list;
    LayoutInflater inflater;

//생성자 (정보 초기화 위해)
    public ProductAdapter(Context context, int item_layout, ArrayList<ProductVO> list) {
        this.context = context;
        this.item_layout = item_layout;
        this.list = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {


        ProViewHolder holder = null;

        //1. List.item,xml -> view객체로 변환

        //초기화 작업
        if (view == null) {
            view = inflater.inflate(item_layout, viewGroup, false);


            //아이템 뷰에 배치된 view객체들을 한 번 초기화
            holder = new ProViewHolder(view);
            //초기화된 holfer객체를 view객체에 저장
            view.setTag(holder);
        } else {
            //view객체에 저장된 holder객체를 가져와 저장
            holder = (ProViewHolder) view.getTag();
        }
        //반드시 객체 넣어야험
        //view는 아이템에대한 객체를 가짐

        //ProductVO vo = (ProductVO)getItem(i);
        ProductVO vo = list.get(i);

        holder.getImgPro().setImageResource(vo.getImg());
        holder.getTvProName().setText(vo.getPro_name());
        holder.getTvProCount().setText(vo.getPro_count());

        holder.getBtnProDetail().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //대화상자: Alertdialog
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setTitle("상품보기")
                        .setMessage("상품개수")
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //ㄷ오작

                            }
                        })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });


        return  view;
    }
}
