package top.jokeme.milktee.service.series.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.series;
import top.jokeme.milktee.mapper.seriesMp;
import top.jokeme.milktee.service.series.addseries;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/24
 **/
@SuppressWarnings("ALL")
@Service
public class addserviceimpl implements addseries {

    @Autowired
    private seriesMp seriesMp;

    @Override
    public String addseries(String se) {
        Logger logger = LoggerFactory.getLogger(getClass());

        series series = new series();
        series.setName(se);
        series.setSuid(null);

//        logger.info("xxx add series name : "+se);
        int x = seriesMp.insert(series);
        if (x==1){
            logger.info("xxx add series : "+se+" success!");
            return "200 ok";
        }
        logger.error("xxx faild add series : "+se);
        return "error";
    }
}
