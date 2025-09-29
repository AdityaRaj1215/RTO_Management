package com.rto.ui.user;

import com.rto.model.Fine;
import com.rto.service.FineService;

import java.util.List;
import java.util.Scanner;

public class UserFineUI {
    private static final FineService service = new FineService();
    private static final Scanner sc = new Scanner(System.in);

    public static void showMenu() {
        System.out.print("Enter your Owner ID to view fines: ");
        int ownerId = sc.nextInt();
        List<Fine> fines = service.getFinesByOwnerId(ownerId);

        if (fines.isEmpty()) {
            System.out.println("✅ No fines found!");
        } else {
            System.out.println("=== Your Fines ===");
            fines.forEach(System.out::println);
        }
    }
}
