package top.jokeme.milktee.service.orderinfo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.orderinfo;
import top.jokeme.milktee.entity.general.toVueSingleData;
import top.jokeme.milktee.mapper.orderMp;
import top.jokeme.milktee.service.orderinfo.deleteOrderinfo;
import top.jokeme.milktee.utils.NTime;

@Service
@SuppressWarnings("ALL")
public class deleteOrderinfoImpl implements deleteOrderinfo {

    @Autowired
    private orderMp orderMp;

    @Override
    public toVueSingleData deleteOrderinfobyouid(String ouid) {
        Logger logger = LoggerFactory.getLogger(getClass());
        toVueSingleData<Integer> tvj = new toVueSingleData<>("deleteorderinfo");
        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("ouid",ouid);
        tvj.setErrorStatus(true);
        tvj.setMsg("503");
        tvj.setSingleDate(0);
        try{
            orderinfo odif = orderMp.selectOne(qw);
            odif.setIsdel((byte) 1);
            odif.setDel_time(new NTime().getNowTime());
            int result = orderMp.update(odif,qw);
            if (result == 1){
                tvj.oneKeyOk();
                tvj.setSingleDate(1);
            }
        }catch (Exception e){
            logger.error("Delete record from orderinfo get the result: Failed");
        }
        return tvj;
    }
}
