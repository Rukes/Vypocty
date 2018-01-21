package parser;

import java.util.HashMap;

public enum Operator {

    POWER("^"),
    MULTIPLE("*"),
    DIVIDE("/"),
    PLUS("+"),
    MINUS("-");

    private String symbol;
    private static HashMap<String, Operator> getByString;

    static {
        getByString = new HashMap<>();
        for(Operator operator : values()){
            getByString.put(operator.getSymbol(), operator);
        }
    }

    Operator(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public static boolean isOperator(String value){
        return getByString.containsKey(value);
    }

    public static Operator getByString(String value){
        return getByString.getOrDefault(value, null);
    }
}
