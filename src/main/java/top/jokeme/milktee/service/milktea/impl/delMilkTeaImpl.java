package top.jokeme.milktee.service.milktea.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.entity.general.toVueMultiData;
import top.jokeme.milktee.mapper.milkteaMp;
import top.jokeme.milktee.service.milktea.delMilkTea;



/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/10/2
 **/
@SuppressWarnings("ALL")
@Service
public class delMilkTeaImpl implements delMilkTea {

    @Autowired
    private milkteaMp milkteaMp;

    @Override
    public toVueMultiData delMilkByGuid(String guid) {
        toVueMultiData<String> tvj = new toVueMultiData<>("/delmilktea");

        Logger logger = LoggerFactory.getLogger(getClass());

        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("guid",guid);

        if (milkteaMp.exists(qw)){
            logger.info("Will delete the record : "+milkteaMp.selectOne(qw).toString());
        }else{
            logger.warn("Try to delete a not exist record");
            tvj.setMsg("删除失败!原因:尝试删除不存在的数据");
            tvj.setErrorStatus(true);
            return tvj;
        }
        try {
            milkteaMp.delete(qw);
            logger.info("Delete record success!");
            tvj.setMsg("删除成功!");
            tvj.setErrorStatus(false);
        }catch (Exception e){
            logger.error("Delete record error!");
            tvj.setMsg("删除失败!");
            tvj.setErrorStatus(true);
        }
        return tvj;
    }
}
