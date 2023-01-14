package top.jokeme.milktee.service.milktea.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.mapper.milkteaMp;
import top.jokeme.milktee.service.milktea.delMilkTea;



/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/10/2
 **/
@SuppressWarnings("ALL")
@Service
public class delMilkTeaImpl implements delMilkTea {

    @Autowired
    private milkteaMp milkteaMp;

    @Override
    public String delMilkByGuid(String guid) {

        Logger logger = LoggerFactory.getLogger(getClass());

        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("guid",guid);

        if (milkteaMp.exists(qw)){
            logger.info("Will delete the record : "+milkteaMp.selectOne(qw).toString());
        }else{
            logger.warn("Try to delete a not exist record");
            return "error";
        }

        int x = milkteaMp.delete(qw);
        if (x == 1){
            return "200 ok";
        }
        return "error";
    }
}
