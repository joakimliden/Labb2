package com.example.vehiclerepairshop2;

//SUBKLASS
public class RepairType extends Vehicle {
    private String repair;

    public RepairType(int month, int day, String regNumber, String name, String phoneNumber, String repair) {
        super(month, day, regNumber, name, phoneNumber);
        this.repair = repair;
    }

    public String getRepair() {

        return repair;
    }

    public void setRepair(String repair) {
        this.repair = repair;
    }

    public static RepairType createVehicle(int date, String regNumber, String name, String phoneNumber, String repair) {
        return new RepairType(date, regNumber, name, phoneNumber, repair);
    }
}
