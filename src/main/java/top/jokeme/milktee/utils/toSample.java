package top.jokeme.milktee.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import top.jokeme.milktee.dao.milktea;
import top.jokeme.milktee.entity.samplemilktea;

import java.lang.reflect.Type;
import java.util.List;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/30
 **/
public class toSample {
    public samplemilktea getsamplemilktea(milktea mt) {

        samplemilktea samplemilktea = new samplemilktea();

        samplemilktea.setDiscount(mt.getDiscount());
        samplemilktea.setIntro(mt.getIntro());
        samplemilktea.setName(mt.getName());
        samplemilktea.setPicurl(mt.getPicurl());
        samplemilktea.setSeries(mt.getSeries());
        Gson gson = new Gson();
        Type listType = new TypeToken<List<String>>() {}.getType();//使用匿名内部类的方式指定泛型类型
        samplemilktea.setTips(gson.fromJson(mt.getTips(),listType));
        samplemilktea.setPrice(mt.getPrice());
        samplemilktea.setSoldout(mt.getSoldout());
        samplemilktea.setGuid(mt.getGuid());

        return samplemilktea;
    }
}
