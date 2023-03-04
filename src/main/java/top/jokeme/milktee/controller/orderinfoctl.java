package top.jokeme.milktee.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import top.jokeme.milktee.entity.general.toVueMultiData;
import top.jokeme.milktee.entity.orderinfo.OrderContent;
import top.jokeme.milktee.service.orderinfo.getOrderByOuid;
import top.jokeme.milktee.service.orderinfo.getOrderPage;
import top.jokeme.milktee.service.orderinfo.manageOrder;
import top.jokeme.milktee.service.orderinfo.orderGenarate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/25
 **/
@SuppressWarnings("ALL")
@RestController
@CrossOrigin(origins = "*")
public class orderinfoctl {

    @Autowired
    private orderGenarate orderGenarate;

    @Autowired
    private getOrderByOuid getOrderByOuid;

    @Autowired
    private manageOrder manageOrder;

    @Autowired
    private getOrderPage getOrderPage;

    @ResponseBody
    @PostMapping("generateorder")
    public toVueMultiData generateOrder(@RequestBody HashMap<String,Integer> moc,@RequestParam("money") String money){
        return orderGenarate.orderGenarate(moc,money);
    }

    @ResponseBody
    @RequestMapping("getorderinfobyouid")
    public Map getOrderInfoByOuid(String ouid){
        return getOrderByOuid.getOrderInfoByOuid(ouid);
    }

    @ResponseBody
    @RequestMapping("delCancelOrder")
    public boolean delCancelOrder(String ouid){
        return manageOrder.delOrder(ouid);
    }
    @ResponseBody
    @RequestMapping("payOrder")
    public boolean pay(String payMethod,String ouid){
        return manageOrder.pay(payMethod,ouid);
    }

    @ResponseBody
    @RequestMapping("getOrderPage")
    public toVueMultiData getOrderPage(Integer page,Integer size){
        System.out.println(page+" "+size);
        return getOrderPage.getOrderPageList(new Page<>(page,size));
    }

}
