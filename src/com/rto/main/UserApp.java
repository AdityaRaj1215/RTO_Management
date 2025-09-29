package com.rto.main;

import com.rto.ui.FineUI;
import com.rto.ui.user.UserVehicleUI;
import com.rto.ui.user.UserLicenseUI;
import com.rto.ui.user.UserFineUI;

import java.util.Scanner;

public class UserApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== User Portal ====");
            System.out.println("1. View My Vehicle");
            System.out.println("2. View My License");
            System.out.println("3. View My Fines");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    UserVehicleUI vehicleUI = new UserVehicleUI();
                    vehicleUI.showMenu();
                }
                case 2 -> {
                    UserLicenseUI licenseUI = new UserLicenseUI();
                    licenseUI.showMenu();
                }
                case 3 -> {
                    UserFineUI fineUI = new UserFineUI();   // ✅ initialize here
                    fineUI.showMenu();
                }
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("❌ Invalid choice!");
            }


            sc.nextLine();

            FineUI UserFineUI;
        }
    }
}
