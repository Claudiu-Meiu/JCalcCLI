package calculator.menu.basic;

import java.util.Scanner;

public class Basic {

    public static void run(Scanner scanner) {
        while (true) {
            System.out.print("\nBasic (+, -, *, /): ");
            String expression = scanner.nextLine();

            switch (expression) {
                case "m", "menu" -> {
                    return;
                }
            }

            Evaluator.printResult(expression);
        }
    }
}