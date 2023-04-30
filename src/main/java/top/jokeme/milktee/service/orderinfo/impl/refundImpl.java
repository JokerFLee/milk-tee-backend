package top.jokeme.milktee.service.orderinfo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.orderinfo;
import top.jokeme.milktee.entity.general.toVueSingleData;
import top.jokeme.milktee.mapper.milkteaMp;
import top.jokeme.milktee.mapper.orderMp;
import top.jokeme.milktee.service.orderinfo.refund;
import top.jokeme.milktee.utils.NTime;

@Service
@SuppressWarnings("ALL")
public class refundImpl implements refund {
    @Autowired
    private orderMp orderMp;

    @Autowired
    private milkteaMp milkteaMp;

    @Override
    public toVueSingleData refundbyid(String ouid) {
        Logger logger = LoggerFactory.getLogger(getClass());
        toVueSingleData<Integer> tvj = new toVueSingleData<>("/refund");

        QueryWrapper qw = new QueryWrapper<>();
        orderinfo odif = null;
        try {

            qw.eq("ouid",ouid);
             odif = orderMp.selectOne(qw);

            odif.setRefund((byte) 1);
            odif.setRefund_time(new NTime().getNowTime());

            UpdateWrapper up = new UpdateWrapper<>();
            up.eq("ouid",ouid);

            orderMp.update(odif,up);
        } catch (Exception e) {
            tvj.setErrorStatus(true);
            tvj.setMsg("oops! something went wrong");
            tvj.setSingleDate(0);
            logger.error("Run error! check mysql execute status...");
            return tvj;
        }

        tvj.oneKeyOk();
        tvj.setSingleDate(1);
        return tvj;
    }
}
