package top.jokeme.milktee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.jokeme.milktee.service.milktee.addnewtee;

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
    private addnewtee addnewtee;

    @ResponseBody
    @PostMapping("addnewtee")
    public Integer addnewmilktee(@RequestBody Map map){
        return addnewtee.addnewmilktee(map);
    }


}
