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
import top.jokeme.milktee.utils.toSample;

import java.util.ArrayList;
import java.util.List;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/30
 **/

@SuppressWarnings("ALL")
@Service
public class getmilkteainfoimpl implements getmilkteainfo {

    @Autowired
    private milkteaMp milkteaMp;

    /*
    * 把查到的所有的milktea -> samplemilktea
    * 然后返回给前端。
    * */
    @Override
    public List<samplemilktea> getmilktealist(String token) {
        Logger logger = LoggerFactory.getLogger(getClass());

        QueryWrapper qw = new QueryWrapper<>();
        qw.orderByDesc("create_date");//倒序 最新的在最前
//        qw.orderByAsc("create_date"); // 正序 最新的在最后

        List<milktea> list = milkteaMp.selectList(qw);
        List<samplemilktea> filist = new ArrayList();

        for (milktea mt : list){
            filist.add(new toSample().getsamplemilktea(mt));
        }
        logger.info("xxx request for all Milktea list");
        return filist;
    }

    /*
    * 接口给前端调用的，所以检查名字是否已经存在
    * */
    @Override
    public boolean checkExistByName(String name) {
        Logger logger = LoggerFactory.getLogger(getClass());
        logger.info("Get request for check the name : "+name+" is exist in milktea. Passed");
        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("name",name);
        return milkteaMp.exists(qw);
    }

    /*
    * 这个方法主要是拿数据给前端用，所以用了 samplemilktea类型。
    * 也返回 samplemilktea类型
    * */
    @Override
    public samplemilktea getMilkTeaInfoByGuid(String guid) {
        Logger logger = LoggerFactory.getLogger(getClass());
        logger.info("{return samplemilktea} Get request to get the detail infomation of guid : "+guid+" in milktea. Passed");
        QueryWrapper qw = new QueryWrapper<>().eq("guid",guid);
        samplemilktea samplemilktea =  new toSample().getsamplemilktea(milkteaMp.selectOne(qw));
        return samplemilktea;
    }

    /*
    * 这个方法只在内部调用，无法通过外部url来触发调用
    * 根据 guid 返回的 milktea 类
    * */
    @Override
    public milktea getRealMilkTeaByGuid(String guid) {
        Logger logger = LoggerFactory.getLogger(getClass());
        logger.info("{return milktea} Get request to get the detail infomation of guid : "+guid+" in milktea. Passed");

        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("guid",guid);

        milktea mk = milkteaMp.selectOne(qw);

        return new milktea();
    }

}
