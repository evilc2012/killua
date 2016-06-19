package cc.hunter.killua.entity;

import javax.persistence.*;

/**
 * Created by EvilC on 2016/6/19.
 */
public class KilluaRole extends CommonEntity{

    private static final long serialVersionUID = 1L;

    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
