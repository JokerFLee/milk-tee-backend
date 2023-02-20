package top.jokeme.milktee.dao;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/28
 **/
public class uri {
    String uuid;
    String original_name;
    String present_name;
    String create_date;
    String genarate_url;

    @Override
    public String toString() {
        return "uri{" +
                "uuid='" + uuid + '\'' +
                ", original_name='" + original_name + '\'' +
                ", present_name='" + present_name + '\'' +
                ", create_date='" + create_date + '\'' +
                ", genarate_url='" + genarate_url + '\'' +
                '}';
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public String getPresent_name() {
        return present_name;
    }

    public void setPresent_name(String present_name) {
        this.present_name = present_name;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getGenarate_url() {
        return genarate_url;
    }

    public void setGenarate_url(String genarate_url) {
        this.genarate_url = genarate_url;
    }
}
