package cc.hunter.killua.domain;

/**
 * Created by Administrator on 2016/6/15.
 */
public class OccupyInfo {

    private String  ip;
    private int     type;

    public OccupyInfo(String ip, int type) {
        this.ip = ip;
        this.type = type;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
