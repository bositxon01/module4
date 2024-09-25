package date_homework;

import java.time.Duration;
import java.time.LocalDateTime;

public class Task7 {
    public static void main(String[] args) {
        LocalDateTime current = LocalDateTime.now();
        LocalDateTime independenceDay = LocalDateTime.of(2025, 9, 1, 0, 0, 0);

        Duration duration = Duration.between(current, independenceDay);

        long days = duration.toDays();
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.toSeconds() % 60;

        System.out.println("Duration until the next Independence day: ");
        System.out.printf("%s days, %s hours, %s minutes, %s seconds",
                days,
                hours,
                minutes,
                seconds);
    }
}
