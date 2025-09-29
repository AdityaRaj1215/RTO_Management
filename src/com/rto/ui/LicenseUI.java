package com.rto.ui;

import com.rto.model.License;
import com.rto.service.LicenseService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class LicenseUI {
    private static LicenseService service = new LicenseService();
    private static Scanner sc = new Scanner(System.in);

    public static void showMenu() {
        while (true) {
            System.out.println("\n==== License Menu ====");
            System.out.println("1. Add License");
            System.out.println("2. View All Licenses");
            System.out.println("3. View License by ID");
            System.out.println("4. Update License");
            System.out.println("5. Delete License");
            System.out.println("0. Back");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1: addLicense(); break;
                case 2: listLicenses(); break;
                case 3: getLicenseById(); break;
                case 4: updateLicense(); break;
                case 5: deleteLicense(); break;
                case 0: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private static void addLicense() {
        System.out.print("Enter License Number: ");
        String number = sc.nextLine();
        System.out.print("Enter Owner ID (must exist): ");
        int ownerId = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Type (LMV/MCWG/etc): ");
        String type = sc.nextLine();
        System.out.print("Enter Issue Date (yyyy-mm-dd): ");
        LocalDate issue = LocalDate.parse(sc.nextLine());
        System.out.print("Enter Expiry Date (yyyy-mm-dd): ");
        LocalDate expiry = LocalDate.parse(sc.nextLine());

        service.addLicense(new License(number, ownerId, type, issue, expiry));
    }

    private static void listLicenses() {
        List<License> list = service.getAllLicenses();
        list.forEach(System.out::println);
    }

    private static void getLicenseById() {
        System.out.print("Enter License ID: ");
        int id = sc.nextInt();
        License l = service.getLicenseById(id);
        System.out.println(l != null ? l : "License not found.");
    }

    private static void updateLicense() {
        System.out.print("Enter License ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Enter License Number: ");
        String number = sc.nextLine();
        System.out.print("Enter Owner ID: ");
        int ownerId = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Type: ");
        String type = sc.nextLine();
        System.out.print("Enter Issue Date (yyyy-mm-dd): ");
        LocalDate issue = LocalDate.parse(sc.nextLine());
        System.out.print("Enter Expiry Date (yyyy-mm-dd): ");
        LocalDate expiry = LocalDate.parse(sc.nextLine());

        service.updateLicense(new License(id, number, ownerId, type, issue, expiry));
    }

    private static void deleteLicense() {
        System.out.print("Enter License ID: ");
        int id = sc.nextInt();
        service.deleteLicense(id);
    }
}
