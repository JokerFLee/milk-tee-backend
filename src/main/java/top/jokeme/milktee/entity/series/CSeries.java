package top.jokeme.milktee.entity.series;

import com.baomidou.mybatisplus.annotation.TableField;

/*
* 因为mybatis-plus需要设定返回值类型，所以有了这个文件。
* */
public class CSeries {
    Integer suid;
    String name;
    Integer number;

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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
