package com.xmetc.entity;

public class Commodity {
    private int cid;
    private int xpid;
    private String cname;
    private String image;
    private String detail;
    private double price;

    public Commodity() {
    }

    public Commodity(int cid, int xpid, String cname, String image, String detail, double price) {
        this.cid = cid;
        this.xpid = xpid;
        this.cname = cname;
        this.image = image;
        this.detail = detail;
        this.price = price;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getXpid() {
        return xpid;
    }

    public void setXpid(int xpid) {
        this.xpid = xpid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "cid=" + cid +
                ", xpid=" + xpid +
                ", cname='" + cname + '\'' +
                ", image='" + image + '\'' +
                ", detail='" + detail + '\'' +
                ", price=" + price +
                '}';
    }
}
