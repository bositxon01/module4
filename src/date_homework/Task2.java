package date_homework;

import java.time.*;

public class Task2 {
    public static void main(String[] args) {

        LocalDate ld = LocalDate.of(1976, 7,28);
        LocalDate currentDate = LocalDate.now();

        Period period = Period.between(ld, currentDate);

        LocalTime lt = LocalTime.of(2,5, 2);
        LocalTime currentTime = LocalTime.now();

        Duration duration = Duration.between(lt, currentTime);

        System.out.printf("%s years, %s months, %s days, %s hours, %s minutes, %s seconds",
                period.getYears(),
                period.getMonths(),
                period.getDays(),
                duration.toHours(),
                duration.toMinutes() % 60,
                duration.toSeconds() % 60);
    }
}
