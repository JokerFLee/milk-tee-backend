package top.jokeme.milktee.service.milktea.impl;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.milktea;
import top.jokeme.milktee.entity.milkteaMini;
import top.jokeme.milktee.entity.toVueMultiData;
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
    public toVueMultiData addmilktee(milkteaMini mtm) {
        Logger logger = LoggerFactory.getLogger(getClass());

        milktea mt = new milktea();

        mt.setName(mtm.getName());
        mt.setIntro(mtm.getIntro());
        mt.setPrice(mtm.getPrice());
        mt.setSeries(mtm.getSeries());
        mt.setTips(new Gson().toJson(mtm.getTips()));
        mt.setPicurl(mtm.getPicurl());

        mt.setGuid(new uuid().generateuuid());
        mt.setCreate_date(new NTime().getNowTime());
        mt.setDiscount(1f);
        mt.setSoldout((byte) 0);

        logger.info("Save this data to mysql : "+mt.toString());
        toVueMultiData tvj = new toVueMultiData<Integer>();
        try {
            milkteaMp.insert(mt);
            tvj.setLocation("/addmilktea");
            tvj.setErrorStatus(false);
            tvj.setMsg("数据保存成功!");
            tvj.setDataList(null);
        }catch (Exception e){
            logger.info(e.toString());
            tvj.setLocation("/addmilktea");
            tvj.setErrorStatus(true);
            tvj.setMsg("数据保存失败!");
            tvj.setDataList(null);
        }
        return tvj;
    }
}
