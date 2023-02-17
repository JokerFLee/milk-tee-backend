package top.jokeme.milktee.entity;

import java.util.List;

public class toVueMultiData<T> {
    public toVueMultiData() {
    }
    public toVueMultiData(String location) {
        this.location = location;
    }

    // 哪一个接口
    String location;
    // 函数执行是否出错
    boolean errorStatus;
    // 返回给前端的提示信息
    String msg;

    // 返回给前端的数据
    List<T> dataList;

    public void oneKeyOk(){
        this.msg= "200 ok";
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

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
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

    public List<T> getDataList() {
        return dataList;
    }

    @Override
    public String toString() {
        return "toVueMultiData{" +
                "location='" + location + '\'' +
                ", errorStatus=" + errorStatus +
                ", msg='" + msg + '\'' +
                ", dataList=" + dataList +
                '}';
    }
}
