package top.jokeme.milktee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import top.jokeme.milktee.dao.milktea;

import java.util.List;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/19
 **/
public interface milkteaMp extends BaseMapper<milktea> {
    @Select("select * from milktea as m join series as s on m.series = s.suid order by s.create_date desc, m.create_date desc")
    List<milktea> selectAllDescList();
}
