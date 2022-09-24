package top.jokeme.milktee.service.tips.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.tips;
import top.jokeme.milktee.mapper.tipsMp;
import top.jokeme.milktee.service.tips.addtips;
import top.jokeme.milktee.service.tips.gettips;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/20
 **/
@SuppressWarnings("ALL")
@Service
public class addtipsimpl implements addtips {

    @Autowired
    private tipsMp tipsMp;

    @Autowired
    private gettips gettips;

    @Override
    public String addtips(String tips) {
        Logger logger = LoggerFactory.getLogger(getClass());

        tips tip = new tips();
        tip.setName(tips);
        tip.setTuid(null);
        if (!gettips.gettips(tips)){
            Integer x = tipsMp.insert(tip);
            if (x == 1){
                logger.info("Add tip success! tip : '"+tip.toString()+"'");
                return "200 ok";
            }else{
                logger.error("Insert tip into mysql error, returnd : '"+ x +"'");
            }
        }else {
            logger.error("Try to add a exist tip name : '"+tips+"'");
        }
        return "error";
    }
}
