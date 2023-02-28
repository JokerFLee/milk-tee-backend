package top.jokeme.milktee.service.milktea.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.milkteadiy;
import top.jokeme.milktee.entity.general.toVueMultiData;
import top.jokeme.milktee.mapper.milkteadiyMp;
import top.jokeme.milktee.service.milktea.modifyMilkteaDIY;

import java.util.ArrayList;
import java.util.List;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/10/27
 **/

@Service
@SuppressWarnings("ALL")
@Deprecated
public class modifyMilkteaDIYimpl implements modifyMilkteaDIY {

    @Autowired
    private milkteadiyMp milkteadiyMp;

    /**
     * 更新奶茶口味的接口,当检测到存在就更新,没有就创建
     */
    @Override
    public toVueMultiData modifyMilkteaDIY(milkteadiy mtdiy) {
        toVueMultiData tvj = new toVueMultiData<>("modifymilkteadiyparams");
        Logger logger = LoggerFactory.getLogger(getClass());

        logger.info(mtdiy.toString());

        QueryWrapper qw = new QueryWrapper<>().eq("guid", mtdiy.getGuid());

        try {
            boolean x = milkteadiyMp.exists(qw);
            UpdateWrapper updateWrapper = new UpdateWrapper<>().eq("guid", mtdiy.getGuid());
            if (x == true) {
                try {
                    // exist -> modify
                    int n = milkteadiyMp.update(mtdiy, updateWrapper);
                    if (n == 1) {
                        tvj.oneKeyOk();
                        logger.info("update diy milktea info success");
                        return tvj;
                    }
                } catch (Exception e) {
                    logger.error("Mysql update error.Does mysql is running?");
                }
            } else {
                // not exist -> create it
                try {
                    if (milkteadiyMp.insert(mtdiy) == 1) {
                        logger.info("Try to update the not existed record, created it success! ");
                        tvj.oneKeyOk();
                        return tvj;
                    }
                } catch (Exception e) {
                    logger.error("Try to update the not existed record, created it error!");
                }

            }
        } catch (Exception e) {
            logger.error("Mysql querry exist error.Does mysql is running?");
        }

        tvj.setErrorStatus(true);
        tvj.setMsg("更新数据出错!");
        return tvj;
    }

    @Override
    public toVueMultiData getbyguid(String guid) {
        toVueMultiData<milkteadiy> tvj = new toVueMultiData<>("/getdiytea");
        Logger logger = LoggerFactory.getLogger(getClass());
        logger.info("get milktea diy info by guid " + guid);
        QueryWrapper qw = new QueryWrapper<>().eq("guid", guid);
        try {
            List<milkteadiy> list = new ArrayList<>();
            list.add(milkteadiyMp.selectOne(qw));
            tvj.oneKeyOk();
            tvj.setDataList(list);
            logger.info("Querry DIY info success!!");
        } catch (Exception e) {
            logger.error("Mysql select one error.Does mysql is running?");
            tvj.setErrorStatus(true);
            tvj.setMsg("服务器内部错误!请联系管理员处理");
        }
        return tvj;
    }
}
