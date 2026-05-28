package calculator.Shunting_Yard_Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShuntingYardAlgorithm {

    private record OperatorRecord(String operator, int precedence, int arguments) {
    }

    public static void calculateBasic(String expression) {

        List<String> tokens = new ArrayList<>();
        Stack<String> reversedPolishNotation = new Stack<>();
        Stack<OperatorRecord> operators = new Stack<>();

        HashMap<String, OperatorRecord> operatorsMap = new HashMap<>();
        operatorsMap.put("-", new OperatorRecord("-", 1, 2));
        operatorsMap.put("+", new OperatorRecord("+", 2, 2));
        operatorsMap.put("*", new OperatorRecord("*", 3, 2));
        operatorsMap.put("/", new OperatorRecord("/", 4, 2));

        Matcher matcher = Pattern.compile("\\d+|[+\\-*/]").matcher(expression);

        while (matcher.find()) {
            tokens.add(matcher.group());
        }

        for (String token : tokens) {
            switch (token) {
                case "-":
                    OperatorRecord minus = operatorsMap.get("-");

                    if (operators.isEmpty() || minus.precedence >= operators.getLast().precedence) {
                        operators.push(minus);
                    } else {
                        for (int i = 0; i < operators.size();) {
                            if (minus.precedence < operators.getLast().precedence) {
                                reversedPolishNotation.push(operators.pop().operator);
                            }
                        }
                        operators.push(minus);
                    }
                    break;

                case "+":
                    OperatorRecord plus = operatorsMap.get("+");

                    if (operators.isEmpty() || plus.precedence >= operators.getLast().precedence) {
                        operators.push(plus);
                    } else {
                        for (int i = 0; i < operators.size();) {
                            if (plus.precedence < operators.getLast().precedence) {
                                reversedPolishNotation.push(operators.pop().operator);
                            }
                        }
                        operators.push(plus);
                    }
                    break;

                case "*":
                    OperatorRecord multiply = operatorsMap.get("*");

                    if (operators.isEmpty() || multiply.precedence >= operators.getLast().precedence) {
                        operators.push(multiply);
                    } else {
                        for (int i = 0; i < operators.size();) {
                            if (multiply.precedence < operators.getLast().precedence) {
                                reversedPolishNotation.push(operators.pop().operator);
                            }
                        }
                        operators.push(multiply);
                    }
                    break;

                default:
                    if (token.matches("-?\\d+(\\.\\d+)?")) {
                        reversedPolishNotation.push(token);
                    }
                    break;
            }
        }

        for (int i = 0; i < operators.size();) {
            reversedPolishNotation.push(operators.pop().operator);
        }

        System.out.println("\nTOKENS = " + tokens);
        System.out.println("OPERATORS = " + operators);
        System.out.println("RPN = " + reversedPolishNotation);
        System.out.println("RESULT = ");
    }

}
