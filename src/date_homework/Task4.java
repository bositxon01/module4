package date_homework;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

public class Task4 {
    public static void main(String[] args) {
        //Monday morning 10:30
        //Next three months
        LocalDate current = LocalDate.now();

        LocalDate endDate = current.plusMonths(3);

        LocalDate firstMonday = current;
        while (firstMonday.getDayOfWeek() != DayOfWeek.MONDAY) {
            firstMonday = firstMonday.plusDays(1);
        }

        int count = 0;

        LocalDate nextMonday = firstMonday;
        while (!nextMonday.isAfter(endDate)) {
            System.out.println("nextMonday = " + nextMonday);
            count++;
            nextMonday = nextMonday.plusWeeks(1);
        }

        System.out.println("count = " + count);
    }
}
