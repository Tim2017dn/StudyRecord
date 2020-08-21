package learnDate;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class t1 {

    public static void main(String[] args) {
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println(currentTime);

        LocalDate localDate = currentTime.toLocalDate();
        System.out.println(localDate);

        LocalTime localTime = currentTime.toLocalTime();
        System.out.println(localTime);

        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();

        System.out.println("月: " + month +", 日: " + day +", 秒: " + seconds);


        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);

        LocalDate d3 = LocalDate.of(2012, 10, 2);
        System.out.println(d3);

    }
}
