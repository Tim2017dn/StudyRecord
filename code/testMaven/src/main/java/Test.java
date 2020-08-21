import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) {

       Date t = new Date();
        t.setTime(100000);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String startTime = sdf.format(t);
        System.out.println(startTime);


    }
}
