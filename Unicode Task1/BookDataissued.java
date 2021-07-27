package com.company;

public class BookDataissued {
    public String bookname;
    public String bookid;
    public String studname;
    public String studid;

    public BookDataissued(String bookname, String bookid, String studname, String studid)
    {
        this.bookname=bookname;
        this.bookid=bookid;
        this.studname=studname;
        this.studid=studid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getStudname() {
        return studname;
    }

    public void setStudname(String studname) {
        this.studname = studname;
    }

    public String getStudid() {
        return studid;
    }

    public void setStudid(String studid) {
        this.studid = studid;
    }




}
