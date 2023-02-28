package top.jokeme.milktee.service.series.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.series;
import top.jokeme.milktee.mapper.seriesMp;
import top.jokeme.milktee.service.series.addseries;
import top.jokeme.milktee.service.series.getseries;
import top.jokeme.milktee.utils.NTime;
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
    public boolean addseries(String se) {
        Logger logger = LoggerFactory.getLogger(getClass());

        if (se == "" || se == null) {
            logger.warn("Can't add null series name");
            return false;
        }
        uuid uid = new uuid();
        Integer x = uid.shortuuid();
        logger.info("Check if the generated suid is duplicated(重复)");
        while (getseries.getseriesbyuuid(x)) {
            logger.warn("suid is repeated, generating another");
            x = uid.shortuuid();
        }
        logger.info("What luck! The generated suid is not duplicated");
        series serie = new series();
        serie.setName(se);
        serie.setSuid(x);
        serie.setNumber(0);
        serie.setCreate_date(new NTime().getNowTime());

        if (!getseries.getseriesbyname(se)) {
            Integer y = seriesMp.insert(serie);
            if (y == 1) {
                logger.debug("Add series : " + se + " successfully!");
                return true;
            } else {
                logger.error("Insert series into mysql error, returned : '" + y + "'");
            }
        } else {
            logger.warn("Try to add a exist series name : '" + se + "'");
        }
        return false;
    }
}
