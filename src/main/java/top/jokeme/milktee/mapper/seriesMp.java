package top.jokeme.milktee.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import top.jokeme.milktee.dao.series;
import top.jokeme.milktee.entity.series.CSeries;

import java.util.List;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/20
 **/
public interface seriesMp extends BaseMapper<series> {

    @Select("select series.*, t.number from series left join (select series, count(*) as number from milktea group by series) t on series.suid = t.series order by series.create_date desc")
    public List<CSeries> getserierCount();
}
