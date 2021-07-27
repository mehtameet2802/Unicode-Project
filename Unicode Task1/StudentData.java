package com.company;

public class StudentData {

    public String Studname;
    public String Studid;

    public StudentData(String Studname, String Studid)
    {
        this.Studname=Studname;
        this.Studid=Studid;
    }

    public String getStudname() {
        return Studname;
    }

    public void setStudname(String studname) {
        Studname = studname;
    }

    public String getStudid() {
        return Studid;
    }

    public void setStudid(String studid) {
        Studid = studid;
    }


}
