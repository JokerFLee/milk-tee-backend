package top.jokeme.milktee.service.series.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.series;
import top.jokeme.milktee.mapper.seriesMp;
import top.jokeme.milktee.service.series.getseries;

import java.util.List;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/24
 **/
@SuppressWarnings("ALL")
@Service
public class getseriesimpl implements getseries {
    @Autowired
    private seriesMp seriesMp;

    @Override
    public boolean getseriesbyname(String name) {
        Logger logger = LoggerFactory.getLogger(getClass());
        QueryWrapper qw = new QueryWrapper();
        qw.eq("name", name);
        logger.info("Getting request for check series exist by name : '" + name + "'");
        series x = seriesMp.selectOne(qw);
        if (x == null) {
            logger.warn("The request for name : '" + name + "' not exist in series");
            return false;
        }
        return true;
    }

    @Override
    public boolean getseriesbyuuid(Integer uuid) {
        Logger logger = LoggerFactory.getLogger(getClass());
        QueryWrapper qw = new QueryWrapper();
        qw.eq("suid", uuid);
        logger.info("Getting request for check series exist by suid : '" + uuid + "'");
        series x = seriesMp.selectOne(qw);
        if (x == null) {
            logger.warn("The request for suid : '" + uuid + "' not exist in series");
            return false;
        }
        return true;
    }

    @Override
    public List getallseries() {
        Logger logger = LoggerFactory.getLogger(getClass());
        List<series> seriesList = seriesMp.selectList(null);
        logger.info("xxx request for all series list");
        return seriesList;
    }
}
