package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<BookData1> bookdata1;
    public static ArrayList<BookDataissued> bookdataissued;
    public static ArrayList<StudentData> studentdata;

    public static boolean check(String stuname, String stuid)
    {
        for(int i=1;i<=studentdata.size();i++)
        {
            String name=studentdata.get(i-1).getStudname();
            String id =studentdata.get(i-1).getStudid();
            if(name.equals(stuname) && id.equals(stuid))
            {
                return true;
            }
        }
        return false;
    }


    public static void login()
    {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter you login id ");
        String logid=input.nextLine();
        System.out.print("Enter your login in password ");
        String logpass=input.nextLine();
        if(logid.equals("Teacher123") && logpass.equals("init@123"))
        {
            System.out.println("\nYou have successfully logged in");
            System.out.println("\nWelcome to library management program");
            start();
        }
        else
        {
            System.out.println("\nYou have entered wrong login credentials\n");
            login();
        }

    }


    public static void start() {
        Scanner input = new Scanner(System.in);
        System.out.println("    What do you want to do?");
        System.out.println("    *To add Book enter                                1");
        System.out.println("    *To issue Book enter                              2");
        System.out.println("    *To return Book enter                             3");
        System.out.println("    *To see all issued Books enter                    4");
        System.out.println("    *To see all available Books enter                 5");
        System.out.println("    *To find student info and book issued enter       6");
        System.out.println("    *To find book info and who issued it enter        7");
        System.out.println("    *To exit enter                                    8");
        int n = input.nextInt();
            start(n);
    }


    public static void option1() //add book
    {
        Scanner input=new Scanner(System.in);
        String name;
        String id;
        System.out.print("Enter book name ");
        name = input.nextLine();
        System.out.print("Enter book id ");
        id = input.nextLine();
        for(int i=1;i<=bookdata1.size();i++)
        {
            String bkid= bookdata1.get(i-1).getBookid();
            if (bkid.equals(id))
            { System.out.println("\nCannot enter the book, another book with same id alredy exits\n");
            start();
            }
        }
        for(int i=1;i<=bookdataissued.size();i++)
        {
            String bkid= bookdataissued.get(i-1).getBookid();
            if (bkid.equals(id))
            { System.out.println("\nCannot enter the book, another book with same id alredy exits\n");
                start();
            }
        }
        bookdata1.add(new BookData1(name,id));
        System.out.println("\nBook details have been added \n");
        start();
    }


    public static void option2()  //issue book
    {
        Scanner input=new Scanner(System.in);
        String name;
        String id;
        String bookname;
        String bookid;
        System.out.print("Enter student name ");
        name = input.nextLine();
        System.out.print("Enter student id ");
        id= input.nextLine();
        if(check(name,id)) {
            System.out.print("Enter book name ");
            bookname = input.nextLine();
            System.out.print("Enter book id ");
            bookid = input.nextLine();
            for (int i = 1; i <= bookdata1.size(); i++) {
                String bkname = bookdata1.get(i - 1).getBookname();
                String bkid = bookdata1.get(i - 1).getBookid();
                if (bkname.equals(bookname) && bkid.equals(bookid)) {
                    for(int j=1;j<=bookdataissued.size();j++) {
                        String stuname = bookdataissued.get(j - 1).getStudname();
                        String stuid = bookdataissued.get(j - 1).getStudid();
                        if (stuname.equals(name) && stuid.equals(id)) {
                            System.out.println("\nStudent has already issued 1 book cannot issue a new book\n");
                            start();
                        }
                    }
                        {
                            bookdataissued.add(new BookDataissued(bookname, bookid, name, id));
                            bookdata1.remove(i - 1);
                            System.out.println("\nBook issued \n");
                            start();
                        }
                }
            }
            for(int i=1;i<=bookdataissued.size();i++) {
                String bkname = bookdataissued.get(i - 1).getBookname();
                String bkid = bookdataissued.get(i - 1).getBookid();
                if (bkname.equals(bookname) && bkid.equals(bookid)) {
                    System.out.println("\nSorry the book has already been issued\n");
                    start();
                }
            }
            System.out.println("\nBook not issued entered wrong book name or id\n");
        }
        else
        {
            System.out.println("\nEntered wrong name or id of student\n");
        }
        start();
    }


    public static void option3() // return book
    {
        Scanner input=new Scanner(System.in);
        String name;
        String id;
        String bookname;
        String bookid;
        System.out.print("Enter student name ");
        name = input.nextLine();
        System.out.print("Enter student id ");
        id= input.nextLine();
        if(check(name,id)) {
            System.out.print("Enter book name ");
            bookname = input.nextLine();
            System.out.print("Enter book id ");
            bookid = input.nextLine();
            for (int i = 1; i <= bookdataissued.size(); i++) {
                String stuname = bookdataissued.get(i - 1).getStudname();
                String stuid = bookdataissued.get(i - 1).getStudid();
                String bkname = bookdataissued.get(i - 1).getBookname();
                String bkid = bookdataissued.get(i - 1).getBookid();
                if (bkname.equals(bookname) && bkid.equals(bookid) && stuname.equals(name) && stuid.equals(id)) {
                    bookdata1.add(new BookData1(bookname, bookid));
                    bookdataissued.remove(i - 1);
                    System.out.println("\nBook returned \n");
                    start();
                }
            }
            System.out.println("\nEnter wrong bookname or id\n");
            start();
        }
        System.out.println("\nBook not returned entered wrong student name or id \n");
        start();
    }


    public static void option4() //To see all issued Books enter
    {
        if(bookdataissued.isEmpty())
        {
            System.out.println("None of the books are issued \n");
        }
        else
        {
            for(int i=1;i<=bookdataissued.size();i++)
            {
                String bookname=bookdataissued.get(i-1).getBookname();
                String bookid=bookdataissued.get(i-1).getBookid();
                String studname=bookdataissued.get(i-1).getStudname();
                System.out.println(i+" Book Name - "+bookname+", Book Id - "+bookid+", Issued to -"+studname+"\n");
            }
        }
        start();
    }


    public static void option5()  //To see all available Books enter
    {
        if(bookdata1.isEmpty())
        {
            System.out.println("All of the books are issued \n");
        }
        else
        {
            for(int i=1;i<=bookdata1.size();i++)
            {
                String name=bookdata1.get(i-1).getBookname();
                String id=bookdata1.get(i-1).getBookid();
                System.out.println(i+" Book Name - "+name+", Book Id - "+id+"\n");
            }
        }
        start();
    }


    public static void option6()  //To find student info and book issued enter
    {
        Scanner input = new Scanner(System.in);
        String stuname;
        String stuid;
        System.out.print("Enter student name ");
        stuname=input.nextLine();
        System.out.print("Enter student id ");
        stuid=input.nextLine();
        for (BookDataissued bookDataissued : bookdataissued) {
            String name = bookDataissued.getStudname();
            String id = bookDataissued.getStudid();
            if (stuname.equals(name) && stuid.equals(id)) {
                System.out.println("\nStudent data has been found");
                System.out.println("Student Name - " + stuname + ", Student id - " + stuid + ", Book name -" + bookDataissued.bookname + ", Book id - " + bookDataissued.bookid + "\n");
                start();
            }
        }
        System.out.println(stuname+" has not issued any book\n");
        start();
    }


    public static void option7()  //To find book info and who issued it enter
    {
        Scanner input = new Scanner(System.in);
        String bookname;
        String bookid;
        System.out.print("Enter name of the book ");
        bookname=input.nextLine();
        System.out.print("Enter book id ");
        bookid=input.nextLine();
        for (BookDataissued bookDataissued : bookdataissued) {
            String name = bookDataissued.getBookname();
            String id = bookDataissued.getBookid();
            if (bookname.equals(name) && bookid.equals(id)) {
                System.out.println("\nBook data has been found");
                System.out.println("The book has been already issued by");
                System.out.println("Student Name - " + bookDataissued.studname + ", Student id - " + bookDataissued.studid + "\n");
                start();
            }
        }
        System.out.println(bookname+" has not been issued it is available in the library\n");
        start();
    }


    public static void start(int n) {
        switch (n) {
            case 1: {
                option1();
                break;
            }
            case 2: {
                option2();
                break;
            }
            case 3: {
                option3();
                break;
            }
            case 4: {
                option4();
                break;
            }
            case 5: {
                option5();
                break;
            }
            case 6: {
                option6();
                break;
            }
            case 7: {
                option7();
                break;
            }
            case 8:
            {
                System.out.println("You have exited");
                System.exit(0);
            }
            default: {
                System.out.println("Please enter a valid input");
                start();
            }
        }
    }

    public static void main(String[] args) {
        bookdata1=new ArrayList<BookData1>();
        bookdataissued=new ArrayList<BookDataissued>();
        studentdata=new ArrayList<StudentData>();


        bookdata1.add(new BookData1("Physics","1"));
        bookdata1.add(new BookData1("Chemistry","2"));
        bookdata1.add(new BookData1("Maths","3"));
        bookdata1.add(new BookData1("Bio","4"));
        bookdata1.add(new BookData1("Computer Programming","5"));
        bookdata1.add(new BookData1("Java","6"));
        bookdata1.add(new BookData1("Python","7"));
        bookdata1.add(new BookData1("Machine Learning","8"));


        studentdata.add(new StudentData("A","20"));
        studentdata.add(new StudentData("B","21"));
        studentdata.add(new StudentData("C","22"));

        login();
        start();

    }
}
