package calculator.Shunting_Yard_Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShuntingYardAlgorithm {

    private record operatorRecord(int precedence, int arguments) {
    }

    public static void calculateBasic(String expression) {

        List<String> tokens = new ArrayList<>();
        List<String> output = new ArrayList<>();
        List<String> holdingStack = new ArrayList<>();

        HashMap<String, operatorRecord> operatorsMap = new HashMap<>();
        operatorsMap.put("-", new operatorRecord(1, 2));
        operatorsMap.put("+", new operatorRecord(2, 2));
        operatorsMap.put("*", new operatorRecord(3, 2));
        operatorsMap.put("/", new operatorRecord(4, 2));

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
        System.out.println(operatorsMap);
        System.out.println("TOKENS: " + tokens);
        System.out.println("OUTPUT: " + output);
        System.out.println("HOLDING STACK: " + holdingStack);
        System.out.println("RESULT: ");
    }

}
