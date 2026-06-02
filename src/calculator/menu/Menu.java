package calculator.menu;

import java.util.Scanner;

import calculator.menu.advanced.Advanced;
import calculator.menu.basic.Basic;

public class Menu {

    public static void run(Scanner scanner) {
        while (true) {
            System.out.println("\n1. Basic");
            System.out.println("2. Advanced");
            System.out.println("0. Exit");

            System.out.print("\nChoice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> Basic.run(scanner);
                case "2" -> Advanced.run(scanner);
                case "0" -> {
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    public static void help() {
        System.out.println("(m, menu) = Menu");
    }
}
