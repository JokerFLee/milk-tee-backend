package top.jokeme.milktee.service.milktea;

import top.jokeme.milktee.entity.milkteaPrice;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/11/8
 **/
public interface countPrice {
    String countMilkteaPrice(milkteaPrice[] list);
    String countMilkteaPriceWithCheapCode(milkteaPrice[] list,String cheapcode);
}
