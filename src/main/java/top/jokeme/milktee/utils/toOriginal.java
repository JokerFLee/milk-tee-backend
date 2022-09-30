package top.jokeme.milktee.utils;

import top.jokeme.milktee.dao.milktea;
import top.jokeme.milktee.entity.samplemilktea;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/10/1
 **/

public class toOriginal {
    public milktea toOriginalMilkTea(samplemilktea samplemilktea){
        milktea mt = new milktea();
        mt.setGuid(samplemilktea.getGuid());
        mt.setName(samplemilktea.getName());
        mt.setPrice(samplemilktea.getPrice());
        mt.setSoldout(samplemilktea.getSoldout());
        mt.setDiscount(samplemilktea.getDiscount());
        mt.setPicurl(samplemilktea.getPicurl());
        mt.setIntro(samplemilktea.getIntro());
        mt.setTips(samplemilktea.getTips());
        mt.setSeries(samplemilktea.getSeries());
        return mt;
    }
}
