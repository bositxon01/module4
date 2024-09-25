package dateapi;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class CalendarTest {
    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        System.out.println("calendar = " + calendar);
        System.out.println("calendar.getTime() = " + calendar.getTime());

        //adding some dates
        calendar.add(Calendar.DATE, 6);
        System.out.println("calendar.getTime() = " + calendar.getTime());

        //rolling
        calendar.roll(Calendar.DATE, 20);
        System.out.println("calendar.getTime() = " + calendar.getTime());

        //setting date
        Scanner scanner = new Scanner(System.in);
        int dayOfMonth = scanner.nextInt();

        calendar.setLenient(false); //inside the month
        calendar.set(Calendar.DATE, dayOfMonth);
        System.out.println("calendar.getTime() = " + calendar.getTime());

        //formatting simpleDateFormat
        Calendar date = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String format = simpleDateFormat.format(date.getTime());
        System.out.println("format = " + format);
    }
}
