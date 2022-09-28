package top.jokeme.milktee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.jokeme.milktee.service.milktee.addmilktea;
import top.jokeme.milktee.service.milktee.uploadpic;

import java.io.IOException;
import java.util.Map;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/19
 **/

@SuppressWarnings("ALL")
@Controller
@CrossOrigin(origins = "*")
public class milkteectl {

    @Autowired
    private addmilktea addmilktea;

    @Autowired
    private uploadpic uploadpic;

    @ResponseBody
    @PostMapping("addmilktea")
    public Integer add_a_milktea(@RequestBody Map map){
        return addmilktea.addmilktee(map);
    }

    @ResponseBody
    @PostMapping("uploadpic")
    public Map<String, String> uploadpicture(@RequestParam("file") MultipartFile file) throws IOException {
        return uploadpic.uploadpicture(file);
    }


}
