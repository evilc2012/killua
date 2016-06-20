package cc.hunter.killua.mapper;

import cc.hunter.killua.domain.OccupyInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/20.
 */
@Mapper
public interface KilluaOccupyMapper {

    /**
     * 占用机器
     * @param userId
     * @param project
     * @param machine
     * @return
     */
    @Insert("insert into killua_user_occupy(user_id, project, machine) values(#{userId}, #{project}, #{machine})")
    int occupy(Long userId, String project, String machine);

    /**
     * 机器是否空闲
     * @param project
     * @param machine
     * @return
     */
    @Select("select count(*) from killua_user_occupy where user_id = #{userId} and project = #{project} and machine = #{machine}")
    int isFree(Long userId, String project, String machine);

    /**
     * 释放机器
     * @param userId
     * @param project
     * @param machine
     * @return
     */
    @Delete("delete from killua_user_occupy where user_id = #{userId} and project = #{project} and machine = #{machine}")
    int release(Long userId, String project, String machine);

    /**
     * 获取占用初始状态
     * @return
     */
    @Select("select u.realname as realname, uo.project as project, uo.machine as machine from killua_user_occupy uo left join killua_user u on u.id = uo.user_id ")
    List<OccupyInfo> findOccupyStatus();
}
