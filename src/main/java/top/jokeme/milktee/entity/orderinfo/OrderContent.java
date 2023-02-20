package top.jokeme.milktee.entity.orderinfo;

import java.util.List;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/11/24
 **/
public class OrderContent {
    List<String> content;
    double discount;
    String guid;
    String name;
    int num;
    String picurl;
    double price;

    @Override
    public String toString() {
        return "milkteaOrderContent{" +
                "content=" + content.toString() +
                ", discount=" + discount +
                ", guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", picurl='" + picurl + '\'' +
                ", price=" + price +
                '}';
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
