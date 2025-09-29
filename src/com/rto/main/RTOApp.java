package com.rto.main;

import com.rto.ui.OwnerUI;
import com.rto.ui.VehicleUI;
import com.rto.ui.LicenseUI;
import com.rto.ui.RegistrationUI;
import com.rto.ui.FineUI;

import java.util.Scanner;

public class RTOApp {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== RTO Management System =====");
            System.out.println("1. Manage Owners");
            System.out.println("2. Manage Vehicles");
            System.out.println("3. Manage Licenses");
            System.out.println("4. Manage Registrations");
            System.out.println("5. Manage Fines");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    OwnerUI.showMenu();
                    break;
                case 2:
                    VehicleUI.showMenu();
                    break;
                case 3:
                    LicenseUI.showMenu();
                    break;
                case 4:
                    RegistrationUI.showMenu();
                    break;
                case 5:
                    FineUI.showMenu();
                    break;
                case 0:
                    System.out.println("👋 Exiting RTO Management System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("❌ Invalid choice. Please try again.");
            }
        }
    }
}
