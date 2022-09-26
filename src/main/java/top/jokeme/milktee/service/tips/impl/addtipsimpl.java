package top.jokeme.milktee.service.tips.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.tips;
import top.jokeme.milktee.mapper.tipsMp;
import top.jokeme.milktee.service.tips.addtips;
import top.jokeme.milktee.service.tips.gettips;
import top.jokeme.milktee.utils.uuid;

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
        uuid uid = new uuid();
        Integer x = uid.shortuuid();

        while (gettips.gettipbytuid(x)) {
            x = uid.shortuuid();
        }
        tips tip = new tips();
        tip.setName(tips);
        tip.setTuid(x);

        if (!gettips.gettips(tips)) {
            Integer y = tipsMp.insert(tip);
            if (y == 1) {
                logger.info("Add tip success! tip : '" + tip + "'");
                return "200 ok";
            } else {
                logger.error("Insert tip into mysql error, returnd : '" + y + "'");
            }
        } else {
            logger.warn("Try to add a exist tip name : '" + tips + "'");
        }
        return "error";
    }
}
