package com.rto.ui;

import com.rto.model.Owner;
import com.rto.service.OwnerService;

import java.util.List;
import java.util.Scanner;

public class OwnerUI {
    private static OwnerService service = new OwnerService();
    private static Scanner sc = new Scanner(System.in);

    public static void showMenu() {
        while (true) {
            System.out.println("\n==== Owner Menu ====");
            System.out.println("1. Add Owner");
            System.out.println("2. View All Owners");
            System.out.println("3. View Owner by ID");
            System.out.println("4. Update Owner");
            System.out.println("5. Delete Owner");
            System.out.println("0. Back");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1: addOwner(); break;
                case 2: listOwners(); break;
                case 3: getOwnerById(); break;
                case 4: updateOwner(); break;
                case 5: deleteOwner(); break;
                case 0: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private static void addOwner() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        System.out.print("Enter phone: ");
        String phone = sc.nextLine();
        service.addOwner(new Owner(name, address, phone));
    }

    private static void listOwners() {
        List<Owner> list = service.getAllOwners();
        list.forEach(System.out::println);
    }

    private static void getOwnerById() {
        System.out.print("Enter owner id: ");
        int id = sc.nextInt();
        Owner o = service.getOwnerById(id);
        System.out.println(o != null ? o : "Owner not found.");
    }

    private static void updateOwner() {
        System.out.print("Enter owner id: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Enter new name: ");
        String name = sc.nextLine();
        System.out.print("Enter new address: ");
        String address = sc.nextLine();
        System.out.print("Enter new phone: ");
        String phone = sc.nextLine();
        service.updateOwner(new Owner(id, name, address, phone));
    }

    private static void deleteOwner() {
        System.out.print("Enter owner id: ");
        int id = sc.nextInt();
        service.deleteOwner(id);
    }
}
