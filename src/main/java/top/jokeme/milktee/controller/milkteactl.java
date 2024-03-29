package top.jokeme.milktee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.jokeme.milktee.dao.milkteadiy;
import top.jokeme.milktee.entity.*;
import top.jokeme.milktee.entity.general.toVueMultiData;
import top.jokeme.milktee.entity.general.toVueSingleData;
import top.jokeme.milktee.entity.milktea.milkteaMini;
import top.jokeme.milktee.service.milktea.*;

import java.io.IOException;
import java.util.Map;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/19
 **/

//@Controller
@RestController
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
    private modifyMilkteaDIY modifyMilkteaDIY;

    @Autowired
    private countPrice countPrice;

    // 上传奶茶数据接口 接受milkteaMini类对象
    @ResponseBody
    @PostMapping("addmilktea")
    public toVueMultiData add_a_milktea(@RequestBody milkteaMini mtm) {
        return addmilktea.addmilktee(mtm);
    }

    // 上传图片接口
    @ResponseBody
    @PostMapping("uploadpic")
    public Map<String, String> uploadpicture(@RequestParam("file") MultipartFile file) throws IOException {
        return uploadpic.uploadpicture(file);
    }

    // 修改奶茶口味接口
    @Deprecated
    @ResponseBody
    @PostMapping("modifymilkteadiyparams")
    public toVueMultiData modifymtDIY(@RequestBody milkteadiy mtdiy){
        return modifyMilkteaDIY.modifyMilkteaDIY(mtdiy);
    }

    // 获取奶茶可以有那些口味
    @Deprecated
    @ResponseBody
    @RequestMapping("getdiytea")
    public toVueMultiData getmilkteadiyinfobyguid(String guid){
        return modifyMilkteaDIY.getbyguid(guid);
    }

    // 获取奶茶列表
    @ResponseBody
    @RequestMapping("getmilktealist")
    public toVueMultiData getallmilktealist() {
        return getmilkteainfo.getmilktealist();
    }

    // 根据名称检查奶茶是否存在
    @ResponseBody
    @RequestMapping("checkmilkteaexist")
    public toVueSingleData checkMilkteaExistByName(String name) {
        return getmilkteainfo.checkExistByName(name);
    }

    // 根据guid获取奶茶信息
    @ResponseBody
    @RequestMapping("getmilkteabyid")
    public toVueMultiData getMilkteaDetailInfoByGuid(String guid) {
        return getmilkteainfo.getMilkTeaInfoByGuid(guid);
    }

    // 更新(整个)奶茶信息
    @ResponseBody
    @PostMapping("updatemilktea")
    public toVueMultiData updatemilkteabyguid(@RequestBody samplemilktea samplemilktea) {
        return updatemilktea.updatemilkteabyguid(samplemilktea);
    }

    // 删除奶茶
    @ResponseBody
    @RequestMapping("delmilktea")
    public toVueMultiData delmilkteabyguid(String guid) {
        return delMilkTea.delMilkByGuid(guid);
    }

    // 获取排序后的奶茶列表信息
    @ResponseBody
    @RequestMapping("getdescmilktealist")
    public toVueMultiData getsamplemilktealist(){
        return getmilkteainfo.getDescSampleTeaList();
    }

}
