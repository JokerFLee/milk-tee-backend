package top.jokeme.milktee.service.milktea;

import top.jokeme.milktee.entity.general.toVueMultiData;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/10/2
 **/
public interface delMilkTea {
    toVueMultiData delMilkByGuid(String guid);
}
