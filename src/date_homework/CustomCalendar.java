package date_homework;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

public class CustomCalendar {

    public static final String RED = "\u001B[31m";
    public static final String MAGENTA = "\u001B[67m";
    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the year: ");
        int year = scanner.nextInt();

        System.out.print("Enter the month: ");
        int month = scanner.nextInt();


        YearMonth yearMonth = YearMonth.of(year, month);

        LocalDate firstDayOfMonth = yearMonth.atDay(1);

        System.out.println("firstDayOfMonth = " + firstDayOfMonth);
        DayOfWeek firstDayOfWeek = firstDayOfMonth.getDayOfWeek();
        System.out.println("firstDayOfWeek = " + firstDayOfWeek);
        LocalDate today = LocalDate.now();

        int daysInMonth = yearMonth.lengthOfMonth();

        System.out.printf("%02d/%d\n", month, year);

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");

        int startIndex = firstDayOfWeek.getValue();

        for (int i = 1; i < startIndex; i++) {
            System.out.print("    ");
        }

        for (int day = 1; day <= daysInMonth; day++) {
            LocalDate currentDay = yearMonth.atDay(day);

            if (currentDay.equals(today)) {
                System.out.printf(RED + "%02d  " + RESET, day);
            } else {
                System.out.printf(MAGENTA + "%02d  " + RESET, day);
            }

            if ((startIndex + day - 1) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
