package calculator.Shunting_Yard_Algorithm.records;

import calculator.Shunting_Yard_Algorithm.enums.Associativity;

public record OperatorRecord(String symbol, int priority, Associativity associativity) {

}
