package cc.hunter.killua.web;

import cc.hunter.killua.domain.*;
import cc.hunter.killua.service.OccupyMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 2016/6/15.
 */

@Controller
public class WebSocketController {

    @Autowired
    private OccupyMachineService occupyMachineService;

    @MessageMapping("/occupy")
    @SendTo("/topic/machines")
    public OccupyResponse occupy(OccupyMessage message){
        int status = occupyMachineService.occupy(message.getId(), message.getType(), message.getClientFlag());
        return new OccupyResponse(status > 0 ? 200 : 500, "用户[" + message.getClientFlag() + "]" + OccupyResult.getMsg(status), message.getId(), message.getType());
    }

}
