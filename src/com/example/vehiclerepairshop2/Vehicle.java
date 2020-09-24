package com.example.vehiclerepairshop2;

import java.util.ArrayList;

//SUPERKLASS
public class Vehicle {
    private int month;
    private int day;
    private String regNumber;
    private String name;
    private String phoneNumber;

    private static ArrayList<Vehicle> list = new ArrayList<>();

    public Vehicle(int date, String regNumber, String name, String phoneNumber) {
        this.date = date;
        this.regNumber = regNumber;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getDate() {
        return date;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
