package com.ry.pojo;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Fun_Role {
	private String funRoleId;

    private String roleid;

    private String funid;

    private Date funcreate;

    public String getFunRoleId() {
        return funRoleId;
    }

    public void setFunRoleId(String funRoleId) {
        this.funRoleId = funRoleId == null ? null : funRoleId.trim();
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    public String getFunid() {
        return funid;
    }

    public void setFunid(String funid) {
        this.funid = funid == null ? null : funid.trim();
    }

    public Date getFuncreate() {
        return funcreate;
    }

    public void setFuncreate(Date funcreate) {
        this.funcreate = funcreate;
    }
	
	
	
}
