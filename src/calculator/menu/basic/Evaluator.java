package calculator.menu.basic;

import java.util.List;

import calculator.Shunting_Yard_Algorithm.Parser;

public class Evaluator {

    public static void evaluate(String expression) {
        List<String> reversedPolishNotation = Parser.parse(expression);

        System.out.println(reversedPolishNotation);
    }
}
