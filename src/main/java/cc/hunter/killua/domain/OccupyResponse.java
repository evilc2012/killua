package cc.hunter.killua.domain;

/**
 * Created by Administrator on 2016/6/15.
 */
public class OccupyResponse extends OccupyDomain {

    private String rspMsg;

    private int status;

    private String occupant;

    public OccupyResponse(int status, String rspMsg, String id, int type, String occupant){
        this.status = status;
        this.rspMsg = rspMsg;
        this.id = id;
        this.type = type;
        this.occupant = occupant;
    }

    public String getRspMsg() {
        return rspMsg;
    }

    public int getStatus() {
        return status;
    }

    public String getOccupant() {
        return occupant;
    }
}
