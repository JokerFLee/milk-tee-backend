package top.jokeme.milktee.dao;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/12/29
 **/
public class cheapcode {
    String code;
    byte type;
    String content;
    String create_time;
    String dead_line;
    byte reuse;
    byte used;

    @Override
    public String toString() {
        return "cheapcode{" +
                "code='" + code + '\'' +
                ", type=" + type +
                ", content='" + content + '\'' +
                ", create_time='" + create_time + '\'' +
                ", dead_line='" + dead_line + '\'' +
                ", reuse=" + reuse +
                ", used=" + used +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getDead_line() {
        return dead_line;
    }

    public void setDead_line(String dead_line) {
        this.dead_line = dead_line;
    }

    public byte getReuse() {
        return reuse;
    }

    public void setReuse(byte reuse) {
        this.reuse = reuse;
    }

    public byte getUsed() {
        return used;
    }

    public void setUsed(byte used) {
        this.used = used;
    }
}
