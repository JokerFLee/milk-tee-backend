package top.jokeme.milktee.service.milktea;

import top.jokeme.milktee.entity.toVueJson;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/10/2
 **/
public interface delMilkTea {
    toVueJson delMilkByGuid(String guid);
}
