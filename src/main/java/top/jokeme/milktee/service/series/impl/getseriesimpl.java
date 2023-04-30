package top.jokeme.milktee.service.series.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.series;
import top.jokeme.milktee.entity.general.toVueMultiData;
import top.jokeme.milktee.mapper.seriesMp;
import top.jokeme.milktee.service.series.getseries;

import java.util.ArrayList;
import java.util.HashMap;
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

        series x = seriesMp.selectOne(qw);
        if (x != null) {
            logger.info("Request to check series exist by name : '" + name + "' (Yes)");
            return true;
        }
        logger.warn("Request for name : '" + name + "' not exist in series (No)");
        return false;

    }

    @Override
    public boolean getseriesbyuuid(Integer uuid) {
        Logger logger = LoggerFactory.getLogger(getClass());
        QueryWrapper qw = new QueryWrapper();
        qw.eq("suid", uuid);
        series x = seriesMp.selectOne(qw);
        if (x == null) {
            return false;
        }
        return true;
    }

    @Override
    public toVueMultiData getallseries() {
        Logger logger = LoggerFactory.getLogger(getClass());
        toVueMultiData<series> tvj = new toVueMultiData<>("/getallseries");

        QueryWrapper qw = new QueryWrapper<>().orderByDesc("name");
        List<series> seriesList = null;
        try {
            seriesList = seriesMp.selectList(qw);
            tvj.oneKeyOk();
            List list = new ArrayList<>();
            for (series se : seriesList) {
                HashMap hm = new HashMap<>();
                hm.put("value", se.getSuid());
                hm.put("label", se.getName());
                list.add(hm);
            }
            tvj.setDataList(list);
            logger.info("Request for all series list");
        } catch (Exception e) {
            logger.error("Mysql select all error.Does mysql is running?");
            tvj.setErrorStatus(true);
            tvj.setMsg("服务器内部错误!请联系管理员处理");
        }
        return tvj;
    }

    @Override
    public toVueMultiData getSeriesCount() {
        Logger logger = LoggerFactory.getLogger(getClass());
        toVueMultiData tvj = new toVueMultiData<>("/getseriescount");
        List list = new ArrayList<>();
        logger.info("is querying the series and its corresponding number");
        try{
             list = seriesMp.getserierCount();
             tvj.oneKeyOk();
             tvj.setDataList(list);
             logger.debug("Query series and its number successfully");
        }catch (Exception e){
            logger.error("Mysql select all error.Does mysql is running?"+list.toString()+e);
            tvj.setErrorStatus(true);
            tvj.setMsg("服务器内部错误!请联系管理员处理");
        }
        return tvj;
    }
}
