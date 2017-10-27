package com.ry.pojo;

import java.util.Date;

public class Fun {
    private String funid;

    private String funname;

    private String funurl;

    private String funicon;

    private String funfathernode;

    private Date funcreate;

    public String getFunid() {
        return funid;
    }

    public void setFunid(String funid) {
        this.funid = funid == null ? null : funid.trim();
    }

    public String getFunname() {
        return funname;
    }

    public void setFunname(String funname) {
        this.funname = funname == null ? null : funname.trim();
    }

    public String getFunurl() {
        return funurl;
    }

    public void setFunurl(String funurl) {
        this.funurl = funurl == null ? null : funurl.trim();
    }

    public String getFunicon() {
        return funicon;
    }

    public void setFunicon(String funicon) {
        this.funicon = funicon == null ? null : funicon.trim();
    }

    public String getFunfathernode() {
        return funfathernode;
    }

    public void setFunfathernode(String funfathernode) {
        this.funfathernode = funfathernode == null ? null : funfathernode.trim();
    }

    public Date getFuncreate() {
        return funcreate;
    }

    public void setFuncreate(Date funcreate) {
        this.funcreate = funcreate;
    }
}