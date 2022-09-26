package top.jokeme.milktee.utils;

import java.util.UUID;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/20
 **/

public class uuid {
    public String generateuuid(){
        return String.valueOf(UUID.randomUUID());
    }

    public Integer shortuuid(){
        Integer x = x();
        while (x<10000000){
            x=x();
        }
        return x;
    }
    public int x(){
        Double x = Math.random()*100000000;
        return x.intValue();
    }
}
