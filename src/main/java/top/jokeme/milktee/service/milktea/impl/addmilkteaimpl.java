package top.jokeme.milktee.service.milktea.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.milktea;
import top.jokeme.milktee.entity.toVueJson;
import top.jokeme.milktee.mapper.milkteaMp;
import top.jokeme.milktee.service.milktea.addmilktea;
import top.jokeme.milktee.utils.NTime;
import top.jokeme.milktee.utils.uuid;

import java.util.Map;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/19
 **/
@SuppressWarnings("ALL")
@Service
public class addmilkteaimpl implements addmilktea {

    @Autowired
    private milkteaMp milkteaMp;

    @Override
    public toVueJson addmilktee(Map<String,String> map) {
        Logger logger = LoggerFactory.getLogger(getClass());

        milktea mt = new milktea();

        mt.setPrice(Float.parseFloat(String.valueOf(map.get("price"))));
        mt.setPicurl((String) map.get("picurl"));
        mt.setIntro((String) map.get("intro"));
        mt.setTips(String.valueOf(map.get("tips")));
        mt.setSeries((String) map.get("series"));
        mt.setName((String) map.get("name"));

        mt.setGuid(new uuid().generateuuid());
        mt.setCreate_date(new NTime().getNowTime());
        mt.setDiscount(1f);
        mt.setSoldout((byte) 0);

        logger.info(mt.toString());
        toVueJson tvj = new toVueJson<Integer>();
        try {
            milkteaMp.insert(mt);
            tvj.setLocation("/addmilktea");
            tvj.setErrorStatus(false);
            tvj.setMsg("数据保存成功!");
            tvj.setDataList(null);
        }catch (Exception e){
            tvj.setLocation("/addmilktea");
            tvj.setErrorStatus(true);
            tvj.setMsg("数据保存失败!");
            tvj.setDataList(null);
        }
        return tvj;
    }
}
