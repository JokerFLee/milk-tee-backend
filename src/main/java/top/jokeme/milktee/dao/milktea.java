package top.jokeme.milktee.dao;

import java.util.List;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/19
 **/
public class milktea {

    String guid;
    String name;
    double price;
    String picurl;
    String intro;
    String tips;
    String series;
    String create_date;
    double discount;
    byte soldout;

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

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public byte getSoldout() {
        return soldout;
    }

    public void setSoldout(byte soldout) {
        this.soldout = soldout;
    }

    @Override
    public String toString() {
        return "milktea{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", picurl='" + picurl + '\'' +
                ", intro='" + intro + '\'' +
                ", tips=" + tips +
                ", series='" + series + '\'' +
                ", create_date='" + create_date + '\'' +
                ", discount=" + discount +
                ", soldout=" + soldout +
                '}';
    }
}
