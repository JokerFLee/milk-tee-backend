package top.jokeme.milktee.entity.general;

import java.util.List;

public class toVueSingleData<T> {

    public toVueSingleData() {
    }

    public toVueSingleData(String location) {
        this.location = location;
    }

    // 哪一个接口
    String location;

    // 函数执行是否出错
    boolean errorStatus;

    // 返回给前端的提示信息
    String msg;

    // 返回给前端的单个数据
    T singleDate;

    public void oneKeyOk() {
        this.msg = "200 ok";
        this.errorStatus = false;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setErrorStatus(boolean errorStatus) {
        this.errorStatus = errorStatus;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setSingleDate(T singleDate) {
        this.singleDate = singleDate;
    }

    public String getLocation() {
        return location;
    }

    public boolean isErrorStatus() {
        return errorStatus;
    }

    public String getMsg() {
        return msg;
    }

    public T getSingleDate() {
        return singleDate;
    }

    @Override
    public String toString() {
        return "toVueSingleData{" + "location='" + location + '\'' + ", errorStatus=" + errorStatus + ", msg='" + msg + '\'' + ", singleDate=" + singleDate + '}';
    }
}


