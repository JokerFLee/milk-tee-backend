package top.jokeme.milktee.dao;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/20
 **/
public class tips {
    Integer tuid;
    String name;

    @Override
    public String toString() {
        return "tips{" +
                "tuid=" + tuid +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getTuid() {
        return tuid;
    }

    public void setTuid(Integer tuid) {
        this.tuid = tuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
