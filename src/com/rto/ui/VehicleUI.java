package com.rto.ui;

import com.rto.model.Vehicle;
import com.rto.service.VehicleService;

import java.util.List;
import java.util.Scanner;

public class VehicleUI {
    private static final VehicleService service = new VehicleService();
    private static final Scanner sc = new Scanner(System.in);

    public static void showMenu() {
        while (true) {
            System.out.println("\n==== Vehicle Management ====");
            System.out.println("1. Add Vehicle");
            System.out.println("2. View Vehicle by ID");
            System.out.println("3. View All Vehicles");
            System.out.println("4. Update Vehicle");
            System.out.println("5. Delete Vehicle");
            System.out.println("6. Back");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addVehicle();
                case 2 -> getVehicleById();
                case 3 -> getAllVehicles();
                case 4 -> updateVehicle();
                case 5 -> deleteVehicle();
                case 6 -> { return; }
                default -> System.out.println("❌ Invalid choice!");
            }
        }
    }

    private static void addVehicle() {
        System.out.print("Enter Reg No: ");
        String regNo = sc.nextLine();
        System.out.print("Enter Type: ");
        String type = sc.nextLine();
        System.out.print("Enter Model: ");
        String model = sc.nextLine();
        System.out.print("Enter Owner ID: ");
        int ownerId = sc.nextInt();
        sc.nextLine();
        service.addVehicle(new Vehicle(regNo, type, model, ownerId));
    }

    private static void getVehicleById() {
        System.out.print("Enter Vehicle ID: ");
        int id = sc.nextInt();
        Vehicle v = service.getVehicleById(id);
        System.out.println(v != null ? v : "❌ Not found!");
    }

    private static void getAllVehicles() {
        List<Vehicle> list = service.getAllVehicles();
        if (list.isEmpty()) System.out.println("❌ No vehicles found.");
        else list.forEach(System.out::println);
    }

    private static void updateVehicle() {
        System.out.print("Enter Vehicle ID to update: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Enter New Reg No: ");
        String regNo = sc.nextLine();
        System.out.print("Enter New Type: ");
        String type = sc.nextLine();
        System.out.print("Enter New Model: ");
        String model = sc.nextLine();
        System.out.print("Enter New Owner ID: ");
        int ownerId = sc.nextInt();
        sc.nextLine();
        service.updateVehicle(new Vehicle(id, regNo, type, model, ownerId));
    }

    private static void deleteVehicle() {
        System.out.print("Enter Vehicle ID to delete: ");
        int id = sc.nextInt();
        service.deleteVehicle(id);
    }
}
