package top.jokeme.milktee.utils;

import java.util.Date;
import java.util.Random;
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
    final private int x(){
        Double x = Math.random()*100000000;
        return x.intValue();
    }

    final private Integer y(){
        Random random = new Random();
        return random.nextInt(36);
    }

    public String mediumuuid(){
        String [] strary = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String x = "";
        for(int tmp = 0;tmp<16;tmp++){
            x+=strary[y()];
            if ((tmp+1)%4 == 0 && tmp != 15){
                x+="-";
            }
        }
        return x;
    }
}
