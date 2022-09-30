package top.jokeme.milktee.utils;

import top.jokeme.milktee.dao.milktea;
import top.jokeme.milktee.entity.samplemilktea;

import java.util.ArrayList;
import java.util.List;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/30
 **/
public class tosample {
    public List<samplemilktea> tosamplemilktea(List<milktea> list){
        List<samplemilktea> samplemilkteaList = new ArrayList<>();

        for (milktea mt : list){
            samplemilktea samplemilktea = new samplemilktea();
            samplemilktea.setDiscount(mt.getDiscount());
            samplemilktea.setIntro(mt.getIntro());
            samplemilktea.setName(mt.getName());
            samplemilktea.setPicurl(mt.getPicurl());
            samplemilktea.setSeries(mt.getSeries());
            samplemilktea.setTips(mt.getTips());
            samplemilktea.setPrice(mt.getPrice());
            samplemilktea.setSoldout(mt.getSoldout());
            samplemilktea.setGuid(mt.getGuid());
            samplemilkteaList.add(samplemilktea);
        }
        return samplemilkteaList;
    }
}
