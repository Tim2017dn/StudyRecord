package TEMP;

import com.sun.media.jfxmediaimpl.HostUtils;

import java.util.concurrent.locks.ReentrantLock;

public class TestRetry {

    public static void main(String[] args) throws Exception {



        RetryUtil.retry(() -> {

                System.out.println("1");
                return 1;

        }, 3, 1000);

    }

}
