package top.jokeme.milktee.service.milktea;

import top.jokeme.milktee.entity.milkteaPrice;
import top.jokeme.milktee.entity.toVueJson;

import java.util.HashMap;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/11/8
 **/
public interface countPrice {
    toVueJson countMilkteaPrice(milkteaPrice[] list);
    toVueJson countMilkteaPriceWithCheapCode(milkteaPrice[] list,String cheapcode);
}
