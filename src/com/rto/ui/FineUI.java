package com.rto.ui;

import com.rto.model.Fine;
import com.rto.service.FineService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class FineUI {
    private static final FineService service = new FineService();
    private static final Scanner sc = new Scanner(System.in);

    public static void showMenu() {
        while (true) {
            System.out.println("\n==== Fine Management ====");
            System.out.println("1. Add Fine");
            System.out.println("2. View Fine by ID");
            System.out.println("3. View All Fines");
            System.out.println("4. Update Fine");
            System.out.println("5. Delete Fine");
            System.out.println("6. View Fines by Owner ID");
            System.out.println("7. Back");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addFine();
                case 2 -> getFineById();
                case 3 -> getAllFines();
                case 4 -> updateFine();
                case 5 -> deleteFine();
                case 6 -> getFinesByOwnerId();
                case 7 -> { return; }
                default -> System.out.println("❌ Invalid choice!");
            }
        }
    }

    private static void addFine() {
        System.out.print("Enter Owner ID: ");
        int ownerId = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Reason: ");
        String reason = sc.nextLine();
        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble(); sc.nextLine();
        LocalDate date = LocalDate.now(); // auto set to today
        service.addFine(new Fine(ownerId, reason, amount, date));
    }

    private static void getFineById() {
        System.out.print("Enter Fine ID: ");
        int id = sc.nextInt();
        Fine f = service.getFineById(id);
        System.out.println(f != null ? f : "❌ Not found!");
    }

    private static void getAllFines() {
        List<Fine> list = service.getAllFines();
        if (list.isEmpty()) System.out.println("❌ No fines found.");
        else list.forEach(System.out::println);
    }

    private static void updateFine() {
        System.out.print("Enter Fine ID to update: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Enter New Owner ID: ");
        int ownerId = sc.nextInt(); sc.nextLine();
        System.out.print("Enter New Reason: ");
        String reason = sc.nextLine();
        System.out.print("Enter New Amount: ");
        double amount = sc.nextDouble(); sc.nextLine();
        LocalDate date = LocalDate.now();
        service.updateFine(new Fine(id, ownerId, reason, amount, date));
    }

    private static void deleteFine() {
        System.out.print("Enter Fine ID to delete: ");
        int id = sc.nextInt();
        service.deleteFine(id);
    }

    private static void getFinesByOwnerId() {
        System.out.print("Enter Owner ID: ");
        int ownerId = sc.nextInt();
        List<Fine> list = service.getFinesByOwnerId(ownerId);
        if (list.isEmpty()) System.out.println("❌ No fines found for this owner.");
        else list.forEach(System.out::println);
    }
}
