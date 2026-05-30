package calculator.Shunting_Yard_Algorithm;

import java.util.List;

public class ExpressionParser {

    public static void parse(String expression) {

        List<String> tokens = Lexer.tokenize(expression);

        System.out.println(tokens);
    }
}
