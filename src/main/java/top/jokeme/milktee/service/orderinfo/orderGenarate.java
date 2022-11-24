package top.jokeme.milktee.service.orderinfo;

import top.jokeme.milktee.entity.milkteaOrderContent;

import java.util.Map;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/11/24
 **/
public interface orderGenarate {
    public Map orderGenarate(milkteaOrderContent[] moc);
}
