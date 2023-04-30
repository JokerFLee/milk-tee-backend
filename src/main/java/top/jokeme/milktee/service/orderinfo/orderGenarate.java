package top.jokeme.milktee.service.orderinfo;

import top.jokeme.milktee.entity.general.toVueMultiData;
import top.jokeme.milktee.entity.orderinfo.OrderContent;

import java.util.HashMap;
import java.util.List;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/11/24
 **/
public interface orderGenarate {
    public toVueMultiData orderGenarate(HashMap<String,Integer> moc,String money);
}
