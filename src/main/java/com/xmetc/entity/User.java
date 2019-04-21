package com.xmetc.entity;

import java.sql.Date;

public class User {
    private int id;
    private String username;
    private String pass;
    private String sex;
    private Date birth;
    private String tel;
    private String email;
    private String hphoto;

    public User() {
    }

    public User(int id, String username, String pass, String sex, Date birth, String tel, String email, String hphoto) {
        this.id = id;
        this.username = username;
        this.pass = pass;
        this.sex = sex;
        this.birth = birth;
        this.tel = tel;
        this.email = email;
        this.hphoto = hphoto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return pass;
    }

    public void setPassword(String pass) {
        this.pass = pass;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getHphoto() {
        return hphoto;
    }

    public void setHphoto(String hphoto) {
        this.hphoto = hphoto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + pass + '\'' +
                ", birth=" + birth +
                ", sex='" + sex + '\'' +
                ", tel='" + tel + '\'' +
                ", photo='" + hphoto + '\'' +
                '}';
    }
}
