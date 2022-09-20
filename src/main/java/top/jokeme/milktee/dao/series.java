package top.jokeme.milktee.dao;

import com.baomidou.mybatisplus.annotation.TableId;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/19
 **/
public class series {
    @TableId
    int suid;
    String name;

    @Override
    public String toString() {
        return "series{" +
                "suid=" + suid +
                ", name='" + name + '\'' +
                '}';
    }

    public int getSuid() {
        return suid;
    }

    public void setSuid(int suid) {
        this.suid = suid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
