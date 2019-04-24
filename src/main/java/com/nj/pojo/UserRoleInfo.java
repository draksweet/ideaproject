package com.nj.pojo;

public class UserRoleInfo {
    private Integer userRoleId;
    private Integer urUserId;
    private Integer urRoleId;

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Integer getUrUserId() {
        return urUserId;
    }

    public void setUrUserId(Integer urUserId) {
        this.urUserId = urUserId;
    }

    public Integer getUrRoleId() {
        return urRoleId;
    }

    public void setUrRoleId(Integer urRoleId) {
        this.urRoleId = urRoleId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "userRoleId=" + userRoleId +
                ", urUserId=" + urUserId +
                ", urRoleId=" + urRoleId +
                '}';
    }
}
