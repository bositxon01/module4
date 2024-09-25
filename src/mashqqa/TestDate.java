package mashqqa;

import java.time.*;

public class TestDate {
    public static void main(String[] args) throws InterruptedException {
        LocalTime localTime1 = LocalTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println("localTime1 = " + localTime1);

        while (true) {
            Thread.sleep(2000);
            LocalDateTime now = LocalDateTime.now(Clock.systemDefaultZone());
            System.out.println("now = " + now);
        }
    }
}
