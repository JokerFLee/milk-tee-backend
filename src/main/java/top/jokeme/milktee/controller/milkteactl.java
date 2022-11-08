package top.jokeme.milktee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.jokeme.milktee.dao.milkteadiy;
import top.jokeme.milktee.entity.milkteaPrice;
import top.jokeme.milktee.entity.samplemilktea;
import top.jokeme.milktee.service.milktea.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/19
 **/

@Controller
@CrossOrigin(origins = "*")
public class milkteactl {

    @Autowired
    private addmilktea addmilktea;

    @Autowired
    private uploadpic uploadpic;

    @Autowired
    private getmilkteainfo getmilkteainfo;

    @Autowired
    private updatemilktea updatemilktea;

    @Autowired
    private delMilkTea delMilkTea;

    @Autowired
    private getMilkteaCount getMilkteaCount;

    @Autowired
    private modifyMilkteaDIY modifyMilkteaDIY;

    @Autowired
    private countPrice countPrice;

    @ResponseBody
    @PostMapping("addmilktea")
    public Integer add_a_milktea(@RequestBody Map map) {
        return addmilktea.addmilktee(map);
    }

    @ResponseBody
    @PostMapping("uploadpic")
    public Map<String, String> uploadpicture(@RequestParam("file") MultipartFile file) throws IOException {
        return uploadpic.uploadpicture(file);
    }

    @ResponseBody
    @PostMapping("modifymilkteadiyparams")
    public String modifymtDIY(@RequestBody milkteadiy mtdiy){
        return modifyMilkteaDIY.modifyMilkteaDIY(mtdiy);
    }

    @ResponseBody
    @RequestMapping("getdiytea")
    public milkteadiy getmilkteadiyinfobyguid(String guid){
        return modifyMilkteaDIY.getbyguid(guid);
    }

    @ResponseBody
    @RequestMapping("getmilktealist")
    public List getallmilktealist(String token) {
        return getmilkteainfo.getmilktealist(token);
    }


    @ResponseBody
    @RequestMapping("checkmilkteaexist")
    public boolean checkMilkteaExistByName(String name) {
        return getmilkteainfo.checkExistByName(name);
    }

    @ResponseBody
    @RequestMapping("getmilkteabyid")
    public samplemilktea getMilkteaDetailInfoByGuid(String guid) {
        return getmilkteainfo.getMilkTeaInfoByGuid(guid);
    }

    @ResponseBody
    @PostMapping("updatemilktea")
    public String updatemilkteabyguid( @RequestBody samplemilktea samplemilktea) {
        return updatemilktea.updatemilkteabuguid(samplemilktea);
    }

    @ResponseBody
    @RequestMapping("updteacolumemilktea")
    public String updateacolumemilkteabyguid(String guid, String colume, String value) {
        return updatemilktea.updateonecolume(guid, colume, value);
    }
    @ResponseBody
    @RequestMapping("delmilktea")
    public String delmilkteabyguid(String guid) {
        return delMilkTea.delMilkByGuid(guid);
    }

    @ResponseBody
    @RequestMapping("getdescmilktealist")
    public List getsamplemilktealist(){
        return getmilkteainfo.getDescSampleTeaList();
    }

    @ResponseBody
    @RequestMapping("getmilkteacount")
    public Map getmilkteaCount(){
        return getMilkteaCount.getMilkteaSeriesCount();
    }

    @ResponseBody
    @PostMapping("getMilkteaPriceCount")
    public String getMilktePriceCount( @RequestBody milkteaPrice[] list){
        return countPrice.countMilkteaPrice(list);
    }
}
