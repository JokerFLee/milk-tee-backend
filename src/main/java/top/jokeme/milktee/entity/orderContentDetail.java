package top.jokeme.milktee.entity;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/11/25
 **/
public class orderContentDetail {
    String guid;
    int num;

    @Override
    public String toString() {
        return "{" +
                "guid='" + guid + '\'' +
                ", num=" + num +
                '}';
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
}
