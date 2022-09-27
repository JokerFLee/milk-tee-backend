package top.jokeme.milktee.service.series.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.mapper.seriesMp;
import top.jokeme.milktee.service.series.delseries;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/26
 **/
@SuppressWarnings("ALL")
@Service
public class delseriesimpl implements delseries {

    @Autowired
    private seriesMp seriesMp;

    @Override
    public String delseries(String suid) {

        Logger logger = LoggerFactory.getLogger(getClass());

        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("suid",suid);
        Integer x = seriesMp.delete(qw);
        if (x == 1){
            logger.info("Request to delete series by suid : '"+suid+"'");
            return "200 ok";
        }
        logger.error("Delete series by suid : '"+suid+"' error!");
        return "error";
    }
}
