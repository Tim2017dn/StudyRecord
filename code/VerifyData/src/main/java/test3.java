import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class test3 {

    public static void main(String[] args) throws IOException {
        String s1 = "/Users/dn/Downloads/异常门店.xlsx";
        run(s1);
    }


    public static void run(String s1) throws IOException {
        FileInputStream fin = new FileInputStream(s1);

        BufferedReader bf = new BufferedReader( new InputStreamReader(fin,"UTF-16"));



        HashMap<String,String> hs1 =new HashMap();


        String str =null;

        String[] head=bf.readLine().split("\t");
        while( (str=bf.readLine())!=null){
            String[] sarr = str.split("\t");
            hs1.put(sarr[0],sarr[2]);
        }



        BufferedWriter out = new BufferedWriter(new FileWriter("/Users/dn/Documents/一般文档/结果5.xlsx",true));

        // out.write(head[0]+"\t表1\t表2\n");


        out.close();

    }
}
