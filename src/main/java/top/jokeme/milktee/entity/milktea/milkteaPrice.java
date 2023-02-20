package top.jokeme.milktee.entity.milktea;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/11/8
 **/
public class milkteaPrice {
    String guid;
    int number;

    @Override
    public String toString() {
        return "milkteaPrice{" +
                "guid='" + guid + '\'' +
                ", number=" + number +
                '}';
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
