package learnHashMap;


import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class T1 {



    public static void main(String[] args) {

        HashMap<Integer,Integer> hm = new HashMap<>(4);

        for(int i=0;i<10;i++){
            hm.put(i,i);
        }



    }

}
