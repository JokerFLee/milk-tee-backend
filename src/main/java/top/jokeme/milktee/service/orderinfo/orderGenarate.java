package top.jokeme.milktee.service.orderinfo;

import top.jokeme.milktee.entity.OrderContent;

import java.util.List;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/11/24
 **/
public interface orderGenarate {
    public String orderGenarate(List<OrderContent> moc);
}
