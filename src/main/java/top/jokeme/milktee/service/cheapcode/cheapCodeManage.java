package top.jokeme.milktee.service.cheapcode;

import top.jokeme.milktee.entity.general.toVueMultiData;
import top.jokeme.milktee.entity.general.toVueSingleData;

public interface cheapCodeManage {
    toVueSingleData generateCode();
    toVueSingleData checkCode(String code);
}
