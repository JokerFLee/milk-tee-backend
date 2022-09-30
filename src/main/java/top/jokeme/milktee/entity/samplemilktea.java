package top.jokeme.milktee.entity;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/30
 **/
public class samplemilktea {

    String guid;
    String name;
    float price;
    Byte soldout;
    float discount;
    String picurl;
    String intro;
    String tips;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Byte getSoldout() {
        return soldout;
    }

    public void setSoldout(Byte soldout) {
        this.soldout = soldout;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
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
}
