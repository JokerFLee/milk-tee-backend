package top.jokeme.milktee.dao;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/19
 **/
public class orderinfo {

    String ouid;
    String order_detail;
    String order_time;
    String money;
    byte isdel;
    byte refund;
    String del_time;
    String refund_time;


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
}
