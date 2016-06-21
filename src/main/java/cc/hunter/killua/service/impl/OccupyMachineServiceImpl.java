package cc.hunter.killua.service.impl;

import cc.hunter.killua.constants.MachineConstants;
import cc.hunter.killua.context.KilluaContext;
import cc.hunter.killua.domain.OccupyInfo;
import cc.hunter.killua.entity.KilluaUser;
import cc.hunter.killua.mapper.KilluaOccupyMapper;
import cc.hunter.killua.mapper.KilluaUserMapper;
import cc.hunter.killua.service.OccupyMachineService;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Created by Administrator on 2016/6/15.
 */

@Service
public class OccupyMachineServiceImpl implements OccupyMachineService {

    private String currName;

    @Autowired
    private KilluaOccupyMapper killuaOccupyMapper;

    @Autowired
    private KilluaUserMapper killuaUserMapper;

    @Override
    public int occupy(String id, int type, Long userId) {
        boolean result = operate(id, type, userId);
        return result ? type : -type;
    }

    @Override
    public List<OccupyInfo> getOccupyInfoMap() {
        List<OccupyInfo> list = killuaOccupyMapper.findOccupyStatus();
        for(OccupyInfo info : list){
            int projectIdx = ArrayUtils.indexOf(MachineConstants.projects, info.getProject());
            int machineIdx = ArrayUtils.indexOf(MachineConstants.ips, info.getMachine());
            info.setId(projectIdx + "_" + machineIdx);
        }
        return list;
    }

    @Override
    public String getOccupant() {
        return KilluaContext.getCurrentUser().getRealname();
    }

    @Override
    public String getOccupyMsg(String id) {
        if(id.contains("_")){
            return StringUtils.join(parseId(id), " ");
        }
        return "";
    }

    private synchronized boolean operate(String id, int type, Long userId){
        if(id == null || id.trim().isEmpty()){
            return false;
        }

        KilluaUser user = KilluaContext.getCurrentUser();
        if(user == null){
            user = killuaUserMapper.findUserById(userId);
        }
        if(user == null){
            return false;
        } else {
            KilluaContext.setCurrentUser(user);
        }

        String[] info = parseId(id);
        if(info == null){
            return false;
        }
        String project = info[0];
        String machine = info[1];

        Long occupyUserId = killuaOccupyMapper.getOccupant(project, machine);
        boolean isFree = occupyUserId == null;
        if(!isFree && !occupyUserId.equals(userId)){
            return false;
        }

        if(type == 1 && !isFree){
            int releaseResult = killuaOccupyMapper.release(userId, project, machine);
            return releaseResult > 0;
        } else if(type == 2 && isFree){
            int occupyResult = killuaOccupyMapper.occupy(userId, project, machine);
            if(occupyResult > 0){
                currName = user.getRealname();
            }
            return occupyResult > 0;
        }

        return false;
    }

    private String[] parseId(String id){
        if(id == null || id.trim().isEmpty()){
            return null;
        }
        String[] indexs = id.split("_");
        int projectIndex = NumberUtils.toInt(indexs[0]);
        int ipIndex = NumberUtils.toInt(indexs[1]);
        String project = MachineConstants.projects[projectIndex];
        String machine = MachineConstants.ips[ipIndex];
        return new String[]{project, machine};
    }

}
