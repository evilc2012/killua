package cc.hunter.killua.domain;

/**
 * Created by Administrator on 2016/6/15.
 */
public class OccupyMessage extends OccupyDomain{
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
