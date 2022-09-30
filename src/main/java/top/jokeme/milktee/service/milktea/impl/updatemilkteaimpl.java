package top.jokeme.milktee.service.milktea.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.milktea;
import top.jokeme.milktee.entity.samplemilktea;
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

    @Override
    public String updatemilkteabuguid(String guid, samplemilktea samplemilktea) {
        /*
        * 这种方法最简单了，直接把前端传过来的 samplemilktea 类型
        * 用 toOriginal类的 toOriginalMilkTea()方法还原一下，
        * 就可以了直接 update 整个类的做法更新数据库。
        * */
        Logger logger = LoggerFactory.getLogger(getClass());

        QueryWrapper qw = new QueryWrapper();
        qw.eq("guid", guid);

        milktea mt = new toOriginal().toOriginalMilkTea(samplemilktea);

        Integer x = milkteaMp.update(mt, qw);
        if (x == 1) {
            logger.info("Update milktea by guid");
            return "200 ok";
        } else {
            logger.warn("Update milktea error");
        }
        return "error";
    }


    @Override
    public String updateonecolume(String guid, String colume, String value) {
        /*
        * guid 唯一标识
        * colume milktea的某一个的字段名
        * value 表示想把 colume 的值改为这个新的值: value
        *
        * 1.这种方法首先是 利用前端传过来的 guid 字段的值，获取到数据库里面相应字段所对应的记录，
        *   并包装成 milktea类。返回数据库中该记录的所有字段以及对应的值。
        *
        * 2.调用 milktea类 自带的 iswhich() 方法，并将 参数 colume 所记录的字段对应的 参数修改为 value 。
        * 执行后返回修改后的 milktea。
        *
        * 3.然后就用 update() 方法更新上面修改后的 milktea类
        * */
        Logger logger = LoggerFactory.getLogger(getClass());

        milktea mt = getmilkteainfo.getMilkTeaInfoByGuid(guid);

        milktea tmp = mt.iswhich(mt,colume,value);

        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("guid", guid);

        milkteaMp.update(tmp,qw);
        return null;
    }
}
