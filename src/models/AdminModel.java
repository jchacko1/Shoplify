package models;

import java.util.Date;

/**
 * Created by KellyAnn on 11/10/14.
 */
public class AdminModel {

    private static final long serialVerionUID = 345678909876545678L;
    private Integer addAccount;
    private String loginName;
    private String password;
    private Integer loginTime;
    private Date lastLoginTime;
    private Date lastLogoutTime;
    private String userName;
    private Integer userId;

    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }

    public Integer getUserId(){
        return userId;
    }

    public void setUserId(Integer userId){
        this.userId = userId;
    }

    public Integer getAddAccout(){
        return addAccount;
    }

    public void setAddAcout(Integer addAccount){
        this.addAccount = addAccount;
    }

    public Integer getLoginTime(){
        return loginTime;
    }

    public void setLoginTime(Integer loginTime){
        this.loginTime = loginTime;
    }

    public Date getLastLoginTime(){
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime){
        this.lastLoginTime = lastLoginTime;
    }

    public Date getLastLogoutTime(){
        return lastLogoutTime;
    }

    public void setLastLogoutTime(Date lastLogoutTime){
        this.lastLogoutTime = lastLogoutTime;
    }

    public String getLoginName(){
        return loginName;
    }

    public void setLoginName(String loginName){
        this.loginName = loginName;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
