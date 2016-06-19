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
        String id = message.getId();
        String flag = message.getClientFlag();
        int status = occupyMachineService.occupy(id, message.getType(), flag);
        String occupant = "";
        if(status > 0){
            occupant = occupyMachineService.getOccupant(flag);
        }
        String resultMsg = "[" + occupant + "][" + occupyMachineService.getOccupyMsg(id) + "][" + OccupyResult.getMsg(status) + "]";
        return new OccupyResponse((status > 0 ? 200 : 500), resultMsg, id, message.getType(), occupant);
    }

}
