package com.ry.pojo;

import java.util.Date;

public class User {
	private String userid;

    private String username;

    private String password;

    private String useraccount;

    private String usercontact;

    private Date usercreate;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount == null ? null : useraccount.trim();
    }

    public String getUsercontact() {
        return usercontact;
    }

    public void setUsercontact(String usercontact) {
        this.usercontact = usercontact == null ? null : usercontact.trim();
    }

    public Date getUsercreate() {
        return usercreate;
    }

    public void setUsercreate(Date usercreate) {
        this.usercreate = usercreate;
    }
}
