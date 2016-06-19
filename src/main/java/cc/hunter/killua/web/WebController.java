package cc.hunter.killua.web;

import cc.hunter.killua.constants.MachineConstants;
import cc.hunter.killua.domain.OccupyInfo;
import cc.hunter.killua.entity.KilluaUser;
import cc.hunter.killua.service.OccupyMachineService;
import cc.hunter.killua.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    private OccupyMachineService occupyMachineService;

    @RequestMapping("/")
    public String root(){
        return "index";
    }

    @RequestMapping("/index")
    public String machines(HttpServletRequest request, Model model) {

        SecurityContext sc = SecurityContextHolder.getContext();
        Authentication auth = sc.getAuthentication();
        KilluaUser user = (KilluaUser) auth.getPrincipal();

        model.addAttribute("realname", user.getRealname());

        model.addAttribute("ips", MachineConstants.ips);
        model.addAttribute("projects", MachineConstants.projects);

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
