import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class StringFormat {

    private static final double PI = Math.PI;

    public static void main(String[] args){
        System.out.println("|"+String.format("%4.3f", PI));
        System.out.println("|"+String.format("%4.2f", PI));
        System.out.println("|"+String.format("%4d", 12));
        System.out.println("|"+String.format("%4d", 121));
        System.out.println("|"+String.format("%04d", 21));
        System.out.println("|"+String.format("%04d", 221));
        System.out.println();
        System.out.println(new SimpleDateFormat("YYYYMMdd", Locale.US).format(new Date()));
        System.out.println(new SimpleDateFormat("d. MMMM YYYY", Locale.US).format(new Date()));
        System.out.println(new SimpleDateFormat("HH:mm:ss", Locale.US).format(new Date()));
        System.out.println(new SimpleDateFormat("YYYY-MM-dd 'at' HH-mm-ss", Locale.US).format(new Date()));
        System.out.println();
        System.out.println(new DecimalFormat("#,##0.00").format(100.1d));
        System.out.println(new DecimalFormat("#,##0.00").format(100.01d));
        System.out.println(new DecimalFormat("#,##0.00").format(8213.92d));
        System.out.println(new DecimalFormat("#,##0.00").format(20375722.49d));
        System.out.println(new DecimalFormat("#,##0.00").format(0.1d));
        System.out.println(new DecimalFormat("#,##0.00").format(0.1d));
    }
}
