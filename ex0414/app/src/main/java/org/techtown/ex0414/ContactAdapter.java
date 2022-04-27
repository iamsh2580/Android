package org.techtown.ex0414;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

//어댑터의 역할
//alt +enter 추상메소드를 구현해야 하거나 import할때 사용하는 단축 키
//어댑터의 역할
// - 리스트뷰에 보여질 아이템뷰를 생성해주는 역할
//생성을 할 때, 아이템뷰와 데이터를 묶어서 view객체로 생성
public class ContactAdapter extends BaseAdapter {

    Context context;
    int layout;
    ArrayList<ContactVO> list;
    LayoutInflater inflater; //xml파일 --> view객체로 변환해주는 객체

    //생성자
    public ContactAdapter(Context context, int layout, ArrayList<ContactVO> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
        //컨트롤 스페이스
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

    //아이템뷰와 데이터를 바인딩해주는 메소드

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder = null;

        //1. List.item,xml -> view객체로 변환

        if(view == null) {
            view = inflater.inflate(layout, viewGroup, false);

            //아이템 뷰에 배치된 view객체들을 한 번 초기화
            holder = new ViewHolder(view);
            //초기화된 holfer객체를 view객체에 저장
            view.setTag(holder);
        }else{
            //view객체에 저장된 holder객체를 가져와 저장
            holder = (ViewHolder) view.getTag();
        }

        //2.List.item.xml 안에 있는 imageview,textview,button을 초기화
//        ImageView imageView = view.findViewById(R.id.imageView);
//        TextView tvName = view.findViewById(R.id.tvName);
//        TextView tvPhone = view.findViewById(R.id.tvPhone);
//        ImageButton btnCall = view.findViewById(R.id.btnCall);

        //3.생성된 View객체를 활용
        ContactVO vo = (ContactVO)getItem(i);
        holder.getImageView().setImageResource(vo.getImg());
        holder.getTvName().setText(vo.getName());
        holder.getTvPhone().setText(vo.getPhone());

        holder.getBtnCall().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //context->ContactActivity를 가리키는 객체
                Toast.makeText(context,vo.getPhone(),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context,MainActivity.class);
                //start는 뷰라는 클래스를 상속받았을때만 가능
                //adapter은 일반 클래스라서 스타트 못씀

                //contactAdapter은 액티비티가 아닌 일반클래스이기 때문에
                //액티비티에서만 사용할 수 있는 메소드를 통해서 사용 가능!
                //사용하려면 액티비티정보를 가진 context객체를 통해서 사용 가ㅓㄴㅇㅇ
               context.startActivity(intent);

            }
        });


        //내용이 데이터 갯수만큼 찎어지기때문에
        //4.생성된 layout view객체를 리턴 --> listview에 출력
        return view;//★★★★★
    }
}
