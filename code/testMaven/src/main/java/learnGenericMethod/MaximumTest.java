package learnGenericMethod;

public class MaximumTest {

    public static <T extends Comparable<T>> T maximum(T x,T y,T z){
        T max = x;
        if(y.compareTo(max) > 0 ){
            max = y;
        }
        if(z.compareTo(max) > 0){
            max = z;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.printf("%d, %d 和 %d 中max为 %d\n" ,3,4,5,maximum(3,4,5));

        System.out.printf("%.1f, %.1f 和 %.1f max is %.2f\n\n",6.11,6.22,6.33,maximum(6.11,6.22,6.33));

        System.out.printf("%s, %s 和 %s max is %s\n\n","aab","aa","a",maximum("aab","aa","a"));

       // String

    }

}
