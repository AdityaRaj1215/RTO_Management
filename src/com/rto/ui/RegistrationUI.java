package com.rto.ui;

import com.rto.model.Registration;
import com.rto.service.RegistrationService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class RegistrationUI {
    private static RegistrationService service = new RegistrationService();
    private static Scanner sc = new Scanner(System.in);

    public static void showMenu() {
        while (true) {
            System.out.println("\n==== Registration Menu ====");
            System.out.println("1. Add Registration");
            System.out.println("2. View All Registrations");
            System.out.println("3. View Registration by ID");
            System.out.println("4. Update Registration");
            System.out.println("5. Delete Registration");
            System.out.println("0. Back");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1: addRegistration(); break;
                case 2: listRegistrations(); break;
                case 3: getRegistrationById(); break;
                case 4: updateRegistration(); break;
                case 5: deleteRegistration(); break;
                case 0: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private static void addRegistration() {
        System.out.print("Enter Vehicle ID (must exist): ");
        int vehicleId = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Registration Date (yyyy-mm-dd): ");
        LocalDate regDate = LocalDate.parse(sc.nextLine());
        System.out.print("Enter Expiry Date (yyyy-mm-dd): ");
        LocalDate expiryDate = LocalDate.parse(sc.nextLine());

        service.addRegistration(new Registration(vehicleId, regDate, expiryDate));
    }

    private static void listRegistrations() {
        List<Registration> list = service.getAllRegistrations();
        list.forEach(System.out::println);
    }

    private static void getRegistrationById() {
        System.out.print("Enter Registration ID: ");
        int id = sc.nextInt();
        Registration r = service.getRegistrationById(id);
        System.out.println(r != null ? r : "Registration not found.");
    }

    private static void updateRegistration() {
        System.out.print("Enter Registration ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Vehicle ID: ");
        int vehicleId = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Registration Date (yyyy-mm-dd): ");
        LocalDate regDate = LocalDate.parse(sc.nextLine());
        System.out.print("Enter Expiry Date (yyyy-mm-dd): ");
        LocalDate expiryDate = LocalDate.parse(sc.nextLine());

        service.updateRegistration(new Registration(id, vehicleId, regDate, expiryDate));
    }

    private static void deleteRegistration() {
        System.out.print("Enter Registration ID: ");
        int id = sc.nextInt();
        service.deleteRegistration(id);
    }
}
