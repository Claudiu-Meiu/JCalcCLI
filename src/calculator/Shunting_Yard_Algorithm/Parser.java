package calculator.Shunting_Yard_Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import calculator.Shunting_Yard_Algorithm.enums.Associativity;
import calculator.Shunting_Yard_Algorithm.records.OperatorRecord;

public class Parser {

    private static final Map<String, OperatorRecord> OPERATORS = Map.of(
            "-", new OperatorRecord("-", 1, Associativity.LEFT_TO_RIGHT),
            "+", new OperatorRecord("+", 1, Associativity.LEFT_TO_RIGHT),
            "*", new OperatorRecord("*", 2, Associativity.LEFT_TO_RIGHT),
            "/", new OperatorRecord("/", 2, Associativity.LEFT_TO_RIGHT));

    public static List<String> parse(String expression) {
        List<String> tokens = Lexer.tokenize(expression);
        Stack<OperatorRecord> operators = new Stack<>();
        List<String> output = new ArrayList<>();

        for (String token : tokens) {
            if (!OPERATORS.containsKey(token)) {
                output.add(token);
            } else {
                OperatorRecord operator = OPERATORS.get(token);

                while (!operators.isEmpty()) {
                    OperatorRecord lastOperator = operators.getLast();

                    boolean higherPrecedence = lastOperator.priority() > operator.priority();

                    boolean equalPrecedenceAndLeftToRightAssociation = lastOperator.priority() == operator.priority()
                            && operator.associativity() == Associativity.LEFT_TO_RIGHT;

                    if (higherPrecedence || equalPrecedenceAndLeftToRightAssociation) {
                        output.add(operators.pop().symbol());
                    } else {
                        break;
                    }
                }
                operators.push(operator);
            }
        }

        while (!operators.isEmpty()) {
            output.add(operators.pop().symbol());
        }

        System.out.println(operators);
        return output;
    }
}
