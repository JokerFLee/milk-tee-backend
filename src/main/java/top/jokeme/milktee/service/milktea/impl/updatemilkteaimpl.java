package top.jokeme.milktee.service.milktea.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.milktea;
import top.jokeme.milktee.entity.samplemilktea;
import top.jokeme.milktee.entity.toVueJson;
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
    public toVueJson updatemilkteabyguid(samplemilktea samplemilktea) {
        toVueJson<String> tvj = new toVueJson<>("/updatemilktea");
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


    /*
     * guid 唯一标识
     * colume milktea的某一个的字段名
     * value 表示想把 colume 的值改为这个新的值: value
     *
     * 1.这种方法首先是 利用前端传过来的 guid 字段的值，获取到数据库里面相应字段所对应的记录，
     *   并包装成 milktea类。返回数据库中该记录的所有字段以及对应的值。
     *
     * 2.调用 UpdateWrapper类 继承的 eq() set() 方法，并将 参数 colume 所记录的字段对应的 参数修改为 value 。
     *
     * 3.然后就用 update() 方法更新milktea
     * */
    @Override
    public toVueJson updateonecolume(String guid, String colume, String value) {

        toVueJson tvj = new toVueJson<>("/updteacolumemilktea");
        Logger logger = LoggerFactory.getLogger(getClass());


        try {
            milktea mt = getmilkteainfo.getRealMilkTeaByGuid(guid);
            UpdateWrapper<milktea> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("guid", guid).set(colume, value);

            try {
                int x = milkteaMp.update(mt, updateWrapper);
                if (x == 1) {
                    logger.info("Update guid :" + guid + ", colume : " + colume + ", value : " + value + ". Success!");
                    tvj.oneKeyOk();
                    return tvj;
                }
            } catch (Exception e) {
                logger.error("Mysql update error.Does mysql is running?");
            }
        } catch (Exception e) {
            logger.error("Mysql select one error.Does mysql is running?");
        }
        tvj.setErrorStatus(true);
        tvj.setMsg("服务器内部错误!请联系管理员处理");
        return tvj;
    }
}
