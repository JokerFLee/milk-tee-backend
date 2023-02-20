package top.jokeme.milktee.service.milktea;

import top.jokeme.milktee.entity.milktea.milkteaPrice;
import top.jokeme.milktee.entity.general.toVueSingleData;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/11/8
 **/
public interface countPrice {
    toVueSingleData countMilkteaPrice(milkteaPrice[] list);
    toVueSingleData countMilkteaPriceWithCheapCode(milkteaPrice[] list, String cheapcode);
}
