package top.jokeme.milktee.service.milktea.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.milktea;
import top.jokeme.milktee.dao.series;
import top.jokeme.milktee.entity.samplemilktea;
import top.jokeme.milktee.entity.general.toVueMultiData;
import top.jokeme.milktee.entity.general.toVueSingleData;
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
    public toVueMultiData getmilktealist() {
        toVueMultiData<samplemilktea> tvj = new toVueMultiData<>("/getmilktealist");
        Logger logger = LoggerFactory.getLogger(getClass());

        QueryWrapper qw = new QueryWrapper<>();
        qw.orderByDesc("create_date");//倒序 最新的在最前
//        qw.orderByAsc("create_date"); // 正序 最新的在最后
        List<milktea> list = null;
        try {
            list = milkteaMp.selectList(qw);
        } catch (Exception e) {
            logger.error("Mysql select all error.Does mysql is running?");
            tvj.setErrorStatus(true);
            tvj.setMsg("服务器内部错误!请联系管理员处理");
            return tvj;
        }
        List<samplemilktea> filist = new ArrayList();
        for (milktea mt : list) {
            filist.add(new toSample().getsamplemilktea(mt));
        }
        logger.info("request for all Milktea list");
        tvj.oneKeyOk();
        tvj.setDataList(filist);
        return tvj;
    }

    /*
     * 接口给前端调用的，所以检查名字是否已经存在
     * */
    @Override
    public toVueSingleData<Boolean> checkExistByName(String name) {
        toVueSingleData<Boolean> tvj = new toVueSingleData<>("/checkmilkteaexist");
        Logger logger = LoggerFactory.getLogger(getClass());

        logger.info("Get request for check the name : " + name + " is exist in milktea. Passed");
        QueryWrapper qw = new QueryWrapper<>().eq("name", name);
        boolean ex;
        try {
            ex = milkteaMp.exists(qw);
            tvj.oneKeyOk();
            tvj.setSingleDate(true);
        } catch (Exception e) {
            logger.error("Mysql querry exist error.Does mysql is running?");
            tvj.setErrorStatus(true);
            tvj.setMsg("服务器内部错误!请联系管理员处理!");
            tvj.setSingleDate(false);
        }
        return tvj;
    }

    /*
     * 这个方法主要是拿数据给前端用，所以用了 samplemilktea类型。
     * 也返回 samplemilktea类型
     * */
    @Override
    public toVueMultiData getMilkTeaInfoByGuid(String guid) {

        Logger logger = LoggerFactory.getLogger(getClass());
        toVueMultiData<samplemilktea> tvj = new toVueMultiData<>("/getmilkteabyid");

        logger.info("{return samplemilktea} Get request to get the detail infomation of guid : " + guid + " in milktea. Passed");
        QueryWrapper qw = new QueryWrapper<>().eq("guid", guid);
        samplemilktea smt = null;
        try {
            QueryWrapper qwe = new QueryWrapper<>().eq("guid", guid);
            if (!milkteaMp.exists(qwe)) {
                logger.warn("这小子找茬!修改了数据来查一个不存在的数据啊!");
                tvj.setMsg("所查询数据不存在!");
                tvj.setErrorStatus(true);
                return tvj;
            }
            smt = new toSample().getsamplemilktea(milkteaMp.selectOne(qw));
            tvj.oneKeyOk();
            List<samplemilktea> list = new ArrayList<>();
            list.add(smt);
            tvj.setDataList(list);
        } catch (Exception e) {
            logger.error("Mysql select one error.Does mysql is running?");
            tvj.setErrorStatus(true);
            tvj.setMsg("服务器内部错误!请联系管理员处理");
        }
        return tvj;
    }

    @Override
    public toVueMultiData<samplemilktea> getDescSampleTeaList() {
        toVueMultiData<samplemilktea> tvj = new toVueMultiData<>("/getdescmilktealist");
        Logger logger = LoggerFactory.getLogger(getClass());

        logger.info("Request to get all desc milktea list");
        List<milktea> mt = null;
        try {
            mt = milkteaMp.selectAllDescList();

            logger.debug("Succeeded in querying all desc data");

        } catch (Exception e) {

            logger.error("Mysql select all error.Does mysql is running?");
            logger.debug("This is the error message that appears:"+e.toString());

            tvj.setErrorStatus(true);
            tvj.setMsg("服务器内部错误!请联系管理员处理");
            return tvj;
        }
        List list = new ArrayList<>();
        for (milktea tea : mt) {
            list.add(new toSample().getsamplemilktea(tea));
        }
        tvj.oneKeyOk();
        tvj.setDataList(list);
        return tvj;
    }
}
