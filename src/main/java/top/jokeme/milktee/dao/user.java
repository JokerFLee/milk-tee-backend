package top.jokeme.milktee.dao;

import com.baomidou.mybatisplus.annotation.TableId;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/19
 **/
public class user {
    @TableId
    Integer uuid;
    String username;
    byte permission;
    String passwd;

    String create_time;

    @Override
    public String toString() {
        return "user{" +
                "uuid=" + uuid +
                ", username='" + username + '\'' +
                ", permission=" + permission +
                ", passwd='" + passwd + '\'' +
                ", create_time='" + create_time + '\'' +
                '}';
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte getPermission() {
        return permission;
    }

    public void setPermission(byte permission) {
        this.permission = permission;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
