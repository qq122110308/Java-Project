package com.ry.pojo;

import java.util.Date;

public class Log {
    private String logid;

    private String logtype;

    private String logname;

    private Date logcreate;

    private String logexception;

    private String logip;

    public String getLogid() {
        return logid;
    }

    public void setLogid(String logid) {
        this.logid = logid == null ? null : logid.trim();
    }

    public String getLogtype() {
        return logtype;
    }

    public void setLogtype(String logtype) {
        this.logtype = logtype == null ? null : logtype.trim();
    }

    public String getLogname() {
        return logname;
    }

    public void setLogname(String logname) {
        this.logname = logname == null ? null : logname.trim();
    }

    public Date getLogcreate() {
        return logcreate;
    }

    public void setLogcreate(Date logcreate) {
        this.logcreate = logcreate;
    }

    public String getLogexception() {
        return logexception;
    }

    public void setLogexception(String logexception) {
        this.logexception = logexception == null ? null : logexception.trim();
    }

    public String getLogip() {
        return logip;
    }

    public void setLogip(String logip) {
        this.logip = logip == null ? null : logip.trim();
    }
}