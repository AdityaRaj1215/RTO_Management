package com.rto.ui.user;

import com.rto.model.Vehicle;
import com.rto.service.VehicleService;

import java.util.Scanner;

public class UserVehicleUI {
    private static final VehicleService service = new VehicleService();
    private static final Scanner sc = new Scanner(System.in);

    public static void showMenu() {
        System.out.print("Enter your Vehicle ID: ");
        int id = sc.nextInt();
        Vehicle v = service.getVehicleById(id);

        if (v != null) {
            System.out.println("=== Your Vehicle Details ===");
            System.out.println(v);
        } else {
            System.out.println("❌ Vehicle not found!");
        }
    }
}
