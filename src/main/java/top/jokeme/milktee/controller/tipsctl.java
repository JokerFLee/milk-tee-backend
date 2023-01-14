package top.jokeme.milktee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.jokeme.milktee.service.tips.addtips;
import top.jokeme.milktee.service.tips.deltips;
import top.jokeme.milktee.service.tips.gettips;

import java.util.List;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/25
 **/
@Controller
@SuppressWarnings("ALL")
@CrossOrigin(origins = "*")
public class tipsctl {
    @Autowired
    private addtips addtips;

    @Autowired
    private deltips deltips;

    @Autowired
    private gettips gettips;

    @ResponseBody
    @RequestMapping("addtips")
    public String addtip(String tip) {
        return addtips.addtips(tip);
    }

    @ResponseBody
    @RequestMapping("deltips")
    public String deltip(String tuid) {
        return deltips.deltips(tuid);
    }

    @ResponseBody
    @RequestMapping("gettips")
    public List gettips() {
        return gettips.gettips();
    }

    @ResponseBody
    @RequestMapping("checktip")
    public Boolean gettip(String tip) {
        return gettips.gettips(tip);
    }
}
