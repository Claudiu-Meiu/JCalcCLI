package calculator.menu.basic;

import java.util.Scanner;

import calculator.Shunting_Yard_Algorithm.Evaluator;

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

            Evaluator.evaluate(expression);
        }
    }
}