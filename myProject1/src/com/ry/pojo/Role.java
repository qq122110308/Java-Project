package com.ry.pojo;

import java.util.Date;

public class Role {
    private String roleid;

    private String rolename;

    private Date rolecreate;

    private Integer rolestate;

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public Date getRolecreate() {
        return rolecreate;
    }

    public void setRolecreate(Date rolecreate) {
        this.rolecreate = rolecreate;
    }

    public Integer getRolestate() {
        return rolestate;
    }

    public void setRolestate(Integer rolestate) {
        this.rolestate = rolestate;
    }
}