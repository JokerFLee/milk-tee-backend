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
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");
        return sdf.format(dt);
    }
    public String getShortTime() {
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dt);
    }
}
