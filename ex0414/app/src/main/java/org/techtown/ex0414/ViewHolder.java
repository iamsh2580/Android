package org.techtown.ex0414;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

//아이템 뷰에 배치된 뷰 객체들을 초기화하는 역할
public class ViewHolder {
    private ImageView imgPro;
    private TextView tvProName;
    private TextView tvProCount;
    private ImageButton btnProDetail;

    public ViewHolder(View itemView){

        this.imgPro = itemView.findViewById(R.id.imgPro);
        this.tvProName = itemView.findViewById(R.id.tvProName);
        this.tvProCount =  itemView.findViewById(R.id.tvProCount);
        this.btnProDetail = itemView.findViewById(R.id.btnProDetail);
    }

    public ImageView getImageView() {
        return imgPro;
    }

    public TextView getTvName() {
        return tvProName;
    }

    public TextView getTvPhone() {
        return tvProCount;
    }

    public ImageButton getBtnCall() {
        return btnProDetail;
    }
}
