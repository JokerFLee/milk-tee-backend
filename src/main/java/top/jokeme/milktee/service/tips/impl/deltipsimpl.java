package top.jokeme.milktee.service.tips.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.mapper.tipsMp;
import top.jokeme.milktee.service.tips.deltips;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/20
 **/
@SuppressWarnings("ALL")
@Service
public class deltipsimpl implements deltips {

    @Autowired
    private tipsMp tipsMp;

    @Override
    public String deltips(String tuid) {
        Logger logger = LoggerFactory.getLogger(getClass());

        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tuid",tuid);

        Integer x = tipsMp.delete(queryWrapper);

        if (x == 1){
            logger.info("Request to delete tip by tuid : '"+tuid+"'");
            return "200 ok";
        }
        logger.error("Delete tip by tuid : '"+tuid+"' error!");
        return "error";
    }
}
