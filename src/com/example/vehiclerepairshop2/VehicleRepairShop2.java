package com.example.vehiclerepairshop2;

import java.util.Scanner;

public class VehicleRepairShop2 {
    private static Scanner sc = new Scanner(System.in);
    private static Calender calender = new Calender("myCalender");

    public static void main(String[] args) {

        boolean quit = false;
        printActions();
        while(!quit) {
            System.out.println("\nVälj: (6 för att visa val)");
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nStänger ner...");
                    quit = true;
                    break;

                case 1:
                    calender.sortAfterDate();
                    //calender.printBookings();
                    break;

                case 2:
                    addNewBooking();
                    break;

                case 3:
                    updateBooking();
                    break;

                case 4:
                    removeBooking();
                    break;

                case 5:
                    queryVehicle();
                    break;

                case 6:
                    printActions();
                    break;
            }
        }
    }

    private static void addNewBooking() {
        System.out.println("månad för nya bokningen: (siffra)");
        int month = sc.nextInt();
        System.out.println("dag: ");
        int day = sc.nextInt();
        sc.nextLine();
        System.out.println("Registreningsnummer: (små bokstäver, utan mellanslag)");
        String regNumber = sc.nextLine();
        System.out.println("Namn: ");
        String name = sc.nextLine();
        System.out.println("Telefonnummer: ");
        String phone = sc.nextLine();
        System.out.println("Typ av ingrepp: ");
        String repair = sc.nextLine();
        RepairType newVehicle = new RepairType(month, day, regNumber, name, phone, repair);
        if(calender.addNewBooking(newVehicle)) {
            System.out.println("Ny bokning: " + day + "/" + month + regNumber);
        } else {
            System.out.println(regNumber + " finns redan bokat.");
        }
    }

    private static void updateBooking() {
        System.out.println("Skriv in regnumret på fordonet som skall uppdatera datumet: ");
        String updateRegNumber = sc.nextLine();
        RepairType existingRepairTypeRecord = calender.queryVehicle(updateRegNumber); //ny set metod istället
        if(existingRepairTypeRecord == null) {
            System.out.println("Kan inte hitta fordonet.");
            return;
        }
        System.out.print("Skriv in nytt datum för verkstadstiden: ");
        int newDate = sc.nextInt();
        String regNumber = existingRepairTypeRecord.getRegNumber();
        String name = existingRepairTypeRecord.getName();
        String phoneNumber = existingRepairTypeRecord.getPhoneNumber();
        String repair = existingRepairTypeRecord.getRepair();
        RepairType newBooking = RepairType.createVehicle(newDate, regNumber, name, phoneNumber, repair);
        if(calender.updateBooking(existingRepairTypeRecord, newBooking)) {
            System.out.println("Kontakten är uppdaterad!");
        } else {
            System.out.println("Gick inte att uppdatera.");
        }
    }

    private static void removeBooking() {
        System.out.println("Skriv in regnr på fordonet som skall tas bort: ");
        String regNumber = sc.nextLine();
        RepairType existingRepairTypeRecord = calender.queryVehicle(regNumber);
        if (existingRepairTypeRecord == null) {
            System.out.println("Kan inte hitta fordonet.");
            return;
        }

        if(calender.removeBooking(existingRepairTypeRecord)) {
            System.out.println("Bokningen har tagits bort!");
        } else {
            System.out.println("Kan inte ta bort bokningen.");
        }
    }

    private static void queryVehicle() {
        System.out.println("Skriv in regnr på fordonet: ");
        String regNumber = sc.nextLine();
        Vehicle existingVehicleRecord = calender.queryVehicle(regNumber);
        if (existingVehicleRecord == null) {
            System.out.println("Kan inte hitta fordonet.");
            return;
        }

        System.out.println("Namn: " + existingVehicleRecord.getName() + " telefonnummer är " + existingVehicleRecord.getPhoneNumber());
    }

    private static void printActions() {
        System.out.println("\nVälj:\n");
        System.out.println("0  - Stäng av\n" +
                "1  - Visa bokningar\n" +
                "2  - Lägga till en ny bokning\n" +
                "3  - Uppdatera datum för bokning\n" +
                "4  - Ta bort bokning\n" +
                "5  - Söka efter ett inlagt fordon\n" +
                "6  - Visa en lista över alla val.");
    }
}
