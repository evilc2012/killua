package cc.hunter.killua.mapper;

import cc.hunter.killua.entity.KilluaRole;
import cc.hunter.killua.entity.KilluaUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by EvilC on 2016/6/19.
 */
@Mapper
public interface KilluaUserMapper {

    @Select("select * from killua_user where username = #{username}")
    KilluaUser findUserByUsername(@Param("username") String username);

    @Select("select r.id, r.name from killua_role r where r.id in (select role_id from killua_user_role where user_id = #{userid})")
    List<KilluaRole> findRolesByUserid(@Param("userid") Long userid);

}
