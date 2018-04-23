import java.util.Scanner;

public class ScanTest {

    public static void main(String[] args){
        int soucet = 0;
        int pocet = 0;
        boolean opakovani = true;
        do {
            int cislo;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Napiš číslo do aritmetického průměru:");
            String line = scanner.nextLine();
            if(line.equals("=")){
                System.out.println("Konec");
                opakovani = false;
                continue;
            }
            try{
                cislo = Integer.parseInt(line);
                soucet += cislo;
                pocet++;
                System.out.println("Číslo "+ cislo + " (součet: "+soucet+")");
            }catch (NumberFormatException ex){
                System.out.println("Neznámé číslo, zkus to znovu.");
            }
        }while (opakovani);
        double prumer = (double) soucet/pocet;
        System.out.println("Aritmetický průměr = "+prumer);
    }
}
