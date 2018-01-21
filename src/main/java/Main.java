import parser.Parser;

public class Main {

    public static void main(String[] args){
        /*System.out.println(obsahObdelnika(83, 13));
        System.out.println(obsahObdelnika(21, 44));
        System.out.println(obsahObdelnika(21, 43));
        System.out.println(obsahObdelnika(92.438612d, 32.82d));*/

        /*System.out.println(trojuhelnikovaNerovnost(3, 5, 2));
        System.out.println(trojuhelnikovaNerovnost(9, 7, 1));
        System.out.println(trojuhelnikovaNerovnost(5, 1, 7));
        System.out.println(trojuhelnikovaNerovnost(6, 6, 6));
        System.out.println(trojuhelnikovaNerovnost(5, 4, 6));*/

        /*System.out.println(vzdalenostSikmehoVrhu(100, 15));
        System.out.println(vzdalenostSikmehoVrhu(100, 30));
        System.out.println(vzdalenostSikmehoVrhu(100, 45));
        System.out.println(vzdalenostSikmehoVrhu(100, 60));
        System.out.println(vzdalenostSikmehoVrhu(100, 90));*/

        Parser parser = new Parser("a + b-1");
        parser.setParameter("a", 4);
        parser.setParameter("b", 5);
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
     *
     * @param rychlost rychlost tělesa
     * @param uhel úhel tělesa na začátku vrhu
     * @return vzdálenost doletu tělesa
     */
    private static double vzdalenostSikmehoVrhu(double rychlost, int uhel){
        double angolarRadians = Math.toRadians(uhel);
        return (Math.pow(rychlost, 2) / G) * Math.sin(2 * angolarRadians);
    }
}
