package date_homework;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Task6 {
    public static void main(String[] args) {

        LocalDate current = LocalDate.now();

        LocalDate endDate = current.plusMonths(6);

        int countDays = 0;

        while (!current.isAfter(endDate)) {
            if (isWorkingDay(current)) {
                countDays++;
            }
            current = current.plusDays(1);
        }

        System.out.println("countDays = " + countDays);
    }

    private static boolean isWorkingDay(LocalDate current) {
        return current.getDayOfWeek() != DayOfWeek.SATURDAY && current.getDayOfWeek() != DayOfWeek.SUNDAY;
    }
}
