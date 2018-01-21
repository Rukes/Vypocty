package parser.functionality.type;

import parser.functionality.FunctionalityEvaluation;

public class FunctionalityPI implements FunctionalityEvaluation {

    @Override
    public String evaluateEquation(String input) {
        if(input.toLowerCase().contains("pi")){
            return input.replaceAll("(?i)pi", String.valueOf(Math.PI));
        }
        return input;
    }
}
