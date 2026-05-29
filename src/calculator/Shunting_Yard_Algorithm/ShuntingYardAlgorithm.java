package calculator.Shunting_Yard_Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

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
    }

}
