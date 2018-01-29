import parser.Parser;
import parser.functionality.Functionality;

public class Main {

    public static void main(String[] args){
        Parser parser = new Parser("a+b*c+d-e+f/g^2+PI/EL");
        parser.setParameter("a", 4);
        parser.setParameter("b", 5);
        parser.setParameter("c", 2);
        parser.setParameter("d", 3);
        parser.setParameter("e", 1);
        parser.setParameter("f", 3);
        parser.setParameter("g", 4);
        parser.registerFunctionality(Functionality.PI, Functionality.EULER_NUMBER);
        double result = parser.calculate();
        System.out.println(String.format("Result: %s", result));
    }

    /**
     * Výpočet obsahu obdélníka o stranách a & b
     * @param a strana obdelníku a
     * @param b strana obdelníku b
     * @return obsah
     */
    private static double obsahObdelnika(double a, double b){
        if(a <= 0 || b <= 0){
            return 0;
        }
        return a * b;
    }

    /**
     * Kontrola trojúhelníkové nerovnosti
     * @param a strana trojúhelníku a
     * @param b strana trojúhelníku b
     * @param c strana trojúhelníku b
     * @return false pokud je jedna ze stran menší nebo rovna 0 nebo pokud neplatí trojúhelníková nerovnost, true pokud platí trojúhelníková nerovnost
     */
    private static boolean trojuhelnikovaNerovnost(double a, double b, double c){
        return !(a <= 0 || b <= 0 || c <= 0 || a + b <= c || b + c <= a || a + c <= b);
    }

    private static final double G = 9.823;

    /**
     * Výpočet vzdálenosti šikmého vrhu
     * @param rychlost rychlost tělesa
     * @param uhel úhel tělesa na začátku vrhu
     * @return vzdálenost doletu tělesa
     */
    private static double vzdalenostSikmehoVrhu(double rychlost, int uhel){
        double angolarRadians = Math.toRadians(uhel);
        return (Math.pow(rychlost, 2) / G) * Math.sin(2 * angolarRadians);
    }

    /**
     * Výpočet úhlu sinus trojúhelníku
     * @param x jedna strana trojúhelníku
     * @param y druhá strana trojúhelníku
     * @return sinus úhlu ve stupních
     */
    private static double vypocetUheluSinu(double x, double y){
        if(x == y){
            throw new IllegalArgumentException("Čísla nesmí být rovna!");
        }
        if(x <= 0 || y <= 0){
            throw new IllegalArgumentException("Čísla nesmí být menší nebo rovna nule!");
        }
        double odvesna;
        double prepona;
        if(x > y){
            odvesna = y;
            prepona = x;
        }else{
            odvesna = x;
            prepona = y;
        }
        double arcosine = Math.asin(odvesna/prepona);
        return Math.toDegrees(arcosine);
    }

    /**
     * Výpočet kořenů kvadratické rovnice
     * @param a kvadratický člen
     * @param b lineární člen
     * @param c absolutní člen
     * @return array kořenů kvadratické rovnice
     */
    private static double[] korenyKvadratickeRovnice(double a, double b, double c){
        double d = Math.pow(b, 2) - 4 * a * c;
        if(d < 0){
            return new double[0];
        }
        double[] koreny;
        if(d == 0){
            koreny = new double[1];
            koreny[0] = (-b + Math.pow(d, 1/2)) / (2*a);
        }else{
            koreny = new double[2];
            koreny[0] = (-b + Math.pow(d, 1/2)) / (2*a);
            koreny[1] = (-b - Math.pow(d, 1/2)) / (2*a);
        }
        return koreny;
    }

    /**
     * Kontrola, zda-li strany trojúhelkůku jsou strany pravoúhlého trojúhelníku
     * @param odvesna1 první odvěsna trojúhelníku
     * @param odvesna2 druhá odvěsna trojúhelníku
     * @param prepona přepona trojúhelníku
     * @return false pokud je jedna ze stran menší nebo rovna nule, false pokud jsou si odvěsny rovny, false pokud je přepona menší než jedna z odvěsen, true v opačných případech
     */
    private static boolean jsouStranyPravouhlehoTrojuhelniku(double odvesna1, double odvesna2, double prepona){
        return !(odvesna1 <= 0 || odvesna2 <= 0 || prepona <= 0 || odvesna1 == odvesna2 || odvesna1 > prepona || odvesna2 > prepona);
    }
}
