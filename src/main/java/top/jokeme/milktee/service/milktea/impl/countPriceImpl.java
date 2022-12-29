package top.jokeme.milktee.service.milktea.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.cheapcode;
import top.jokeme.milktee.dao.milktea;
import top.jokeme.milktee.entity.milkteaPrice;
import top.jokeme.milktee.mapper.cheapcodeMp;
import top.jokeme.milktee.mapper.milkteaMp;
import top.jokeme.milktee.service.milktea.countPrice;


/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/11/8
 **/

@Service
public class countPriceImpl implements countPrice {

    @Autowired
    private milkteaMp milkteaMp;

    @Autowired
    private cheapcodeMp cheapcodeMp;

    @Override
    public String countMilkteaPrice(milkteaPrice[] list) {

        Logger logger = LoggerFactory.getLogger(getClass());

        QueryWrapper<milktea> qw = new QueryWrapper<>();

        double sum = 0.0;
        for (milkteaPrice mt : list) {
            qw.clear();
            qw.eq("guid", mt.getGuid());
            try {
                milktea amt = milkteaMp.selectOne(qw);
                sum += amt.getPrice() * amt.getDiscount() * mt.getNumber();
                logger.info("name: " + amt.getName() + ",price: " + amt.getPrice() + ",discount: " + amt.getDiscount() +",number:"+mt.getNumber()+",sum price:"+sum);
            } catch (Exception e) {
                logger.error("querry within error " + e);
                return "-1";
            }
        }

        return String.format("%.2f",sum);
    }

    @Override
    public String countMilkteaPriceWithCheapCode(milkteaPrice[] list, String cheapcode) {
        Logger logger = LoggerFactory.getLogger(getClass());

        QueryWrapper<milktea> qw = new QueryWrapper<>();
        double sum = 0.0;
        for (milkteaPrice mt : list) {
            qw.clear();
            qw.eq("guid", mt.getGuid());
            try {
                milktea amt = milkteaMp.selectOne(qw);
                sum += amt.getPrice() * amt.getDiscount() * mt.getNumber();
                logger.info("name: " + amt.getName() + ",price: " + amt.getPrice() + ",discount: " + amt.getDiscount() +",number:"+mt.getNumber()+",sum price:"+sum);
            } catch (Exception e) {
                logger.error("querry within error " + e);
                return "-1";
            }
        }

        QueryWrapper<cheapcode> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code",cheapcode);
        cheapcode n = null;
        try {
            n = cheapcodeMp.selectOne(queryWrapper);
        }catch (Exception e){
            logger.error("querry error!"+e);
        }
        if (n.getUsed() == 1){
            logger.info("cheapcode has already used!");
        }else{
            if (n.getType() == 0 ){
                sum -= Double.parseDouble(n.getContent());
            }else if (n.getType() == 1){
                sum *= Double.parseDouble(n.getContent());
            }
        }

        return String.format("%.2f",sum);
    }
}
