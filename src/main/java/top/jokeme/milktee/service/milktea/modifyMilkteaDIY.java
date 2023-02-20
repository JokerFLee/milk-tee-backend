package top.jokeme.milktee.service.milktea;

import top.jokeme.milktee.dao.milkteadiy;
import top.jokeme.milktee.entity.general.toVueMultiData;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/10/27
 **/
public interface modifyMilkteaDIY {
    toVueMultiData modifyMilkteaDIY(milkteadiy mtdiy);
    toVueMultiData getbyguid(String guid);
}
