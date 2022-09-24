package top.jokeme.milktee.service.milktee.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.milktee;
import top.jokeme.milktee.mapper.milkteeMp;
import top.jokeme.milktee.service.milktee.addnewtee;
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
public class addnewteeimpl implements addnewtee {

    @Autowired
    private milkteeMp milkteeMp;

    @Override
    public Integer addnewmilktee(Map<String,String> map) {
        Logger logger = LoggerFactory.getLogger(getClass());

        milktee mt = new milktee();

        mt.setPrice(Float.parseFloat(String.valueOf(map.get("price"))));
        mt.setPicurl((String) map.get("uri"));
        mt.setIntro((String) map.get("intro"));
        mt.setTopic(String.valueOf(map.get("mk_tips")));
        mt.setSeries((String) map.get("mk_series"));
        mt.setName((String) map.get("name"));

        mt.setGuid(new uuid().generateuuid());
        mt.setCreate_data(new NTime().getNowTime());
        mt.setDiscount(1f);
        mt.setSoldout((byte) 0);

        logger.info(mt.toString());

        return milkteeMp.insert(mt);
    }
}
