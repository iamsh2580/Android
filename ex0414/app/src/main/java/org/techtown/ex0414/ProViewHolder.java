package org.techtown.ex0414;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProViewHolder {
    private ImageView imgPro;
    private TextView tvProName;
    private TextView tvProCount;
    private Button btnProDetail;

    public ProViewHolder(View itemView) {
        this.imgPro = itemView.findViewById(R.id.imgPro);
        this.tvProName = itemView.findViewById(R.id.tvProName);
        this.tvProCount = itemView.findViewById(R.id.tvProCount);
        this.btnProDetail = itemView.findViewById(R.id.btnProDetail);
    }

    public ImageView getImgPro() {
        return imgPro;
    }

    public TextView getTvProName() {
        return tvProName;
    }

    public TextView getTvProCount() {
        return tvProCount;
    }

    public Button getBtnProDetail() {
        return btnProDetail;
    }
}
