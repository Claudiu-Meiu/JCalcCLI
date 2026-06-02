package calculator.menu.basic;

import java.util.List;
import java.util.Stack;

import calculator.Shunting_Yard_Algorithm.Parser;

public class Evaluator {

    private static double evaluate(String expression) {
        List<String> reversedPolishNotation = Parser.parse(expression);
        Stack<Double> compute = new Stack<>();

        for (String token : reversedPolishNotation) {
            switch (token) {
                case "-", "+", "*", "/":
                    applyOperator(compute, token);
                    break;
                default:
                    compute.push(Double.parseDouble(token));
                    break;
            }
        }
        return compute.pop();
    }

    private static void applyOperator(Stack<Double> compute, String operator) {
        double right = compute.pop();
        double left = compute.pop();

        switch (operator) {
            case "-":
                compute.push(left - right);
                break;
            case "+":
                compute.push(left + right);
                break;
            case "*":
                compute.push(left * right);
                break;
            case "/":
                compute.push(left / right);
                break;
            default:
                break;
        }
    }

    public static void printResult(String expression) {
        System.out.println("\n= " + evaluate(expression));
    }
}
