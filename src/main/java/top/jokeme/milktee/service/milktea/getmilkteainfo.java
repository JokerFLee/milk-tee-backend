package top.jokeme.milktee.service.milktea;

import top.jokeme.milktee.dao.milktea;
import top.jokeme.milktee.entity.samplemilktea;


import java.util.List;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/30
 **/
public interface getmilkteainfo {
    List<samplemilktea> getmilktealist(String token);
    boolean checkExistByName(String name);
    samplemilktea getMilkTeaInfoByGuid(String guid);
    milktea getRealMilkTeaByGuid(String guid);

}
