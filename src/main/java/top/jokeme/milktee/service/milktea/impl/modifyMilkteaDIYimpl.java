package top.jokeme.milktee.service.milktea.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.milkteadiy;
import top.jokeme.milktee.mapper.milkteadiyMp;
import top.jokeme.milktee.service.milktea.modifyMilkteaDIY;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/10/27
 **/

@Service
@SuppressWarnings("ALL")
public class modifyMilkteaDIYimpl implements modifyMilkteaDIY {

    @Autowired
    private milkteadiyMp milkteadiyMp;

    @Override
    public String modifyMilkteaDIY(milkteadiy mtdiy) {
        Logger logger = LoggerFactory.getLogger(getClass());

        logger.info(mtdiy.toString());

        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("guid",mtdiy.getGuid());
        String result = "200 ok";
        if (milkteadiyMp.exists(qw)){
//            exist -> modify
            UpdateWrapper updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("guid",mtdiy.getGuid());
            if ( (milkteadiyMp.update(mtdiy,updateWrapper)) != 1 ){
                result = "error";
                logger.error("update diy milktea info error");
            }
        }else {
//            not exist -> create it
            if((milkteadiyMp.insert(mtdiy) != 1)) {
                result = "error";
                logger.error("create diy milktea info error!");
            }
        }
        return result;
    }

    @Override
    public milkteadiy getbyguid(String guid) {
        Logger logger = LoggerFactory.getLogger(getClass());
        logger.info("get milktea diy info by guid "+ guid);
        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("guid",guid);
        return milkteadiyMp.selectOne(qw);
    }
}
