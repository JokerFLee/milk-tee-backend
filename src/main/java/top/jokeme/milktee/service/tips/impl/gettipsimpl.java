package top.jokeme.milktee.service.tips.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.tips;
import top.jokeme.milktee.mapper.tipsMp;
import top.jokeme.milktee.service.tips.gettips;

import java.util.List;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/21
 **/
@SuppressWarnings("ALL")
@Service
public class gettipsimpl implements gettips {

    @Autowired
    private tipsMp tipsMp;

    @Override
    public List gettips() {
        Logger logger = LoggerFactory.getLogger(getClass());

        List<tips> tipslist = tipsMp.selectList(null);
        logger.info("xxx request for all tips list");
        return tipslist;
    }

    @Override
    public Boolean gettips(String st) {
        Logger logger = LoggerFactory.getLogger(getClass());
        QueryWrapper qw = new QueryWrapper();
        qw.eq("name",st);
        logger.info("Getting request for check tip exist by name : '" +st+"'");
        tips tp = tipsMp.selectOne(qw);
        if (tp == null){
            logger.warn("The request for name : '"+st+"' not exist in tips");
            return false;
        }
        return true;
    }

    @Override
    public Boolean gettipbytuid(Integer tuid) {
        Logger logger = LoggerFactory.getLogger(getClass());
        QueryWrapper qw = new QueryWrapper();
        qw.eq("tuid", tuid);
        logger.info("Getting request for check tips exist by tuid : '" + tuid + "'");
        tips x = tipsMp.selectOne(qw);
        if (x == null) {
            logger.warn("The request for tuid : '" + tuid + "' not exist in tips");
            return false;
        }
        return true;
    }
}
