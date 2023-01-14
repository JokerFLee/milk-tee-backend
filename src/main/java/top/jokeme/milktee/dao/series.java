package top.jokeme.milktee.dao;

import com.baomidou.mybatisplus.annotation.TableId;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/19
 **/
public class series {
    @TableId
    Integer suid;
    String name;

    @Override
    public String toString() {
        return "series{" +
                "suid=" + suid +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getSuid() {
        return suid;
    }

    public void setSuid(Integer suid) {
        this.suid = suid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
