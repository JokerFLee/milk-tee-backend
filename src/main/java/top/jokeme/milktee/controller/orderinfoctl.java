package top.jokeme.milktee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.jokeme.milktee.service.orderinfo.getOrderInfo;

import java.util.List;

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
    private getOrderInfo getOrderInfo;

    @ResponseBody
    @RequestMapping("getorderinfo")
    public List getOrderInfo(String token) {
        return getOrderInfo.getOrderInfo(token);
    }
}
