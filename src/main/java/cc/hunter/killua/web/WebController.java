package cc.hunter.killua.web;

import cc.hunter.killua.domain.OccupyInfo;
import cc.hunter.killua.service.OccupyMachineService;
import cc.hunter.killua.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/15.
 */

@Controller
public class WebController {

    private static final String[] ips = new String[] { "10.10.10.12", "10.10.10.31", "10.10.10.47", "10.10.10.99", "10.10.10.100",
            "10.10.10.136", "10.10.10.190" };
    private static final String[] projects = new String[]{"website", "baseweb2008", "wapsite", "mobileapi", "business", "bsm"};

    @Autowired
    private OccupyMachineService occupyMachineService;

    @RequestMapping("/")
    public String index(HttpServletRequest request, Model model) {

        model.addAttribute("ips", ips);
        model.addAttribute("projects", projects);

        String ip = RequestUtil.getIpAddr(request);
        model.addAttribute("thizIp", ip);

        return "machines";
    }

    @RequestMapping(value="/flushState", method = {RequestMethod.GET})
    @ResponseBody
    public Map<String, OccupyInfo> flushState(HttpServletRequest request, HttpServletResponse response, Model model) {
       return occupyMachineService.getOccupyInfoMap();
    }

}
