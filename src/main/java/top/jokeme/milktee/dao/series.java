package top.jokeme.milktee.dao;

import com.baomidou.mybatisplus.annotation.TableId;

import javax.xml.crypto.Data;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/19
 **/
public class series {
    Integer suid;
    String name;
    String create_date;

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

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    @Override
    public String toString() {
        return "series{" +
                "suid=" + suid +
                ", name='" + name + '\'' +
                ", create_date='" + create_date + '\'' +
                '}';
    }
}
