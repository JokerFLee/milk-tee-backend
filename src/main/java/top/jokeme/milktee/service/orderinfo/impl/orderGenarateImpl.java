package top.jokeme.milktee.service.orderinfo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.milktea;
import top.jokeme.milktee.dao.orderinfo;
import top.jokeme.milktee.entity.OrderContent;
import top.jokeme.milktee.entity.orderContentDetail;
import top.jokeme.milktee.mapper.milkteaMp;
import top.jokeme.milktee.mapper.orderMp;
import top.jokeme.milktee.service.milktea.getmilkteainfo;
import top.jokeme.milktee.service.orderinfo.orderGenarate;
import top.jokeme.milktee.utils.NTime;

import java.util.ArrayList;
import java.util.List;
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
    private milkteaMp milkteaMp;

    @Autowired
    private getmilkteainfo getmilkteainfo;

    @Override
    public String orderGenarate(List<OrderContent> moc) {

        Logger logger = LoggerFactory.getLogger(getClass());

        orderinfo oi = new orderinfo();

        oi.setOuid(String.valueOf(UUID.randomUUID()));

        List<orderContentDetail> ocd_l = new ArrayList<>();

        double sumCNY = 0.0;
        for (OrderContent moct : moc) {

            orderContentDetail ocd = new orderContentDetail();

            QueryWrapper qw = new QueryWrapper<>();
            qw.eq("guid",moct.getGuid());

            milktea mt = milkteaMp.selectOne(qw);

            double price = mt.getPrice();
            double discount = mt.getDiscount();
            int num = moct.getNum();

            sumCNY += (price*discount*num);

            ocd.setGuid(moct.getGuid());
            ocd.setNum(moct.getNum());
            ocd.setRemark(moct.getContent());
            ocd.setName(moct.getName());
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

        if (orderMp.insert(oi) == 1){
            return oi.getOuid();
        }else{
            return null;
        }
    }
}
