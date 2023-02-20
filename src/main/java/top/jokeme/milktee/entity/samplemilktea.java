package top.jokeme.milktee.entity;

import java.util.List;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/30
 **/
public class samplemilktea {

    String guid;
    String name;
    double price;
    Byte soldout;
    double discount;
    String picurl;
    String intro;
    List<String> tips;
    String series;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Byte getSoldout() {
        return soldout;
    }

    public void setSoldout(Byte soldout) {
        this.soldout = soldout;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public List<String> getTips() {
        return tips;
    }

    public void setTips(List<String> tips) {
        this.tips = tips;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "samplemilktea{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", soldout=" + soldout +
                ", discount=" + discount +
                ", picurl='" + picurl + '\'' +
                ", intro='" + intro + '\'' +
                ", tips=" + tips +
                ", series='" + series + '\'' +
                '}';
    }
}
