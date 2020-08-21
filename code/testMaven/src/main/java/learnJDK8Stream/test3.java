package learnJDK8Stream;

import java.util.*;
import java.util.stream.Collectors;

public class test3 {

    public static void main(String[] args) {

        List<Integer> list =new ArrayList<>();

        for(int i=0;i<40000;i++){
            list.add(i);
        }
        Map<Integer,String> map = new HashMap<>();
        long start = System.currentTimeMillis();

        for(Integer t:list){
            map.put(t,String.valueOf(2*t));
        }

        long stop = System.currentTimeMillis();
        System.out.println(stop -start);

        Map<Integer,String> map2 = new HashMap<>();
        long start2 = System.currentTimeMillis();
        list.parallelStream().forEach(t -> {
            map2.put(t,String.valueOf(2*t));
            }
        );
        long stop2 = System.currentTimeMillis();
        System.out.println(stop2 -start2);

        System.out.println(map2.get(10));

    }

}
