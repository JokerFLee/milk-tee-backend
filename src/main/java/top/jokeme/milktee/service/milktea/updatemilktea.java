package top.jokeme.milktee.service.milktea;

import top.jokeme.milktee.entity.samplemilktea;
import top.jokeme.milktee.entity.toVueMultiData;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/10/1
 **/
public interface updatemilktea {
    toVueMultiData updatemilkteabyguid(samplemilktea samplemilktea);

    toVueMultiData updateonecolume(String guid, String colume, String value);
}
