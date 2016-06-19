package cc.hunter.killua.entity;

import java.io.Serializable;

/**
 * Created by EvilC on 2016/6/19.
 */
public abstract class CommonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
