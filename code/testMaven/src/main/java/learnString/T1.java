package learnString;


import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.Callable;

public class T1 {
    public static void main(String[] args) {

      //  String str = "0123456789";
        int[] arr = {0,1,2,3,4,5,6,7};
        String str = new String(arr,3,5);
        System.out.println(str);

    //    StringUtils
        StringBuffer br = new StringBuffer();

       // Runnable
        // Callable

    }
}
