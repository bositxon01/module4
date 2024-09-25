package date_homework;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("First year: ");
        int year1 = scanner.nextInt();

        System.out.print("Second year: ");
        int year2 = scanner.nextInt();

        leapYears(year1, year2);
    }

    public static void leapYears(int year1, int year2) {
        if (year1 > year2) {
            int tempYear = year1;
            year1 = year2;
            year2 = tempYear;
        }
        for (int i = year1; i <= year2; i++) {
            if (isLeapYear(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isLeapYear(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
    }
}
