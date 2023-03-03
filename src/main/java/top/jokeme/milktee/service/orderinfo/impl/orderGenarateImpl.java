package top.jokeme.milktee.service.orderinfo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.milktea;
import top.jokeme.milktee.dao.orderinfo;
import top.jokeme.milktee.entity.general.toVueMultiData;
import top.jokeme.milktee.entity.orderinfo.OrderContent;
import top.jokeme.milktee.entity.orderinfo.orderContentDetail;
import top.jokeme.milktee.mapper.milkteaMp;
import top.jokeme.milktee.mapper.orderMp;
import top.jokeme.milktee.service.milktea.getmilkteainfo;
import top.jokeme.milktee.service.orderinfo.orderGenarate;
import top.jokeme.milktee.utils.NTime;

import java.util.*;

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

    @Override
    public toVueMultiData orderGenarate(HashMap<String , Integer> moc,String money) {
        Logger logger = LoggerFactory.getLogger(getClass());
        toVueMultiData tvj = new toVueMultiData<>("/generateorder");
        logger.info("Orders to be created");
        Set<String> set = moc.keySet();
        double sum = 0.0;
        for (String str : set){
            try {
                QueryWrapper qw = new QueryWrapper<>();
                qw.eq("guid",str);
                milktea mt = milkteaMp.selectOne(qw);
                sum += mt.getPrice() * mt.getDiscount() * moc.get(str);
            }catch (Exception e){
                logger.error("Mysql select all error.Does mysql is running?");
                tvj.setErrorStatus(true);
                tvj.setMsg("服务器内部错误!请联系管理员处理");
                return tvj;
            }
        }
        if (sum != Double.parseDouble(money)){
            logger.warn("Please note! The settlement amount and the amount calculated by the system do not match.");
            logger.debug("User settlement amount: "+money+" . the amount calculated by the system:"+String.valueOf(sum));
        }
        orderinfo od = new orderinfo();
        try{
            QueryWrapper qw = new QueryWrapper<>();
            NTime nt = new NTime();
            qw.like("order_time",nt.getShortTime());
            int count = Math.toIntExact(orderMp.selectCount(qw));
            String prefix = nt.diyTime("yyyyMMddHHmmss");
            String suffix = "";
            if (count <= 9){
                suffix = "00" + count;
            }else {
                suffix = "0" + count;
            }
            od.setOuid(prefix+suffix);
            od.setOrder_detail(new Gson().toJson(moc));
            od.setOrder_time(nt.getNowTime());
            od.setCheapcode(null);
            od.setIsdel((byte) 0);
            od.setDel_time(null);
            od.setPay_method(null);
            od.setRefund((byte) 0);
            od.setRefund_time(null);
            od.setMoney(String.valueOf(sum));
            od.setPaid('N');
        }catch (Exception e){
            logger.error("Mysql select error.Does mysql is running?");
            tvj.setErrorStatus(true);
            tvj.setMsg("服务器内部错误!请联系管理员处理");
            return tvj;
        }
        try{
            orderMp.insert(od);
            tvj.oneKeyOk();
            List list = new ArrayList<>();
            list.add(od.getOuid());
            tvj.setDataList(list);
        }catch (Exception e){
            logger.error("Mysql insert error.Does mysql is running?");
            tvj.setErrorStatus(true);
            tvj.setMsg("服务器内部错误!请联系管理员处理");
            return tvj;
        }
        logger.info("Order created successfully, return data");
        tvj.oneKeyOk();
    return tvj;
    }
}
