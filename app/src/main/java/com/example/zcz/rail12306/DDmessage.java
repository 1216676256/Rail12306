package com.example.zcz.rail12306;

import cn.bmob.v3.BmobObject;

/**
 * Created by ZCZ on 2017/12/29.
 */
public class DDmessage extends BmobObject {
    private String time_start;
    private String destination_1;
    private String destination_2;
    private int sum;
    private  String customer;
    private  String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime_start() {
        return time_start;
    }

    public void setTime_start(String time_start) {
        this.time_start = time_start;
    }

    public String getDestination_1() {
        return destination_1;
    }

    public void setDestination_1(String destination_1) {
        this.destination_1 = destination_1;
    }

    public String getDestination_2() {
        return destination_2;
    }

    public void setDestination_2(String destination_2) {
        this.destination_2 = destination_2;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
