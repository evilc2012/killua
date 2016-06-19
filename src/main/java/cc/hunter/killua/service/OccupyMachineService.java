package cc.hunter.killua.service;

import cc.hunter.killua.domain.OccupyInfo;

import java.util.Map;

/**
 * Created by EvilC on 2016/6/19.
 */
public interface OccupyMachineService {

    /**
     * 占用/释放机器
     * @param id        机器id
     * @param type      1-释放  2-占用  3-长期占用
     * @param ip
     * @return          1-释放成功  2-占用成功  3-长期占用成功  -1-释放失败  -2-占用失败  -3-长期占用失败
     */
    public int occupy(String id, int type, String ip);

    /**
     * 获取状态
     * @return
     */
    public Map<String, OccupyInfo> getOccupyInfoMap();

    String getOccupant(String clientFlag);

    String getOccupyMsg(String id);

}
