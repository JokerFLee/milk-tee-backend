package top.jokeme.milktee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.jokeme.milktee.dao.tips;
import top.jokeme.milktee.service.milktee.addnewtee;
import top.jokeme.milktee.service.orderinfo.getOrderInfo;
import top.jokeme.milktee.service.tips.addtips;
import top.jokeme.milktee.service.tips.deltips;
import top.jokeme.milktee.service.tips.gettips;

import java.util.List;
import java.util.Map;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/19
 **/

@SuppressWarnings("ALL")
@Controller
@CrossOrigin(origins = "*")
public class mainctl {

    @Autowired
    private getOrderInfo getOrderInfo;

    @Autowired
    private addnewtee addnewtee;

    @Autowired
    private addtips addtips;

    @Autowired
    private deltips deltips;

    @Autowired
    private gettips gettips;

    @ResponseBody
    @RequestMapping("getorderinfo")
    public List getOrderInfo(String token){
        return getOrderInfo.getOrderInfo(token);
    }

    @ResponseBody
    @PostMapping("addnewtee")
    public Integer addnewmilktee(@RequestBody Map map){
        return addnewtee.addnewmilktee(map);
    }

    @ResponseBody
    @RequestMapping("addtips")
    public String addtip(String tip){
        return addtips.addtips(tip);
    }

    @ResponseBody
    @RequestMapping("deltips")
    public String deltip(String tuid){
        return deltips.deltips(tuid);
    }

    @ResponseBody
    @RequestMapping("gettips")
    public List gettips(){
        return gettips.gettips();
    }

    @ResponseBody
    @RequestMapping("checktip")
    public Boolean gettip(String tip){
        return gettips.gettips(tip);
    }
}
