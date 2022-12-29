package top.jokeme.milktee.service.orderinfo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.orderinfo;
import top.jokeme.milktee.mapper.orderMp;
import top.jokeme.milktee.service.orderinfo.getOrderByOuid;
import top.jokeme.milktee.utils.NTime;

import java.util.HashMap;
import java.util.Map;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/11/25
 **/

@Service
@SuppressWarnings("ALL")
public class getOrderByOuidImpl implements getOrderByOuid {

    @Autowired
    private orderMp orderMp;

    @Override
    public Map getOrderInfoByOuid(String ouid) {

        QueryWrapper qw  = new QueryWrapper<>();
        qw.eq("ouid",ouid);

        orderinfo orderinfo = orderMp.selectOne(qw);
        Map map = new HashMap<>();
        map.put("ntime",new NTime().getNowTime());
        map.put("ouid",orderinfo.getOuid());
        map.put("create_time",orderinfo.getOrder_time());
        map.put("money",orderinfo.getMoney());
        map.put("content",orderinfo.getOrder_detail());
        return map;
    }
}
