package top.jokeme.milktee.service.milktea.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.jokeme.milktee.dao.cheapcode;
import top.jokeme.milktee.dao.milktea;
import top.jokeme.milktee.entity.milktea.milkteaPrice;
import top.jokeme.milktee.entity.general.toVueSingleData;
import top.jokeme.milktee.mapper.cheapcodeMp;
import top.jokeme.milktee.mapper.milkteaMp;
import top.jokeme.milktee.service.milktea.countPrice;


/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/11/8
 **/

@Service
@SuppressWarnings("ALL")
public class countPriceImpl implements countPrice {

    @Autowired
    private milkteaMp milkteaMp;

    @Autowired
    private cheapcodeMp cheapcodeMp;

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public toVueSingleData countMilkteaPrice(milkteaPrice[] list) {
        toVueSingleData<String> tvj = new toVueSingleData("/getMilkteaPriceCount");
        QueryWrapper<milktea> qw = new QueryWrapper<>();
        double sum = 0.0;
        for (milkteaPrice mt : list) {
            qw.clear();
            qw.eq("guid", mt.getGuid());
            try {
                milktea amt = milkteaMp.selectOne(qw);
                sum += amt.getPrice() * amt.getDiscount() * mt.getNumber();
                tvj.oneKeyOk();
                tvj.setSingleDate(String.format("%.2f", sum));
                logger.info("name: " + amt.getName() + ",price: " + amt.getPrice() + ",discount: " + amt.getDiscount() + ",number:" + mt.getNumber() + ",sum price:" + sum);
            } catch (Exception e) {
                logger.error("querry within error " + e);
                tvj.setErrorStatus(true);
                tvj.setMsg("查询出错!");
                tvj.setSingleDate(null);
            }
        }
        return tvj;
    }

    @Override
    public toVueSingleData countMilkteaPriceWithCheapCode(milkteaPrice[] list, String cheapcode) {

        toVueSingleData<String> tvj = new toVueSingleData<>("/getMilkteaPriceCountwithcheapcode");

        QueryWrapper<milktea> qw = new QueryWrapper<>();


        double sum = 0.0;
        for (milkteaPrice mt : list) {
            qw.clear();
            qw.eq("guid", mt.getGuid());
            try {
                milktea amt = milkteaMp.selectOne(qw);
                sum += amt.getPrice() * amt.getDiscount() * mt.getNumber();
                logger.info("name: " + amt.getName() + ",price: " + amt.getPrice() + ",discount: " + amt.getDiscount() + ",number:" + mt.getNumber() + ",sum price:" + sum);
            } catch (Exception e) {
                logger.error("querry within error " + e);
                tvj.setMsg("查询出错!");
                tvj.setErrorStatus(true);
                return tvj;
            }
        }

        QueryWrapper<cheapcode> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("code", cheapcode);
        cheapcode n = null;
        try {
            n = cheapcodeMp.selectOne(queryWrapper);
        } catch (Exception e) {
            logger.error("querry error!" + e);
            tvj.setMsg("此优惠码无效!");
            tvj.setErrorStatus(true);
            return tvj;
        }
        if (n.getUsed() == 1) {
            logger.info("cheapcode has already used!");
            tvj.setMsg("优惠码已使用");
            tvj.setErrorStatus(true);
            return tvj;
        } else {
            if (n.getType() == 0) {
                sum -= Double.parseDouble(n.getContent());
            } else if (n.getType() == 1) {
                sum *= Double.parseDouble(n.getContent());
            }
        }
        tvj.oneKeyOk();
        tvj.setSingleDate(String.format("%.2f", sum));
        return tvj;
    }
}
