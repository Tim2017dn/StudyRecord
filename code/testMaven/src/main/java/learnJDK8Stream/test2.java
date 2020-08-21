package learnJDK8Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class test2 {

    public static void main(String[] args) {

        int[] numbers ={2,8,3,6,9,5,1,4};

        List<Integer> list = Arrays.asList(2,8,3,6,9,5,1,4);
        List<Integer> res = list.stream().filter(x -> x%2 == 0).sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        }).collect(Collectors.toList());
        System.out.println(res);

    }
}
