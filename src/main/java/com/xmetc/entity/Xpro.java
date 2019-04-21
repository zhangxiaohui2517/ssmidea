package com.xmetc.entity;

public class Xpro {
    private int xpid;
    private String xpname;
    private int pid;

    public Xpro() {
    }

    public Xpro(int xpid, String xpname, int pid) {
        this.xpid = xpid;
        this.xpname = xpname;
        this.pid = pid;
    }

    public int getXpid() {
        return xpid;
    }

    public void setXpid(int xpid) {
        this.xpid = xpid;
    }

    public String getXpname() {
        return xpname;
    }

    public void setXpname(String xpname) {
        this.xpname = xpname;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Xpro{" +
                "xpid=" + xpid +
                ", xpname='" + xpname + '\'' +
                ", pid=" + pid +
                '}';
    }
}
