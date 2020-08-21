package learnThreadLocal;

public class T2 {



    public static void main(String[] args) {

        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set("A thread local value");
        String threadLocalValue = (String) threadLocal.get();
        System.out.println(threadLocalValue);
         threadLocal.remove();
        System.out.println(threadLocal.get());

    }

}
