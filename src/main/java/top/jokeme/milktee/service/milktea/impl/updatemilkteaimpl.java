package top.jokeme.milktee.service.milktea.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.milktea;
import top.jokeme.milktee.entity.samplemilktea;
import top.jokeme.milktee.entity.general.toVueMultiData;
import top.jokeme.milktee.mapper.milkteaMp;
import top.jokeme.milktee.service.milktea.getmilkteainfo;
import top.jokeme.milktee.service.milktea.updatemilktea;
import top.jokeme.milktee.utils.toOriginal;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/10/1
 **/
@SuppressWarnings("ALL")
@Service
public class updatemilkteaimpl implements updatemilktea {

    @Autowired
    private milkteaMp milkteaMp;

    @Autowired
    private getmilkteainfo getmilkteainfo;


    /*
     * 这种方法最简单了，直接把前端传过来的 samplemilktea 类型
     * 用 toOriginal类的 toOriginalMilkTea()方法还原一下，
     * 就可以了直接 update 整个类的做法更新数据库。
     * */
    @Override
    public toVueMultiData updatemilkteabyguid(samplemilktea samplemilktea) {
        toVueMultiData<String> tvj = new toVueMultiData<>("/updatemilktea");
        Logger logger = LoggerFactory.getLogger(getClass());

        QueryWrapper qw = new QueryWrapper();
        qw.eq("guid", samplemilktea.getGuid());

        milktea tmp;
        milktea mt;
        try {
            tmp = milkteaMp.selectOne(qw);
            logger.info(samplemilktea.toString());
            mt = new toOriginal().getOriginalMilkTea(samplemilktea);
            mt.setCreate_date(tmp.getCreate_date());
            try {
                Integer x = milkteaMp.update(mt, qw);
                if (x == 1) {
                    logger.info("Update milktea by guid");
                    tvj.oneKeyOk();
                    return tvj;
                } else {
                    logger.warn("Update milktea error");
                }
            } catch (Exception e) {
                logger.error("Mysql update error.Does mysql is running?");
            }
        } catch (Exception e) {
            logger.error("Mysql select all error.Does mysql is running?");
        }
        logger.error("update milktea error!");
        tvj.setErrorStatus(true);
        tvj.setMsg("服务器内部错误!请联系管理员处理");
        return tvj;
    }
}
