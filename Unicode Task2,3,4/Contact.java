package com.example.myapplication;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class Contact {
    public String name;
    public String number;
    public String birthdate;
    public String email;

    public Contact(String name, String number, String birthdate, String email) {
        this.name = name;
        this.number = number;
        this.birthdate = birthdate;
        this.email= email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBirthdate(){ return birthdate;}

    public void setBirthdate(String birthdate) {
        this.name = birthdate;
    }

    public String getEmail(){ return email;}

    public void setEmail(String email) {
        this.name = email;
    }




}
