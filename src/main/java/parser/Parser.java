package parser;

import java.util.Arrays;
import java.util.HashMap;

public class Parser {

    /*
     * [CHECKED] přidat operátory * a /
     * operator priority (přednost násobení a dělení)
     * kontrola dělení 0
     * podpora operátoru mocniny ^
     * podpora závorek
     * podpora PI
     * podpora základních matematických funkcí
     */

    private String equation;
    private HashMap<String, Double> parameterMap;

    public Parser(String equation){
        this.equation = equation;
        this.parameterMap = new HashMap<>();
    }

    public void setParameter(String parameterName, double value){
        getParameterMap().put(parameterName, value);
    }

    public String getEquation() {
        return equation;
    }

    public HashMap<String, Double> getParameterMap() {
        return parameterMap;
    }

    public double getParameterValue(String parameter){
        return getParameterMap().getOrDefault(parameter, null);
    }

    public double calculate(){
        double result = 0d;
        String builder = getEquation().replaceAll(" ", "");
        System.out.println(builder);
        for(String parameter : getParameterMap().keySet()){
            builder = builder.replaceAll(parameter, String.valueOf(getParameterValue(parameter)));
        }
        System.out.println(builder);
        String[] charArray = builder.split("");
        System.out.println(Arrays.toString(charArray));
        String[] numberArray = builder.split("[-+*/]");
        System.out.println(Arrays.toString(numberArray));
        StringBuilder operatorsInString = new StringBuilder("");
        for(String character : charArray){
            if(Operator.isOperator(character)){
                operatorsInString.append(character);
            }
        }
        String[] operatorArray = operatorsInString.toString().split("");
        System.out.println(Arrays.toString(operatorArray));
        double number;
        int operatorId = 0;
        boolean resultIsSet = false;
        for(String stringNumber : numberArray){
            number = Double.parseDouble(stringNumber);
            if(!resultIsSet){
                resultIsSet = true;
                result = number;
                continue;
            }
            switch (Operator.getByString(operatorArray[operatorId])){
                case PLUS:
                    result += number;
                    break;
                case MINUS:
                    result -= number;
                    break;
                case MULTIPLE:
                    result *= number;
                    break;
                case DIVIDE:
                    result /= number;
                    break;
            }
            operatorId++;
        }
        return result;
    }

    @Override
    public String toString() {
        return equation;
    }
}
