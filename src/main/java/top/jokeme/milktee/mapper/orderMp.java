package top.jokeme.milktee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import top.jokeme.milktee.dao.orderinfo;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/19
 **/
public interface orderMp extends BaseMapper<orderinfo> {

    @Select("select count(*) from orderinfo")
    Long countAll();
}
