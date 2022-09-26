package top.jokeme.milktee.service.series.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.series;
import top.jokeme.milktee.mapper.seriesMp;
import top.jokeme.milktee.service.series.addseries;
import top.jokeme.milktee.service.series.getseries;
import top.jokeme.milktee.utils.uuid;

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

    @Autowired
    private getseries getseries;

    @Override
    public String addseries(String se) {
        Logger logger = LoggerFactory.getLogger(getClass());

        uuid uid = new uuid();
        Integer x = uid.shortuuid();

        while (getseries.getseriesbyuuid(x)){
            x = uid.shortuuid();
        }

        series serie = new series();
        serie.setName(se);
        serie.setSuid(x);

        if (!getseries.getseriesbyname(se)) {
            Integer y = seriesMp.insert(serie);
            if (y == 1) {
                logger.info("xxx add series : " + se + " success!");
                return "200 ok";
            }else {
                logger.error("Insert series into mysql error, returnd : '"+ y +"'");
            }
        }else{
            logger.warn("Try to add a exist series name : '"+se+"'");
        }
        return "error";
    }
}
