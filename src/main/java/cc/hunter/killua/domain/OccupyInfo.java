package cc.hunter.killua.domain;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/6/15.
 */
public class OccupyInfo implements Serializable{

    private static final long serialVersionUID = 1L;

    private String  id;
    private String  realname;
    private String  project;
    private String  machine;

    public OccupyInfo(String realname, String project, String machine) {
        this.realname = realname;
        this.project = project;
        this.machine = machine;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }
}
