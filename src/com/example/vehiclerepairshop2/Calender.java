package com.example.vehiclerepairshop2;

import java.util.Comparator;
import java.util.ArrayList;

//CONTROLLER
public class Calender {
    //private String myCalender;
    private ArrayList<RepairType> myVehicles;

    public Calender(String myCalender) {
        //this.myCalender = myCalender;
        this.myVehicles = new ArrayList<RepairType>();
    }

    public boolean addNewBooking(RepairType repairType) {
        if (findBooking(repairType.getRegNumber()) >= 0) {
            System.out.println("Registreringsnummret är redan bokat.");
            return false;
        }

        myVehicles.add(repairType);
        return true;
    }

    public boolean updateBooking(RepairType oldDate, RepairType newDate) {
        int foundPosition = findBooking(oldDate);
        if (foundPosition < 0) {
            System.out.println(oldDate.getRegNumber() + ", gick inte att hitta.");
            return false;
        }
        this.myVehicles.set(foundPosition, newDate);
        System.out.println(oldDate.getRegNumber() + ", har uppdaterats med " + newDate.getDate());
        return true;
    }

    public boolean removeBooking(RepairType repairType) {
        int foundPosition = findBooking(repairType);
        if (foundPosition < 0) {
            System.out.println(repairType.getRegNumber() + ", gick inte att hitta.");
            return false;
        }
        this.myVehicles.remove(foundPosition);
        System.out.println(repairType.getRegNumber() + ", har tagits bort.");
        return true;
    }

    private int findBooking(RepairType repairType) {

        return this.myVehicles.indexOf(repairType);
    }

    private int findBooking(String vehicleRegNumber) {
        for (int i = 0; i < this.myVehicles.size(); i++) {
            RepairType repairType = this.myVehicles.get(i);
            if (repairType.getRegNumber().equals(vehicleRegNumber)) {
                return i;
            }
        }
        return -1;
    }

    //sök efter inlagd bokning
    public RepairType queryVehicle(String regNumber) { // (Vi returnerar Contact (ett objekt))
        int position = findBooking(regNumber);
        if (position >= 0) {
            return this.myVehicles.get(position);
        }

        return null;
    }

    public void printBookings() {
        System.out.println("Bokningar:");
        for (int i = 0; i < this.myVehicles.size(); i++) {
            System.out.println(
                    "Datum (MMDD): " + this.myVehicles.get(i).getDate() +
                            "\n\tRegnr: " + this.myVehicles.get(i).getRegNumber() +
                            "\n\tNamn: " + this.myVehicles.get(i).getName() +
                            "\n\tTelefon: " + this.myVehicles.get(i).getPhoneNumber() +
                            "\n\tIngrepp: " + this.myVehicles.get(i).getRepair());
        }
    }

    public void sortAfterDate() {
        myVehicles.sort(Comparator.comparing(RepairType::getDate));
        System.out.println("Bookings sorted by date");
        System.out.println();
        printBookings();
    }

//    public void sortAfterPriority(){
//        toDoListPrivate.sort(Comparator.comparing(Task::getPriority, Comparator.reverseOrder()));
//        System.out.println("Tasks sorted by their priority");
//        System.out.println();
//        printToDoList();
//    }
}
