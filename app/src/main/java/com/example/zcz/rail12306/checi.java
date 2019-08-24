package com.example.zcz.rail12306;

import cn.bmob.v3.BmobObject;

/**
 * Created by lxd on 2017/12/16.
 */

public class checi extends BmobObject {
    private String name;
    private String chufa;
    private String fashi;
    private int yongshi;
    private String daozhan;
    private String daoshi;
    private String ruanwo;
    private String yingwo;
    private String yingzuo;
    private String wuzuo;
    private  int t1;
    private  int t2;
    private  int t3;
    private  int t4;
    private  float p1;
    private  float p2;
    private  float p3;
    private  float p4;
    private  String add1;
    private  String add2;

    public float getP1() {
        return p1;
    }

    public void setP1(float p1) {
        this.p1 = p1;
    }

    public float getP2() {
        return p2;
    }

    public void setP2(float p2) {
        this.p2 = p2;
    }

    public float getP3() {
        return p3;
    }

    public void setP3(float p3) {
        this.p3 = p3;
    }

    public float getP4() {
        return p4;
    }

    public void setP4(float p4) {
        this.p4 = p4;
    }

    public String getAdd1() {
        return add1;
    }

    public void setAdd1(String add1) {
        this.add1 = add1;
    }

    public String getAdd2() {
        return add2;
    }

    public void setAdd2(String add2) {
        this.add2 = add2;
    }

    public int getT1() {
        return t1;
    }

    public void setT1(int t1) {
        this.t1 = t1;
    }

    public int getT4() {
        return t4;
    }

    public void setT4(int t4) {
        this.t4 = t4;
    }

    public int getT3() {
        return t3;
    }

    public void setT3(int t3) {
        this.t3 = t3;
    }

    public int getT2() {
        return t2;
    }

    public void setT2(int t2) {
        this.t2 = t2;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChufa(String chufa) {
        this.chufa = chufa;
    }

    public void setFashi(String fashi) {
        this.fashi = fashi;
    }

    public void setYongshi(int yongshi) {
        this.yongshi = yongshi;
    }

    public void setDaozhan(String daozhan) {
        this.daozhan = daozhan;
    }

    public void setDaoshi(String daoshi) {
        this.daoshi = daoshi;
    }

    public void setRuanwo(String ruanwo) {
        this.ruanwo = ruanwo;
    }

    public void setYingwo(String yingwo) {
        this.yingwo = yingwo;
    }

    public void setYingzuo(String yingzuo) {
        this.yingzuo = yingzuo;
    }

    public void setWuzuo(String wuzuo) {
        this.wuzuo = wuzuo;
    }


    public String getName() {
        return name;
    }
    public String getChufa() {
        return chufa;
    }
    public int getYongshi() {
        return yongshi;
    }
    public String getDaozhan() {
        return daozhan;
    }
    public String getFashi() {return  fashi;}
    public String getDaoshi() {return daoshi;}
    public String getRuanwo() {
        return ruanwo;
    }
    public String getYingwo() {
        return yingwo;
    }
    public String getYingzuo() {return yingzuo;}
    public String getWuzuo() {
        return wuzuo;
    }
}
