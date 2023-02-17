package top.jokeme.milktee.service.milktea;

import top.jokeme.milktee.dao.milktea;
import top.jokeme.milktee.entity.toVueMultiData;
import top.jokeme.milktee.entity.toVueSingleData;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/30
 **/
public interface getmilkteainfo {
    toVueMultiData getmilktealist();
    toVueSingleData checkExistByName(String name);
    toVueMultiData getMilkTeaInfoByGuid(String guid);
    toVueMultiData getDescSampleTeaList();
    milktea getRealMilkTeaByGuid(String guid);
}
