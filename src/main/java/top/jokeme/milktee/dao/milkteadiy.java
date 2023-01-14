package top.jokeme.milktee.dao;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/10/27
 **/
public class milkteadiy {
    String guid;
    String smell;
    String temperature;
    String content;
    String other;
    String other_name;

    @Override
    public String toString() {
        return "milkteadiy{" +
                "guid='" + guid + '\'' +
                ", smell='" + smell + '\'' +
                ", temperature='" + temperature + '\'' +
                ", content='" + content + '\'' +
                ", other='" + other + '\'' +
                ", other_name='" + other_name + '\'' +
                '}';
    }

    public String getOther_name() {
        return other_name;
    }

    public void setOther_name(String other_name) {
        this.other_name = other_name;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getSmell() {
        return smell;
    }

    public void setSmell(String smell) {
        this.smell = smell;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
