package top.jokeme.milktee.service.milktea;

import top.jokeme.milktee.dao.milkteadiy;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/10/27
 **/
public interface modifyMilkteaDIY {
    String modifyMilkteaDIY(milkteadiy mtdiy);
    milkteadiy getbyguid(String guid);
}
