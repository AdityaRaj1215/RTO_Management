package com.rto.main;

import com.rto.service.LoginService;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LoginService loginService = new LoginService();

        System.out.println("==== RTO Management System ====");
        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        String role = loginService.login(username, password);

        if (role == null) {
            System.out.println("❌ Invalid credentials!");
        } else if (role.equals("ADMIN")) {
            System.out.println("✅ Welcome Admin!");
            RTOApp.main(null);   // launch Admin-side menu
        } else if (role.equals("USER")) {
            System.out.println("✅ Welcome User!");
            UserApp.main(null);  // launch User-side menu
        }
    }
}
