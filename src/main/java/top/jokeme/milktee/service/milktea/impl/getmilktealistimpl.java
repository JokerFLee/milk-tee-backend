package top.jokeme.milktee.service.milktea.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.milktea;
import top.jokeme.milktee.mapper.milkteaMp;
import top.jokeme.milktee.service.milktea.getmilkteainfo;
import top.jokeme.milktee.utils.tosample;

import java.util.List;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/30
 **/

@SuppressWarnings("ALL")
@Service
public class getmilktealistimpl implements getmilkteainfo {

    @Autowired
    private milkteaMp milkteaMp;

    @Override
    public List<milktea> getmilktealist(String token) {
        Logger logger = LoggerFactory.getLogger(getClass());

        QueryWrapper qw = new QueryWrapper<>();
        qw.orderByDesc("create_date");//倒序 最新的在最前
//        qw.orderByAsc("create_date"); // 正序 最新的在最后
        List<milktea> list = milkteaMp.selectList(qw);

        List filist = new tosample().tosamplemilktea(list);

        logger.info("xxx request for all Milktea list");

        return filist;
    }

    @Override
    public boolean checkExistByName(String name) {
        Logger logger = LoggerFactory.getLogger(getClass());
        logger.info("Get request for check the name : "+name+" is exist in milktea. Passed");
        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("name",name);
        return milkteaMp.exists(qw);
    }

    @Override
    public milktea getMilkTeaInfoByGuid(String guid) {
        Logger logger = LoggerFactory.getLogger(getClass());
        logger.info("Get request to get the detail infomation of guid : "+guid+" in milktea. Passed");
        QueryWrapper qw = new QueryWrapper<>().eq("guid",guid);
        return milkteaMp.selectOne(qw);

    }

}
