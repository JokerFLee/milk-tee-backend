package top.jokeme.milktee.dao;

import com.baomidou.mybatisplus.annotation.TableId;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/19
 **/
public class orderinfo {
    @TableId
    long ouid;
    String order_detail;
    String order_time;
    String user;
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

    public long getOuid() {
        return ouid;
    }

    public void setOuid(long ouid) {
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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
