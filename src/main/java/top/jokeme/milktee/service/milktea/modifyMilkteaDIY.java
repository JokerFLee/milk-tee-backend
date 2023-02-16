package top.jokeme.milktee.service.milktea;

import top.jokeme.milktee.dao.milkteadiy;
import top.jokeme.milktee.entity.toVueJson;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/10/27
 **/
public interface modifyMilkteaDIY {
    toVueJson modifyMilkteaDIY(milkteadiy mtdiy);
    toVueJson getbyguid(String guid);
}
