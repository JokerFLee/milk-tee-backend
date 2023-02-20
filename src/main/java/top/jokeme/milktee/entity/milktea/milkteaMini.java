package top.jokeme.milktee.entity.milktea;

import java.util.List;

public class milkteaMini {
    String name;
    Double price;
    String intro;
    String picurl;
    List<String> tips;
    String series;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
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
        return "milkteaMini{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", intro='" + intro + '\'' +
                ", picurl='" + picurl + '\'' +
                ", tips=" + tips +
                ", series='" + series + '\'' +
                '}';
    }
}
