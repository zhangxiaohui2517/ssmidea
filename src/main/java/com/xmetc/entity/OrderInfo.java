package com.xmetc.entity;

public class OrderInfo {
    private int oiid;
    private int oid;
    private int cid;
    private int cnum;

    public OrderInfo() {
    }

    public OrderInfo(int oiid, int oid, int cid, int cnum) {
        this.oiid = oiid;
        this.oid = oid;
        this.cid = cid;
        this.cnum = cnum;
    }

    public int getOiid() {
        return oiid;
    }

    public void setOiid(int oiid) {
        this.oiid = oiid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
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

    @Override
    public String toString() {
        return "OrderInfo{" +
                "oiid=" + oiid +
                ", oid=" + oid +
                ", cid=" + cid +
                ", cnum=" + cnum +
                '}';
    }
}
