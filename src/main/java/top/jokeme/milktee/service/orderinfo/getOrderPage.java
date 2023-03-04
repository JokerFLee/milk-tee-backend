package top.jokeme.milktee.service.orderinfo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.jokeme.milktee.dao.orderinfo;
import top.jokeme.milktee.entity.general.toVueMultiData;

public interface getOrderPage {
    toVueMultiData getOrderPageList(Page<orderinfo> page);
}
