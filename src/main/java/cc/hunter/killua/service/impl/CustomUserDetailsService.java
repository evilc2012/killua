package cc.hunter.killua.service.impl;

import cc.hunter.killua.entity.KilluaRole;
import cc.hunter.killua.entity.KilluaUser;
import cc.hunter.killua.mapper.KilluaUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EvilC on 2016/6/19.
 */
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private KilluaUserMapper killuaUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        KilluaUser killuaUser = killuaUserMapper.findUserByUsername(username);
        if (killuaUser == null){
            throw new UsernameNotFoundException("can't find user by username:" + username);
        }

        List<KilluaRole> roles = killuaUserMapper.findRolesByUserid(killuaUser.getId());
        if(roles != null && !roles.isEmpty()){
            killuaUser.setRoles(roles);
        }

        return killuaUser;
    }

}
