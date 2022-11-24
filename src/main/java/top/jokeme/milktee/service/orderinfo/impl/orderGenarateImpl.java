package top.jokeme.milktee.service.orderinfo.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.milktea;
import top.jokeme.milktee.dao.orderinfo;
import top.jokeme.milktee.entity.milkteaOrderContent;
import top.jokeme.milktee.entity.orderContentDetail;
import top.jokeme.milktee.mapper.orderMp;
import top.jokeme.milktee.service.milktea.getmilkteainfo;
import top.jokeme.milktee.service.orderinfo.orderGenarate;
import top.jokeme.milktee.utils.NTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/11/24
 **/

@Service
@SuppressWarnings("ALL")
public class orderGenarateImpl implements orderGenarate {

    @Autowired
    private orderMp orderMp;

    @Autowired
    private getmilkteainfo getmilkteainfo;

    @Override
    public Map orderGenarate(milkteaOrderContent[] moc) {

        Logger logger = LoggerFactory.getLogger(getClass());
        orderinfo oi = new orderinfo();

        oi.setOuid(String.valueOf(UUID.randomUUID()));

        List<orderContentDetail> ocd_l = new ArrayList<>();
        orderContentDetail ocd = new orderContentDetail();
        double sumCNY = 0.0;
        for (milkteaOrderContent moct : moc) {
            milktea mt = getmilkteainfo.getRealMilkTeaByGuid(moct.getGuid());
            double price = mt.getPrice();
            double discount = mt.getDiscount();
            int num = moct.getNum();
            sumCNY += price*discount*num;
            ocd.setGuid(moct.getGuid());
            ocd.setNum(moct.getNum());
            ocd_l.add(ocd);
        }
        ObjectMapper om = new ObjectMapper();
        try {
            oi.setOrder_detail(om.writeValueAsString(ocd_l));
        } catch (JsonProcessingException e) {
            logger.error("Jackson JsonProcessingException.");
            return null;
//            throw new RuntimeException(e);
        }
        oi.setOrder_time(new NTime().getNowTime());
        oi.setMoney(String.format("%.2f",sumCNY));
        oi.setIsdel((byte) 0);
        oi.setRefund((byte) 0);
        oi.setDel_time(null);
        oi.setRefund_time(null);

        orderMp.insert(oi);
        //写到这里只是完成了数据插入，但是还没有返回数据
        return null;
    }
}
