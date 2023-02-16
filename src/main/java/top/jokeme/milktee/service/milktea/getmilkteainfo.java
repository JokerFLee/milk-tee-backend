package top.jokeme.milktee.service.milktea;

import top.jokeme.milktee.dao.milktea;
import top.jokeme.milktee.entity.samplemilktea;
import top.jokeme.milktee.entity.toVueJson;


import java.util.List;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/30
 **/
public interface getmilkteainfo {
    toVueJson getmilktealist(String token);
    toVueJson checkExistByName(String name);
    toVueJson getMilkTeaInfoByGuid(String guid);
    toVueJson getDescSampleTeaList();
    milktea getRealMilkTeaByGuid(String guid);
}
