package cc.hunter.killua.domain;

/**
 * Created by Administrator on 2016/6/15.
 */
public class OccupyInfo {

    private String  ip;
    private String  name;
    private int     type;

    public OccupyInfo(String ip, String name, int type) {
        this.ip = ip;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
