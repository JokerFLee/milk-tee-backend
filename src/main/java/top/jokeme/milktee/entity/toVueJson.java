package top.jokeme.milktee.entity;

import java.util.List;

public class toVueJson<T> {
    public toVueJson() {
    }
    public toVueJson(String location) {
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

    public void setSingleDate(T singleDate) {
        this.singleDate = singleDate;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
