import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class test7 {


    public static void main(String[] args) throws IOException {
        String str1 = "/Users/dn/Downloads/x12.txt";  //wo
        String str2 = "/Users/dn/Downloads/x11.txt";    // yanzhengde1


        run(str1,str2);
    }


    public static void run(String s1,String s2) throws IOException {

        FileInputStream fin1 = new FileInputStream(s1);
        BufferedReader bf1 = new BufferedReader(new InputStreamReader(fin1));

        FileInputStream fin2 = new FileInputStream(s2);
        BufferedReader bf2 = new BufferedReader(new InputStreamReader(fin2));

        HashMap<String,Integer> hm1 = new HashMap<String,Integer>();
        HashMap<String,Integer> hm2 = new HashMap<String,Integer>();

        int num1=0;
        int num2=0;

        String str =null;

        bf1.readLine();
        while((str= bf1.readLine())!=null){
            String[] sarr = str.split("\t");
            hm1.put(sarr[0],1);


        }

        bf2.readLine();
        while((str= bf2.readLine())!=null){
            String[] sarr = str.split("\t");
            hm2.put(sarr[0],1);
        }


        for(Map.Entry e:hm2.entrySet()){
            num2++;
            String key = (String) e.getKey();

            if(!hm1.containsKey(key)){
                System.out.println(key);
            }
        }
        System.out.println("-----");

        for(Map.Entry e:hm1.entrySet()){
            num1++;
            String key1 = (String) e.getKey();

            if(!hm2.containsKey(key1)){
                System.out.println(key1);
            }
        }


        BufferedWriter out = new BufferedWriter(new FileWriter("/Users/dn/Documents/一般文档/结果15.txt",true));

        out.write(s1+"表和"+s2+"表\n");

        out.write("-------------------------------\n");
        out.write(num1+'\n');
        out.write(num2+'\n');
        out.close();


    }


}
