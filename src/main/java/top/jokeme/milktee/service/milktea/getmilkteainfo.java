package top.jokeme.milktee.service.milktea;

import top.jokeme.milktee.dao.milktea;

import java.util.List;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/30
 **/
public interface getmilkteainfo {
    List<milktea> getmilktealist(String token);
    boolean checkExistByName(String name);
    milktea getMilkTeaInfoByGuid(String guid);

}
