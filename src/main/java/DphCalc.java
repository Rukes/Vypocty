import java.util.Scanner;

public class DphCalc {

    DphCalc(){
        double dph = -1;
        do{
            System.out.println("Zadejte DPH sazbu (v %):");
            Scanner dphScan = new Scanner(System.in);
            String dphString = dphScan.nextLine();
            try {
                dph = Double.parseDouble(dphString);
                System.out.println("DPH sazba: "+dph+"%");
            } catch (NumberFormatException ex){
                System.out.println("Chyba! Zadaný argument (" + dphString + ") není číslo!");
            }
        }while (dph <= 0);

        double value;
        double dphCount = 0;
        do {
            System.out.println("Zadejte novou částku:");
            Scanner valueScan = new Scanner(System.in);
            String valueString = valueScan.nextLine();
            try {
                value = Double.parseDouble(valueString);
                if(value < 0){
                    break;
                }
                double count = value * (dph / 100);
                dphCount += count;
                System.out.println("DPH sazba ("+dph+"%) z "+value+",- je: "+count+",- (celkem "+dphCount+",-)");
            }catch (NumberFormatException ex){
                System.out.println("Vyskytla se chyba v zadaném argumentu '"+valueString+"'!");
            }
        }while (Thread.currentThread().isAlive());
        System.out.println("Ukončuji činnost...");
        System.out.println("Celkový součet: "+dphCount+",-");
    }
}
