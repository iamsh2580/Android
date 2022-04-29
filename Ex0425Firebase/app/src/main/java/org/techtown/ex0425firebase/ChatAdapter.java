package org.techtown.ex0425firebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ChatAdapter extends BaseAdapter {

    Context context;
    int layout;
    ArrayList<ChatVO> list;
    LayoutInflater inflater; //xml->view로 변환★
    String currentId; //현재 로그인 아이디

    public ChatAdapter(Context context, int layout, ArrayList<ChatVO> list, String currentId) {
        this.context = context;
        this.layout = layout;
        this.list = list;
        this.currentId = currentId;
        //inflater 초기화 이걸 초기화해줘야 xml > view로 변환 가능★
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    //list.size를 넣어야 데이터를 갯수만큼 생성해서 보여주기 가능
    public int getCount() {
        return list.size();
    }

    @Override
    //데이터를 담아주니까
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        //i가 하는 역할은 인덱스 위치!
        //view는 아이템 레이아웃을 모두 가진 부모 레이아웃(리스트뷰)
        //로직 구현 시작!

        //1.뷰 초기화
        if(view == null){
            //view는 chat_item.xml의 정보를 가진 객체
            view = inflater.inflate(layout,viewGroup,false);
        }
        ImageView imgOther = view.findViewById(R.id.imgOther);
        TextView tvOtherNm = view.findViewById(R.id.tvOtherNm);
        TextView tvOtherMsg = view.findViewById(R.id.tvOtherMsg);
        TextView tvOtherTime = view.findViewById(R.id.tvOtherTime);
        TextView tvMyMsg = view.findViewById(R.id.tvMyMsg);
        TextView tvMyTime = view.findViewById(R.id.tvMyTime);

        //
        ChatVO vo = list.get(position);

        //현재 로그인한 아이디 판단 , 그것에 따라 view의 가기성을 성정
        //상대방 아이디인 경우, 왼쪽 view만 보여지도록 설정(imgOther,tvOtherNm,tvOtherMsg,tvOtherTime)
        //자신의 아이디인 경우: 오른쪽 view만 보여지도록 설정(tvMyMsg,tvMytime)

        if(list.get(position).getName().equals(currentId)){
            imgOther.setVisibility(View.INVISIBLE);
            tvOtherNm.setVisibility(View.INVISIBLE);
            tvOtherMsg.setVisibility(View.INVISIBLE);
            tvOtherTime.setVisibility(View.INVISIBLE);

            tvMyMsg.setText(vo.getMsg());
            tvMyTime.setText(vo.getTime());
        }else{

            imgOther.setVisibility(View.VISIBLE);
            tvOtherNm.setVisibility(View.VISIBLE);
            tvOtherMsg.setVisibility(View.VISIBLE);
            tvOtherTime.setVisibility(View.VISIBLE);

            tvMyMsg.setVisibility(View.INVISIBLE);
            tvMyTime.setVisibility(View.INVISIBLE);

            imgOther.setImageResource(vo.getImgId());
            tvOtherNm.setText(vo.getName());
            tvOtherMsg.setText(vo.getMsg());
            tvOtherTime.setText(vo.getTime());

        }


        imgOther.setImageResource(vo.getImgId());
        tvOtherNm.setText(vo.getName());
        tvOtherMsg.setText(vo.getMsg());
        tvMyTime.setText(vo.getTime());

        tvMyMsg.setText(vo.getMsg());
        tvMyTime.setText(vo.getTime());


        return view;
    }


    }




