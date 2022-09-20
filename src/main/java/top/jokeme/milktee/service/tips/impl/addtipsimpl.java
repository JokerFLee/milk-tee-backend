package top.jokeme.milktee.service.tips.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.tips;
import top.jokeme.milktee.mapper.tipsMp;
import top.jokeme.milktee.service.tips.addtips;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/20
 **/
@SuppressWarnings("ALL")
@Service
public class addtipsimpl implements addtips {

    @Autowired
    private tipsMp tipsMp;

    @Override
    public String addtips(String tips) {
        tips tip = new tips();
        tip.setName(tips);
        tip.setTuid(null);
        Integer x = tipsMp.insert(tip);
        if (x == 1){
            return "200 ok";
        }
        return "error";
    }
}
