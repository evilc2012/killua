package cc.hunter.killua.context;

import cc.hunter.killua.entity.KilluaUser;

/**
 * Created by Administrator on 2016/6/20.
 */
public class KilluaContext {

    private static final ThreadLocal<KilluaUser> currentUser = new ThreadLocal<>();

    public static void setCurrentUser(KilluaUser user){
        currentUser.set(user);
    }

    public static KilluaUser getCurrentUser(){
        return currentUser.get();
    }

}
