package top.jokeme.milktee;

import org.junit.Test;
import top.jokeme.milktee.utils.NTime;
import top.jokeme.milktee.utils.uuid;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/28
 **/
public class test {
    @Test
    public void ss(){
        NTime nt = new NTime();
        uuid uuid = new uuid();
        System.out.println(nt.getNowTime()+" " +nt.getShortTime()+" "+uuid.shortuuid()+" "+uuid.generateuuid()+" "+uuid.mediumuuid());
    }
}
