package cc.hunter.killua.domain;

/**
 * Created by Administrator on 2016/6/15.
 */
public class OccupyResponse extends OccupyDomain {

    private String rspMsg;

    private int status;

    public OccupyResponse(int status, String obj, String id, int type){
        this.status = status;
        this.rspMsg = rspMsg;
        this.id = id;
        this.type = type;
    }

    public String getRspMsg() {
        return rspMsg;
    }

    public int getStatus() {
        return status;
    }

}
