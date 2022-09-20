package top.jokeme.milktee.service.tips.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.mapper.tipsMp;
import top.jokeme.milktee.service.tips.deltips;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/20
 **/
@SuppressWarnings("ALL")
@Service
public class deltipsimpl implements deltips {

    @Autowired
    private tipsMp tipsMp;

    @Override
    public String deltips(String tuid) {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tuid",tuid);
        Integer x = tipsMp.delete(queryWrapper);
        System.out.println(x);
        if (x == 1){
            return "200 ok";
        }
        return "error";
    }
}
