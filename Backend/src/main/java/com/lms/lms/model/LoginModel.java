package com.lms.lms.model;

import javax.persistence.*;

@Entity
@Table(name = "LoginMaster")
public class LoginModel {
    @Id
    @GeneratedValue
    @Column(name = "login_id")
    private Integer loginId;

    @Column(name = "login_username")
    private String username;

    @Column(name = "login_password")
    private String password;

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
