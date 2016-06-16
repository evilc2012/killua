package cc.hunter.killua.service.impl;

import cc.hunter.killua.constants.MachineConstants;
import cc.hunter.killua.domain.OccupyInfo;
import cc.hunter.killua.service.OccupyMachineService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Created by Administrator on 2016/6/15.
 */

@Service
public class OccupyMachineServiceImpl implements OccupyMachineService {

    private Map<String, OccupyInfo> occupyInfoMap = new HashMap<String, OccupyInfo>();

    @Override
    public int occupy(String id, int type, String ip) {
        boolean result = operate(id, type, ip);
        return result ? type : -type;
    }

    @Override
    public Map<String, OccupyInfo> getOccupyInfoMap() {
        return occupyInfoMap;
    }

    @Override
    public String getOccupant(String clientFlag) {
        if (MachineConstants.userInfos.containsKey(clientFlag)){
            return MachineConstants.userInfos.get(clientFlag);
        }
        return clientFlag;
    }

    @Override
    public String getOccupyMsg(String id) {
        if(id.contains("_")){
            String[] indexs = id.split("_");
            int projectIndex = NumberUtils.toInt(indexs[0]);
            int ipIndex = NumberUtils.toInt(indexs[1]);
            return MachineConstants.projects[projectIndex] + " " + MachineConstants.ips[ipIndex];
        }
        return "";
    }

    private synchronized boolean operate(String id, int type, String ip){
        if(id == null || id.trim().isEmpty()){
            return false;
        }

        boolean result = false;

        if (type == 2 || type == 3){
            OccupyInfo info = occupyInfoMap.get(id);
            if(info == null){
                info = new OccupyInfo(ip, getOccupant(ip), type);
                occupyInfoMap.put(id, info);
                result = true;
            }
        } else if(type == 1){
            OccupyInfo info = occupyInfoMap.get(id);
            if(info != null && ip.equals(info.getIp())){
                occupyInfoMap.remove(id);
                result = true;
            }
        }
        return result;
    }
}
