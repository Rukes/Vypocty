package parser;

import parser.functionality.Functionality;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Parser {

    /*
     * [CHECKED] přidat operátory * a /
     * [CHECKED] podpora operátoru mocniny ^
     * operator priority (přednost mocniny, násobení a dělení)
     * kontrola dělení 0
     * podpora závorek
     * podpora PI
     * podpora základních matematických funkcí
     * exception
     */

    private String equation;
    private HashMap<String, Double> parameterMap;
    private List<Functionality> functionalityList;

    public Parser(String equation){
        this.equation = equation;
        this.parameterMap = new HashMap<>();
        functionalityList = new ArrayList<>();
    }

    public void setParameter(String parameterName, double value){
        getParameterMap().put(parameterName, value);
    }

    public void registerFunctionality(Functionality... functionalities){
        for(Functionality functionality : functionalities){
            if(getFunctionalityList().contains(functionality)){
                continue;
            }
            getFunctionalityList().add(functionality);
        }
    }

    public String getEquation() {
        return equation;
    }

    public HashMap<String, Double> getParameterMap() {
        return parameterMap;
    }

    public List<Functionality> getFunctionalityList() {
        return functionalityList;
    }

    public double getParameterValue(String parameter){
        return getParameterMap().getOrDefault(parameter, null);
    }

    @Override
    public String toString() {
        return equation;
    }

    public double calculate(){
        double result = 0d;
        String builder = getEquation().trim().replaceAll(" ", "");
        System.out.println(builder);
        builder = formatFunctionalities(builder);
        System.out.println(builder);
        for(String parameter : getParameterMap().keySet()){
            builder = builder.replaceAll(parameter, String.valueOf(getParameterValue(parameter)));
        }
        String[] charArray = builder.split("");
        System.out.println(Arrays.toString(charArray));
        String[] numberArray = builder.split("[-+*/^]");
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
            System.out.println(result);
            if(!resultIsSet){
                resultIsSet = true;
                result = number;
                continue;
            }
            switch (Operator.getByString(operatorArray[operatorId])){
                case POWER:
                    result = Math.pow(result, number);
                    break;
                case MULTIPLE:
                    result *= number;
                    break;
                case DIVIDE:
                    result /= number;
                    break;
                case PLUS:
                    result += number;
                    break;
                case MINUS:
                    result -= number;
                    break;
            }
            operatorId++;
        }
        return result;
    }

    private String formatFunctionalities(String builder){
        if(getFunctionalityList().isEmpty()){
            return builder;
        }
        for(Functionality functionality : getFunctionalityList()){
            builder = functionality.getEvaluation().evaluateEquation(builder);
        }
        return builder;
    }
}
