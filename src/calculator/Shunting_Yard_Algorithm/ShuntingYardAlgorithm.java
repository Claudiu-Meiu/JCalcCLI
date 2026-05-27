package calculator.Shunting_Yard_Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShuntingYardAlgorithm {

    public static void calculateBasic(String expression) {

        List<String> tokens = new ArrayList<>();
        List<String> output = new ArrayList<>();
        List<String> holdingStack = new ArrayList<>();

        Matcher matcher = Pattern.compile("\\d+|[+\\-*/]").matcher(expression);

        while (matcher.find()) {
            tokens.add(matcher.group());
        }

        for (String token : tokens) {
            if (token.matches("-?\\d+(\\.\\d+)?")) {
                output.add(token);
            }
        }

        System.out.println();
        System.out.println("TOKENS: " + tokens);
        System.out.println("OUTPUT: " + output);
        System.out.println("HOLDING STACK: " + holdingStack);
        System.out.println("RESULT: ");
    }

}
