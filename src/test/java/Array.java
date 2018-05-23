import java.util.Random;

public class Array {

    public static void main(String[] args){

        int[] array = new int[10];

        Random random = new Random();
        for(int i = 0; i < array.length; i++){
            array[i] = random.nextInt(100) + 1;
        }

        int min = Integer.MAX_VALUE;
        int minPos = -1;
        int max = Integer.MIN_VALUE;
        int maxPos = -1;
        int secondMax = Integer.MIN_VALUE;
        int secondMaxPos = -1;
        int count = 0;
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < array.length; i++){
            int number = array[i];
            if(number < min){
                min = number;
                minPos = i;
            }
            if(number > max){
                secondMax = max;
                secondMaxPos = maxPos;
                max = number;
                maxPos = i;
            }else{
                if(number > secondMax){
                    secondMax = number;
                    secondMaxPos = i;
                }
            }
            if(number > max){
                max = number;
                maxPos = i;
            }
            count += number;
            builder.append(number).append(", ");
        }
        double average = (double) count / (double) array.length;

        System.out.println("Array: " + builder.toString().substring(0, builder.length() - 2));
        System.out.println("Součet: " + count);
        System.out.println("Průměr: " + average);
        System.out.println("Nejnižší hodnota: " + min + " (" + minPos + ")");
        System.out.println("Nejvyšší hodnota: " + max + " (" + maxPos + ")");
        System.out.println("Druhá nejvyšší hodnota: " + secondMax + " (" + secondMaxPos + ")");
    }

    public static void randomIndex(){

        //Vytvoříme si pole a do něj nasadíme náhodné hodnoty, klasika
        int[] array = new int[10];
        Random random = new Random();
        for(int i = 0; i < array.length; i++){
            array[i] = random.nextInt(100) + 1;
        }

        // Inicializujeme si proměnou která bude značit náhodný index.
        // Pomocí náhodnosti "Random" vytvoříme novou instanci,
        //  ale jelikož už jednu máme výše (proměnná "random") tak ji použijeme.
        // Index pro vybrání náhodné hodnoty musí být v rozmezí délky pole
        //  tj. 0 až délka pole (v našem případě 10), ale hodnoty jsou zančené 0 - 9,
        //  ale délka je 10, takže uděláme délka - 1 (čistě logicky).
        // Připomínám, že metoda náhodnosti "nextInt(parametr číslo)" značí náhodnost od 0 až do parametru -1
        //  tj. př. po vložení 100 můžeme dostat čísla 0 až 99.
        // To znamená, že stačí když víme že čísla které můžeme dostat na základě náhodnosti
        //  jsou 0 až délka pole - 1, protože pokud má pole 10 položek (v našem případě)
        //  tak náhodnost je 0 až 9, viz metoda "nextInt()".
        int randomIndex = random.nextInt(array.length);
        // Proměnná je nyní náhodné číslo od 0 až po 9.

        // A nyní jednoduše vezmeme z pole prvek na základě náhodného čísla.
        // Pokud je číslo např. 2, tak je to stejné jako kdybychom napsali:
        //  array[2]
        int randomNumber = array[randomIndex];

        System.out.println("Náhodné číslo: " + randomNumber + " (s indexem " + randomIndex + ")");
    }

    public static void chessboard(){
        boolean[][] board = new boolean[8][8];
        boolean lastValue = false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = !lastValue;
                lastValue = !lastValue;
            }
        }

        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] ? "  " : "##");
            }
            System.out.println();
        }
    }
}
