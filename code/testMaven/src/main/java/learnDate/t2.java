package learnDate;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class t2 {

    public static void main(String[] args) {

        ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("date1: " + date1);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当期时区: " + currentZone);

    }
}
