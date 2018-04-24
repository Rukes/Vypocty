import java.util.Calendar;
import java.util.HashMap;

public class GeneratorZkouseni {

    private HashMap<Integer, String> studentList;
    private HashMap<String, Integer> possibilities;
    private int studentId;
    private Calendar calendar;

    GeneratorZkouseni(){
        studentList = new HashMap<>();
        possibilities = new HashMap<>();
        studentId = 0;
        calendar = Calendar.getInstance();

        getStudentList().put(getNextId(), "Bajko");
        getStudentList().put(getNextId(), "Beneš");
        getStudentList().put(getNextId(), "Bulín");
        getStudentList().put(getNextId(), "Dvořák");
        getStudentList().put(getNextId(), "Havelka");
        getStudentList().put(getNextId(), "Horák");
        getStudentList().put(getNextId(), "Jarolímek");
        getStudentList().put(getNextId(), "Jaroň");
        getStudentList().put(getNextId(), "Kalabis");
        getStudentList().put(getNextId(), "Kollmann");
        getStudentList().put(getNextId(), "Kortan");
        getStudentList().put(getNextId(), "Kunert");
        getStudentList().put(getNextId(), "Lukeš");
        getStudentList().put(getNextId(), "Malár");
        getStudentList().put(getNextId(), "Merhaut");
        getStudentList().put(getNextId(), "Muller");
        getStudentList().put(getNextId(), "Novák");
        getStudentList().put(getNextId(), "Ondrušek");
        getStudentList().put(getNextId(), "Rossiwal");
        getStudentList().put(getNextId(), "Řezníček");
        getStudentList().put(getNextId(), "Řeznik");
        getStudentList().put(getNextId(), "Říčka");
        getStudentList().put(getNextId(), "Soukup");
        getStudentList().put(getNextId(), "Stanislav");
        getStudentList().put(getNextId(), "Tesař");
        getStudentList().put(getNextId(), "Tomášek");
        getStudentList().put(getNextId(), "Vocilka");

        getPossibilities().put("Den v měsíci", getDay());
        getPossibilities().put("Měsíc", getMonth());
        getPossibilities().put("Součet den + měsíc", getDay() + getMonth());
        getPossibilities().put("Suma cifer roku", getDigitSum(getYear()));
        getPossibilities().put("Suma cifer měsíce", getDigitSum(getMonth()));
        getPossibilities().put("Suma cifer dne", getDigitSum(getDay()));
        getPossibilities().put("Suma cifer dne a měsíce", getDigitSum(getDay()) + getDigitSum(getMonth()));
        getPossibilities().put("Suma cifer dne + měsíce", getDigitSum(getDay() + getMonth()));
        getPossibilities().put("Suma cifer celého datumu postupně", getDigitSum(getDay()) + getDigitSum(getMonth()) + getDigitSum(getYear()));
        getPossibilities().put("Suma cifer celého datumu součtem", getDigitSum(getDay() + getMonth() + getYear()));

        System.out.println("[ " + getDay() + "." + getMonth() + ". " + getYear() + " ]");
        for(String type : getPossibilities().keySet()){
            int id = getPossibilityId(type);
            System.out.println(type + " (" + id + "): " + getStudentById(id));
        }
    }

    private HashMap<Integer, String> getStudentList() {
        return studentList;
    }

    private String getStudentById(int id){
        return getStudentList().getOrDefault(id, "Nikdo");
    }

    private HashMap<String, Integer> getPossibilities() {
        return possibilities;
    }

    private int getPossibilityId(String possibility){
        return getPossibilities().getOrDefault(possibility, -1);
    }

    private int getNextId(){
        studentId++;
        return studentId;
    }

    private int getDay(){
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    private int getMonth(){
        return calendar.get(Calendar.MONTH) + 1;
    }

    private int getYear(){
        return calendar.get(Calendar.YEAR);
    }

    private int getDigitSum(int i){
        int sum = 0;
        while (i > 0) {
            sum = sum + i % 10;
            i = i / 10;
        }
        return sum;
    }
}
