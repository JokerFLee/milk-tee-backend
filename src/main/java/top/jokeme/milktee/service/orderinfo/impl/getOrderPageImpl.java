package top.jokeme.milktee.service.orderinfo.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.orderinfo;
import top.jokeme.milktee.entity.general.toVueMultiData;
import top.jokeme.milktee.mapper.orderMp;
import top.jokeme.milktee.service.orderinfo.getOrderPage;

import java.util.List;

@Service
@SuppressWarnings("ALL")
public class getOrderPageImpl implements getOrderPage {

    @Autowired
    private orderMp orderMp;

    @Override
    public toVueMultiData getOrderPageList(Integer page,Integer size) {
        toVueMultiData<orderinfo> tvj = new toVueMultiData<>("/getOrderPageList");
        Logger logger = LoggerFactory.getLogger(getClass());

        QueryWrapper qw = new QueryWrapper<>();
        qw.orderByDesc("order_time");
        qw.eq("isdel",0);

        IPage<orderinfo> thispage = new Page<>(page,size);
        IPage<orderinfo> ipg = orderMp.selectPage(thispage,qw);

        List<orderinfo> list = ipg.getRecords();

        tvj.setDataList(list);
        tvj.setErrorStatus(false);
        tvj.setMsg(String.valueOf(ipg.getTotal()));
        return tvj;
    }
}
