package com.xmetc.entity;

public class OrderInfoUid {
    private int id; //id
    private int uid;
    private int cid;
    private int cnum;
    private double cprice;
    private String cname;
    private String photo;

    public OrderInfoUid() {
    }

    public OrderInfoUid(int id, int uid, int cid, int cnum, double cprice, String cname, String photo) {
        this.id = id;
        this.uid = uid;
        this.cid = cid;
        this.cnum = cnum;
        this.cprice = cprice;
        this.cname = cname;
        this.photo = photo;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getCnum() {
        return cnum;
    }

    public void setCnum(int cnum) {
        this.cnum = cnum;
    }

    public double getCprice() {
        return cprice;
    }

    public void setCprice(double cprice) {
        this.cprice = cprice;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
