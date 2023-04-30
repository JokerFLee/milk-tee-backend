package top.jokeme.milktee.service.orderinfo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.orderinfo;
import top.jokeme.milktee.mapper.orderMp;
import top.jokeme.milktee.service.orderinfo.manageOrder;


@Service
@SuppressWarnings("ALL")
public class manageOrderImpl implements manageOrder {

    @Autowired
    private orderMp orderMp;

    @Override
    public boolean delOrder(String ouid) {
        Logger logger = LoggerFactory.getLogger(getClass());
        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("ouid", ouid);
        try {
            if (orderMp.delete(qw) == 1) {
                logger.info("Delete cancelled orders successfully!");
                return true;
            }
        } catch (Exception e) {
            logger.warn("Delete cancelled orders Failed!");
            return false;
        }
        return false;
    }

    @Override
    public boolean pay(String payMethod, String ouid) {
        Logger logger = LoggerFactory.getLogger(getClass());
        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("ouid",ouid);
        orderinfo od = null;
        try {
            od = orderMp.selectOne(qw);
            od.setPay_method(payMethod);
            od.setPaid('Y');
            try {
                orderMp.update(od,qw);
                return true;
            } catch (Exception e) {
                logger.error("Mysql insert error.Does mysql is running?");
            }
        } catch (Exception e) {
            logger.error("Mysql select error.Does mysql is running?");
        }
        return false;
    }
}
