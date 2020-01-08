package com.example.helal;

import android.graphics.Bitmap;

/**
 * Created by Mohamed on 10/12/2018.
 */
public class productsql {

    private int id;
    private String name;
    private String count;
    private String salary;
    private Bitmap bt;
    private String pieccount;
    private String remain_carton_count;
    public int remain_pieces_count=0;
    public String getRemain_carton_count() {
        return remain_carton_count;
    }

    public void setRemain_carton_count(String remain_carton_count) {
        this.remain_carton_count = remain_carton_count;
    }






    public String getPieccount() {
        return pieccount;
    }

    public void setPieccount(String pieccount) {
        this.pieccount = pieccount;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bitmap getBt() {
        return bt;
    }

    public void setBt(Bitmap bt) {
        this.bt = bt;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public productsql(int id, String name, String count, String salary, Bitmap bt, String pieccount, String remain_carton_count, int remain_pieces_count) {
        this.id=id;
        this.name = name;
        this.count = count;
        this.salary = salary;
        this.bt=bt;
        this.pieccount=pieccount;
        this.remain_carton_count=remain_carton_count;
        this.remain_pieces_count=remain_pieces_count;
    }

    public productsql() {

    }



}
