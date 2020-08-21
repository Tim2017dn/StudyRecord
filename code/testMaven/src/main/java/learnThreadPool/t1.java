package learnThreadPool;

import java.util.List;
import java.util.concurrent.*;

public class t1 {

    private static ExecutorService threadpool1;

    private static myService my;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService threadpool1 = Executors.newFixedThreadPool(10);
        my = new myService();
        // Future f1 = threadpool1.submit(() -> my.test());

       // System.out.println(f1.get());

    }
}
