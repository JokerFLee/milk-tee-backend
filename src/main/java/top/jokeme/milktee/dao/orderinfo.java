package top.jokeme.milktee.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/19
 **/
public class orderinfo {

    @TableId
    String ouid;
    @TableField("order_detail")
    String order_detail;
    @TableField("order_time")
    String order_time;
    @TableField("money")
    String money;
    @TableField("isdel")
    byte isdel;
    @TableField("refund")
    byte refund;
    @TableField("del_time")
    String del_time;
    @TableField("refund_time")
    String refund_time;
    @TableField("pay_method")
    String pay_method;
    @TableField("cheapcode")
    String cheapcode;
    @TableField("paid")
    char paid;

    public String getDel_time() {
        return del_time;
    }

    public void setDel_time(String del_time) {
        this.del_time = del_time;
    }

    public String getRefund_time() {
        return refund_time;
    }

    public void setRefund_time(String refund_time) {
        this.refund_time = refund_time;
    }

    public String getOuid() {
        return ouid;
    }

    public void setOuid(String ouid) {
        this.ouid = ouid;
    }

    public String getOrder_detail() {
        return order_detail;
    }

    public void setOrder_detail(String order_detail) {
        this.order_detail = order_detail;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public byte getIsdel() {
        return isdel;
    }

    public void setIsdel(byte isdel) {
        this.isdel = isdel;
    }

    public byte getRefund() {
        return refund;
    }

    public void setRefund(byte refund) {
        this.refund = refund;
    }

    public String getPay_method() {
        return pay_method;
    }

    public void setPay_method(String pay_method) {
        this.pay_method = pay_method;
    }

    public String getCheapcode() {
        return cheapcode;
    }

    public void setCheapcode(String cheapcode) {
        this.cheapcode = cheapcode;
    }

    public char getPaid() {
        return paid;
    }

    public void setPaid(char paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "orderinfo{" +
                "ouid='" + ouid + '\'' +
                ", order_detail='" + order_detail + '\'' +
                ", order_time='" + order_time + '\'' +
                ", money='" + money + '\'' +
                ", isdel=" + isdel +
                ", refund=" + refund +
                ", del_time='" + del_time + '\'' +
                ", refund_time='" + refund_time + '\'' +
                ", pay_method='" + pay_method + '\'' +
                ", cheapcode='" + cheapcode + '\'' +
                ", paid='" + paid + '\'' +
                '}';
    }
}
