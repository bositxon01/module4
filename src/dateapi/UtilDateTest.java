package dateapi;

import java.util.Calendar;
import java.util.Date;

public class UtilDateTest {
    public static void main(String[] args) {

        Date date = new Date(System.currentTimeMillis());
        System.out.println("date = " + date);
        //From 1970 year, 1-January, 00:00
        System.out.println("date.getTime() = " + date.getTime());

        //adding 5 minutes to current time
        Date date1 = new Date(System.currentTimeMillis() + 5 * 60 * 1000);
        System.out.println("date1 = " + date1);

        //setDate
        Date date2 = new Date(124, Calendar.SEPTEMBER, 17, 7, 44, 23);
        System.out.println("date2 = " + date2);

        Date setDate = new Date(System.currentTimeMillis());
        setDate.setTime(System.currentTimeMillis() + 10 * 60 * 1000);
        System.out.println("setDate = " + setDate);

        //before, after testing
        Date first = new Date();
        Date second = new Date(System.currentTimeMillis() + 5 * 60 * 1000);

        if (second.after(first)) {
            System.out.printf("%s is after %s", second, first);
        } else {
            System.out.printf("%s is before %s", second, first);
        }
    }
}
