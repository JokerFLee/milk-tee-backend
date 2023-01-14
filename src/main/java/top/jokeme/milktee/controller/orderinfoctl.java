package top.jokeme.milktee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import top.jokeme.milktee.entity.OrderContent;
import top.jokeme.milktee.service.orderinfo.getOrderByOuid;
import top.jokeme.milktee.service.orderinfo.orderGenarate;

import java.util.List;
import java.util.Map;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/25
 **/
@SuppressWarnings("ALL")
@Controller
@CrossOrigin(origins = "*")
public class orderinfoctl {

    @Autowired
    private orderGenarate orderGenarate;

    @Autowired
    private getOrderByOuid getOrderByOuid;

    @ResponseBody
    @PostMapping("generateorder")
    public String generateOrder( @RequestBody List<OrderContent> moc){
        return orderGenarate.orderGenarate(moc);
    }

    @ResponseBody
    @RequestMapping("getorderinfobyouid")
    public Map getOrderInfoByOuid(String ouid){
        return getOrderByOuid.getOrderInfoByOuid(ouid);
    }
}
