package top.jokeme.milktee.service.milktea;

import top.jokeme.milktee.entity.milkteaPrice;

import java.util.HashMap;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/11/8
 **/
public interface countPrice {
    HashMap countMilkteaPrice(milkteaPrice[] list);
    HashMap countMilkteaPriceWithCheapCode(milkteaPrice[] list,String cheapcode);
}
