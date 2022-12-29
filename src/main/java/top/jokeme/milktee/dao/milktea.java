package top.jokeme.milktee.dao;

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

    @Override
    public String toString() {
        return "milktee{" +
                "guid=" + guid +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", picurl='" + picurl + '\'' +
                ", intro='" + intro + '\'' +
                ", topic='" + tips + '\'' +
                ", series='" + series + '\'' +
                ", create_date='" + create_date + '\'' +
                ", discount=" + discount +
                ", soldout=" + soldout +
                '}';
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

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
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
        public milktea iswhich(milktea mt, String str, String value) {
        if (str.equals("name")) {
            mt.setName(value);
        } else if (str.equals("price")) {
            mt.setPrice(Double.parseDouble(value));
        } else if (str.equals("picurl")) {
            mt.setPicurl(value);
        } else if (str.equals("intro")) {
            mt.setIntro(value);
        } else if (str.equals("tips")) {
            mt.setTips(value);
        } else if (str.equals("series")) {
            mt.setSeries(value);
        } else if (str.equals("discount")) {
            mt.setDiscount(Double.parseDouble(value));
        } else if (str.equals("soldout")) {
            mt.setSoldout(Byte.parseByte(value));
        }
        return mt;
    }
}
