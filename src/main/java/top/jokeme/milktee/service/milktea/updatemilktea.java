package top.jokeme.milktee.service.milktea;

import top.jokeme.milktee.entity.samplemilktea;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/10/1
 **/
public interface updatemilktea {
    String updatemilkteabuguid(String guid, samplemilktea samplemilktea);

    String updateonecolume(String guid,String colume,String value);
}
