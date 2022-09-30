package top.jokeme.milktee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.jokeme.milktee.dao.milktea;
import top.jokeme.milktee.entity.samplemilktea;
import top.jokeme.milktee.service.milktea.addmilktea;
import top.jokeme.milktee.service.milktea.getmilkteainfo;
import top.jokeme.milktee.service.milktea.updatemilktea;
import top.jokeme.milktee.service.milktea.uploadpic;

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
    public milktea getMilkteaDetailInfoByGuid(String guid) {
        return getmilkteainfo.getMilkTeaInfoByGuid(guid);
    }

    @ResponseBody
    @RequestMapping("updatemilktea")
    public String updatemilkteabyguid(String guid, samplemilktea samplemilktea) {
        return updatemilktea.updatemilkteabuguid(guid, samplemilktea);
    }

    @ResponseBody
    @RequestMapping("updteacolumemilktea")
    public String updateacolumemilkteabyguid(String guid, String colume, String value) {
        return updatemilktea.updateonecolume(guid, colume, value);
    }
}
