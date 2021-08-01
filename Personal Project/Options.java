package com.example.gstcalculatorapp;

public class Options {

    public String itemname;
    public String itempercentage;

    public Options(String itemname,String itempercentage) {
        this.itemname=itemname;
        this.itempercentage=itempercentage;
    }

    public String getName() {
        return itemname;
    }

    public void setName(String name) {
        this.itemname = name;
    }

    public String getPercentage() {
        return itempercentage;
    }

    public void setPercentage(String percentage) {
        this.itempercentage = percentage;
    }




}
