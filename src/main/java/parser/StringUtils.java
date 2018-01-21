package parser;

public class StringUtils {

    public static boolean arrayContainsValue(String[] array, String value){
        for(String arrayValue : array){
            if(arrayValue.equals(value)){
                return true;
            }
        }
        return false;
    }

    public static int getValuePositionInArray(String[] array, String value){
        String arrayValue;
        for(int i = 0; i < array.length; i++){
            arrayValue = array[i];
            if(arrayValue.equals(value)){
                return i;
            }
        }
        return -1;
    }
}
