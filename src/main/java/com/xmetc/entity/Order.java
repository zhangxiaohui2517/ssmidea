package com.xmetc.entity;

import java.sql.Date;

public class Order {
    private int oid;
    private int uid;
    private double payment;
    private int paytype;
    private Date createtime;

    public Order() {
    }

    public Order(int oid, int uid, double payment, int paytype, Date createtime) {
        this.oid = oid;
        this.uid = uid;
        this.payment = payment;
        this.paytype = paytype;
        this.createtime = createtime;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public int getPaytype() {
        return paytype;
    }

    public void setPaytype(int paytype) {
        this.paytype = paytype;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
