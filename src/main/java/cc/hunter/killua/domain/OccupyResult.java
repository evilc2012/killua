package cc.hunter.killua.domain;

/**
 * Created by Administrator on 2016/6/15.
 */
public enum OccupyResult {

    RELEASE_SUCC(1, "释放成功"),
    OCCUPY_SUCC(2, "占用成功"),
    OCCUPY_ALWAYS_SUCC(3, "长期占用成功"),

    RELEASE_FAIL(-1, "释放失败"),
    OCCUPY_FAIL(-2, "占用失败"),
    OCCUPY_ALWAYS_FAIL(-3, "长期占用失败"),

    ;

    public int status;
    public String msg;

    OccupyResult(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public static String getMsg(int status){
        String result = "";
        for(OccupyResult or : OccupyResult.values()){
            if(or.status == status){
                result = or.msg;
                break;
            }
        }
        return result;
    }

}
