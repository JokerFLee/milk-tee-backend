package top.jokeme.milktee.service.cheapcode.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.cheapcode;
import top.jokeme.milktee.entity.cheapcode.codeStatus;
import top.jokeme.milktee.entity.general.toVueSingleData;
import top.jokeme.milktee.mapper.cheapcodeMp;
import top.jokeme.milktee.service.cheapcode.cheapCodeManage;



@Service
@SuppressWarnings("ALL")
public class cheapCodeManageImpl implements cheapCodeManage {
    @Autowired
    private cheapcodeMp cheapcodeMp;
    @Override
    public toVueSingleData generateCode() {
        return null;
    }

    @Override
    public toVueSingleData checkCode(String code) {
        Logger logger = LoggerFactory.getLogger(getClass());
        toVueSingleData<codeStatus> tvj = new toVueSingleData("/checkcode");

        logger.info("Checking if the user's cheapcode is available");
        QueryWrapper qw = new QueryWrapper<>();
        qw.eq("code",code);
        cheapcode cp = null;
        codeStatus codeStatus = new codeStatus();
        try{

            cp = cheapcodeMp.selectOne(qw);
            if (cp == null){
                codeStatus.notOkay();
            }else{
                codeStatus.okay();
                codeStatus.setContent(Double.parseDouble(cp.getContent()));
                codeStatus.setType(cp.getType());
            }
            tvj.oneKeyOk();
            tvj.setSingleDate(codeStatus);
        }catch (Exception e){
            logger.error("Mysql select all error.Does mysql is running?");
            tvj.setErrorStatus(true);
            tvj.setMsg("服务器内部错误!请联系管理员处理");
        }
        return tvj;
    }
}
