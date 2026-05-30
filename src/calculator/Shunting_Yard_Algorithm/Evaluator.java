package calculator.Shunting_Yard_Algorithm;

public class Evaluator {

    public static void evaluate(String expression) {
        
        ExpressionParser.parse(expression);
    }
}
