package parser.functionality.type;

import parser.functionality.FunctionalityEvaluation;

public class FunctionalityEulerNumber implements FunctionalityEvaluation {

    @Override
    public String evaluateEquation(String input) {
        if(input.toLowerCase().contains("el")){
            return input.replaceAll("(?i)el", String.valueOf(Math.E));
        }
        return input;
    }
}
