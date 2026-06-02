package calculator;

import java.util.Scanner;

import calculator.menu.Menu;

public class JCalcCLI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Menu.run(scanner);

        scanner.close();
    }
}
