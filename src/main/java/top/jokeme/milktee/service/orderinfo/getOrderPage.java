package top.jokeme.milktee.service.orderinfo;

import top.jokeme.milktee.entity.general.toVueMultiData;

public interface getOrderPage {
    toVueMultiData getOrderPageList(Integer page, Integer size);
}
