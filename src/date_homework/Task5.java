package date_homework;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Task5 {
    public static void main(String[] args) {
        LocalDateTime current = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm:ss");

        LocalDate localDate = current.toLocalDate();
        LocalTime localTime = current.toLocalTime();

        String format = formatter.format(localDate);
        System.out.println("format = " + format);

        String format1 = formatter1.format(localTime);
        System.out.println("format1 = " + format1);

        System.out.println("current = " + current);
    }
}
