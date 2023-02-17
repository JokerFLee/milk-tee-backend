package top.jokeme.milktee.service.milktea.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.milktea;
import top.jokeme.milktee.dao.series;
import top.jokeme.milktee.entity.toVueMultiData;
import top.jokeme.milktee.mapper.milkteaMp;
import top.jokeme.milktee.mapper.seriesMp;
import top.jokeme.milktee.service.milktea.getMilkteaCount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/10/5
 **/
@SuppressWarnings("ALL")
@Service
public class getMilkteaCountimpl implements getMilkteaCount {

    @Autowired
    private seriesMp seriesMp;

    @Autowired
    private milkteaMp milkteaMp;

    @Override
    public toVueMultiData getMilkteaSeriesCount() {

        toVueMultiData<Map> tvj = new toVueMultiData("/getmilkteacount");
        Logger logger = LoggerFactory.getLogger(getClass());

        List<series> x = null;
        List<milktea> y = null;

        try {
            seriesMp.selectList(null);
            milkteaMp.selectList(null);
        } catch (Exception e) {
            logger.error("Mysql select all error.Does mysql is running?");
            tvj.setErrorStatus(true);
            tvj.setMsg("服务器内部错误!请联系管理员处理");
        }


        Map<String, Integer> map = new HashMap<>();

        for (series se : x) {
            map.put(se.getName(), 0);
        }
        for (milktea mt : y) {
            int tmp = map.get(mt.getSeries());
            tmp += 1;
            map.put(mt.getSeries(), tmp);
        }
        List<Map> list = new ArrayList<>();
        list.add(map);
        tvj.oneKeyOk();
        tvj.setDataList(list);
        return tvj;
    }
}
