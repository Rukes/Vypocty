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
}
