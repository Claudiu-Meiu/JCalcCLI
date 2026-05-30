package calculator.Shunting_Yard_Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calculator.Shunting_Yard_Algorithm.enums.TokenType;

public class Lexer {

    public static List<String> tokenize(String expression) {

        List<String> tokens = new ArrayList<>();
        Pattern tokenPattern = Pattern.compile(
                patterns().get(TokenType.NUMBER).pattern() + "|" +
                        patterns().get(TokenType.SYMBOL).pattern());

        Matcher tokenMatcher = tokenPattern.matcher(expression);

        while (tokenMatcher.find()) {
            tokens.add(tokenMatcher.group());
        }

        return tokens;
    }

    private static Map<TokenType, Pattern> patterns() {
        Map<TokenType, Pattern> patterns = new HashMap<>();
        patterns.put(TokenType.NUMBER, Pattern.compile("\\d+\\.\\d+|\\d+"));
        patterns.put(TokenType.SYMBOL, Pattern.compile("[\\-+*/]"));

        return patterns;
    }
}
