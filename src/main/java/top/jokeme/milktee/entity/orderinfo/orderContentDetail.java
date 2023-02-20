package top.jokeme.milktee.entity.orderinfo;

import java.util.List;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/11/26
 **/
public class orderContentDetail {
    String guid;
    String name;
    int num;
    List<String> remark;

    @Override
    public String toString() {
        return "orderContentDetail{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", remark=" + remark +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<String> getRemark() {
        return remark;
    }

    public void setRemark(List<String> remark) {
        this.remark = remark;
    }
}
