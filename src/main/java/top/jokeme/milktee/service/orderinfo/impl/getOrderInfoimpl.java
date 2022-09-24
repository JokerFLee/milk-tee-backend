package top.jokeme.milktee.service.orderinfo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.orderinfo;
import top.jokeme.milktee.mapper.orderMp;
import top.jokeme.milktee.service.orderinfo.getOrderInfo;

import java.util.List;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/19
 **/
@Service
public class getOrderInfoimpl implements getOrderInfo {

    @Autowired
    private orderMp orderMp;

    @Override
    public List getOrderInfo(String token) {
        List<orderinfo> list =  orderMp.selectList(null);
        return list;
    }
}
