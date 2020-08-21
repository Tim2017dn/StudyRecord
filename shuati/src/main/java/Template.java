import java.util.Arrays;
import java.util.Scanner;

public class Template {


    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        int times = Integer.parseInt(sc.nextLine());

        while(times-- > 0){
            String[] sarr = sc.nextLine().split(" ");
            int[] arr =new int[sarr.length];
            for(int i=0;i<arr.length;i++){
                arr[i]=Integer.parseInt(sarr[i]);
            }
            int res = handle(arr);
            System.out.println(res);

        }

    }


    public static int handle(int[] arr){
        Arrays.sort(arr);
        int len = arr.length;
        if(len == 1){
            return arr[0];
        }else if(len == 2){
            return arr[1];
        }else{
            int t=2;
            int sum = arr[1]+arr[0];
            while(t<arr.length){
                if(t+1<arr.length){
                    int num1 = arr[t+1]+arr[1]+arr[1];
                    int num2 = arr[t] + arr[t+1] +arr[0];
                    if(num1<num2){
                        sum+=num1;
                        t+=2;
                    }else{
                        sum+=num2;
                        t+=2;
                    }
                }else{
                    sum+=arr[t];
                }
                if(t<arr.length){
                    sum+=arr[0];
                }
            }
            return sum;

        }
    }

}
