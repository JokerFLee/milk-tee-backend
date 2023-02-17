package top.jokeme.milktee.service.series;

import top.jokeme.milktee.entity.toVueMultiData;
import top.jokeme.milktee.entity.toVueSingleData;

import java.util.List;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/24
 **/
public interface getseries {
    boolean getseriesbyname(String name);
    boolean getseriesbyuuid(Integer uuid);
    toVueMultiData getallseries();
}
