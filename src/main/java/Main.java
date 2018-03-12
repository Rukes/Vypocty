public class Main {

    public static void main(String[] args){
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

    /**
     * Součet všech číselných parametrů programu
     * @param args Parametry vstupující do programu, známé jako main(String[] args)
     */
    private static void soucetArgumentuProgramu(String[] args){
        if(args.length <= 0){
            System.out.println("Je potřeba zadat číselné parametry pro výpočet součtu.");
            return;
        }
        double soucet = 0;
        double number;
        for (String argument : args) {
            try {
                number = Double.parseDouble(argument);
            } catch (NumberFormatException ex) {
                System.out.println("Chyba! Zadaná hodnota (" + argument + ") není číslo.");
                continue;
            }
            soucet += number;
        }
        System.out.println("Součet čísel je "+soucet);
    }

    /**
     * Sinus čísla
     * @param a vstupní číslo
     * @return sinus čísla
     */
    private static double sinus(double a){
        double radians = Math.toRadians(a);
        return Math.sin(a);
    }

    /**
     * Výpočet logaritmu o základu 10
     * @param a vstupní číslo (musí být větší jak 0)
     * @return výpočet logaritmu o základu 10
     */
    private static double logaritmus(double a){
        if(a <= 0){
            throw new IllegalArgumentException("Hodnota nesmí být menší nebo rovna nule!");
        }
        return Math.log10(a);
    }

    /**
     * Výpočet opačného čísla
     * @param a vstupní čílo
     * @return opačné číslo ke vstupnímu parametru
     */
    private static double flipNumber(double a){
        return -a;
    }

    /**
     * Výpočet matematického znaménka čísla
     * @param a vstupní číslo
     * @return znaménko vstupního čísla
     */
    private static int getMark(double a){
        if(a < 0){
            return -1;
        }
        if(a == 0){
            return 0;
        }
        return 1;
    }
}
