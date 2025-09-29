package com.rto.ui.user;

import com.rto.model.License;
import com.rto.service.LicenseService;

import java.util.Scanner;

public class UserLicenseUI {
    private static final LicenseService service = new LicenseService();
    private static final Scanner sc = new Scanner(System.in);

    public static void showMenu() {
        System.out.print("Enter your License ID: ");
        int id = sc.nextInt();
        License l = service.getLicenseById(id);

        if (l != null) {
            System.out.println("=== Your License Details ===");
            System.out.println(l);
        } else {
            System.out.println("❌ License not found!");
        }
    }
}
