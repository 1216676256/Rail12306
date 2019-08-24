package com.example.zcz.rail12306;

import java.security.PrivilegedExceptionAction;

import cn.bmob.v3.BmobObject;

/**
 * Created by ZCZ on 2017/12/29.
 */


public class Passenger extends BmobObject {
    private String name;
    private String stu;
    private String identity;
    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStu() {
        return stu;
    }

    public void setStu(String stu) {
        this.stu = stu;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}