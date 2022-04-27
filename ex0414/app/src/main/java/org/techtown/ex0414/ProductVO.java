package org.techtown.ex0414;

public class ProductVO {

    private int img;
    private int pro_name;
    private String pro_count;

    public ProductVO(){}

    public ProductVO(int img, int pro_name, String pro_count) {
        this.img = img;
        this.pro_name = pro_name;
        this.pro_count = pro_count;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getPro_name() {
        return pro_name;
    }

    public void setPro_name(int pro_name) {
        this.pro_name = pro_name;
    }

    public String getPro_count() {
        return pro_count;
    }

    public void setPro_count(String pro_count) {
        this.pro_count = pro_count;
    }

    @Override
    public String toString() {
        return "ProductVO{" +
                "img=" + img +
                ", pro_name='" + pro_name + '\'' +
                ", pro_count='" + pro_count + '\'' +
                '}';
    }
}



