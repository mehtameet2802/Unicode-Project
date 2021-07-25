package com.company;

import java.util.ArrayList;

public class BookData1 {

    public String Bookname;
    public String  Bookid;


    public BookData1(String Bookname,String Bookid)
    {
        this.Bookname=Bookname;
        this.Bookid=Bookid;
    }



    public String getBookname() {
        return Bookname;
    }

    public void setBookname(String bookname) {
        this.Bookname = Bookname;
    }

    public String getBookid() {
        return Bookid;
    }

    public void setBookid(int bookid) {
        this.Bookid = Bookid;
    }


}

