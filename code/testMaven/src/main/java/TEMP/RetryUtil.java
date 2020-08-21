package TEMP;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


public class RetryUtil {

    private final static long DEFAULT_RETRY_INTERVAL_MILLS = 10 * 1000;

    public static <T> T retry(Handler handler, int retryTimes) throws Exception {
        return retry(handler, retryTimes, DEFAULT_RETRY_INTERVAL_MILLS);
    }

    public static <T> T retry(Handler handle, int retryTimes, long retryIntervalMils) throws Exception {
        int i = 0;
        List<Exception> exceptions = new ArrayList();

        while (i++ < retryTimes) {
            try {
                if (i > 1) {
                    Thread.sleep(retryIntervalMils);
                }
                return (T) handle.execute();
            } catch (Exception e) {
                // log.warn("the "+i+" times exception",e);
                exceptions.add(e);
            }
        }

        // log.error()
        throw new RuntimeException(exceptions.get(exceptions.size() - 1));
    }


    public interface Handler {
        Object execute() throws Exception;
    }

}
