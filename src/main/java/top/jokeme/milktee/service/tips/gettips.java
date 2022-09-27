package top.jokeme.milktee.service.tips;

import java.util.List;
import java.util.Map;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/20
 **/
public interface gettips {
    List gettips();
    Boolean gettips(String st);
    Boolean gettipbytuid(Integer tuid);
}
