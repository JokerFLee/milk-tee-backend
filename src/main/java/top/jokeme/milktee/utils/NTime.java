package top.jokeme.milktee.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/20
 **/
public class NTime {
    public String getNowTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS").format(new Date());
    }
    public String getShortTime() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
    public String diyTime(String diy) {
        return new SimpleDateFormat(diy).format(new Date());
    }
}
