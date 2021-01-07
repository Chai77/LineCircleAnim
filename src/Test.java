import java.util.Calendar;

public class Test {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getTime());
        calendar.add(Calendar.MONTH, 1);
        System.out.println(calendar.getTime());
        calendar.add(Calendar.MONTH, 1);
        System.out.println(calendar.getTime());
        calendar.add(Calendar.MONTH, 1);
        System.out.println(calendar.getTime());
        calendar.add(Calendar.MONTH, 1);
        System.out.println(calendar.getTime());
        calendar.add(Calendar.MONTH, 1);
        System.out.println(calendar.getTime());
    }
}