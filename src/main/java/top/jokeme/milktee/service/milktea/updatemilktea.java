package top.jokeme.milktee.service.milktea;

import top.jokeme.milktee.entity.samplemilktea;
import top.jokeme.milktee.entity.toVueJson;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/10/1
 **/
public interface updatemilktea {
    toVueJson updatemilkteabyguid(samplemilktea samplemilktea);

    toVueJson updateonecolume(String guid,String colume,String value);
}
