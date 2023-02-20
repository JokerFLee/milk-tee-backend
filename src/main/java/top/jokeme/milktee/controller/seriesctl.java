package top.jokeme.milktee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.jokeme.milktee.entity.general.toVueMultiData;
import top.jokeme.milktee.service.series.addseries;
import top.jokeme.milktee.service.series.delseries;
import top.jokeme.milktee.service.series.getseries;

/**
 * project_name: milk-tee
 * author:       frelon
 * date:         2022/9/25
 **/
@Controller
@SuppressWarnings("ALL")
@CrossOrigin(origins = "*")
public class seriesctl {

    @Autowired
    private addseries addseries;

    @Autowired
    private delseries delseries;

    @Autowired
    private getseries getseries;

    @ResponseBody
    @RequestMapping("addseries")
    public String addseries(String series) {
        return addseries.addseries(series);
    }

    @ResponseBody
    @RequestMapping("delseries")
    public String delseries(String suid) {
        return delseries.delseries(suid);
    }

    @ResponseBody
    @RequestMapping("checkseries")
    public Boolean getseriesbyname(String seriesname) {
        return getseries.getseriesbyname(seriesname);
    }

    @ResponseBody
    @RequestMapping("getallseries")
    public toVueMultiData getallseries() {
        return getseries.getallseries();
    }
}
