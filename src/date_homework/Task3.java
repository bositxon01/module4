package date_homework;

import java.time.*;

public class Task3 {
    public static void main(String[] args) {

        ZonedDateTime tokyo = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        ZonedDateTime newYork = ZonedDateTime.now(ZoneId.of("America/New_York"));

        ZoneOffset tokyoOffset = tokyo.getOffset();
        ZoneOffset newYorkOffset = newYork.getOffset();

        int difference = (tokyoOffset.getTotalSeconds() - newYorkOffset.getTotalSeconds()) / 3600;

        System.out.println("Difference between Tokyo and NewYork is: " + difference);
        System.out.println("Current time in Tokyo: -> " + tokyo);
        System.out.println("Current time in NewYork: -> " + newYork);
    }
}
