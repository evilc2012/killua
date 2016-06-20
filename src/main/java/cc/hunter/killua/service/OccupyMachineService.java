package cc.hunter.killua.service;

import cc.hunter.killua.domain.OccupyInfo;

import java.util.List;

/**
 * Created by EvilC on 2016/6/19.
 */
public interface OccupyMachineService {

    /**
     * 占用/释放机器
     * @param id        机器id
     * @param type      1-释放  2-占用
     * @param userId
     * @return          1-释放成功  2-占用成功  -1-释放失败  -2-占用失败
     */
    public int occupy(String id, int type, Long userId);

    /**
     * 获取当前占用状态
     * @return
     */
    public List<OccupyInfo> getOccupyInfoMap();

    /**
     * 获取占用者姓名
     * @return
     */
    String getOccupant();

    String getOccupyMsg(String id);

}
