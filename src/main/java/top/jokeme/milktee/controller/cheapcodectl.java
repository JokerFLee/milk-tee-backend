package top.jokeme.milktee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.jokeme.milktee.entity.general.toVueSingleData;
import top.jokeme.milktee.service.cheapcode.cheapCodeManage;

@RestController
@CrossOrigin(origins = "*")
public class cheapcodectl {

    @Autowired
    private cheapCodeManage cheapCodeManage;

    @ResponseBody
    @RequestMapping("checkcode")
    public toVueSingleData check(String code){
        return cheapCodeManage.checkCode(code);
    }
}
