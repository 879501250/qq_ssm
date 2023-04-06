package com.qq.ssm.domain;

/**
 * 城市
 */
public class City {
    private String cid; // 城市id
    private String cname; // 城市名

    public City() {
    }

    public City(String cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "City{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }
}
