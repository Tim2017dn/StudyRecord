import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class test1 {

    public static void main(String[] args) throws IOException {

        String s1 = "/Users/dn/Downloads/2-29.txt";
        String s2 = "/Users/dn/Downloads/3-31.txt";

        String s3 = "/Users/dn/Downloads/3-1.txt";
        String s4 = "/Users/dn/Downloads/3-2.txt";

        String s5 = "/Users/dn/Downloads/4-30.txt";

        String s6 = "/Users/dn/Downloads/m4-30.txt";
        String s7 = "/Users/dn/Downloads/m5-07.txt";

        String s8 = "/Users/dn/Downloads/5-1结果.txt";
        String s9 = "/Users/dn/Downloads/5-30结果.txt";

        String s10 = "/Users/dn/Downloads/5-31结果.txt";

        String s11 = "/Users/dn/Downloads/6-1结果.txt";
        String s12 = "/Users/dn/Downloads/新6-1.txt";

        run(s11,s12);



    }

    public static void run(String s1,String s2) throws IOException {
        FileInputStream fin = new FileInputStream(s1);

        BufferedReader bf = new BufferedReader( new InputStreamReader(fin));

        FileInputStream fin2 = new FileInputStream(s2);
        BufferedReader bf2 = new BufferedReader( new InputStreamReader(fin2));

        HashMap<String,String> hs1 =new HashMap();
        HashMap<String,String> hs2 =new HashMap();

        String str =null;
        //
        String[] head=bf.readLine().split("\t");
        while( (str=bf.readLine())!=null){
            String[] sarr = str.split("\t");
            hs1.put(sarr[0],sarr[2]);
        }

        bf2.readLine().split("\t");
        while((str=bf2.readLine())!=null){
            String[] sarr2 =str.split("\t");
            hs2.put(sarr2[0],sarr2[2]);
        }

        BufferedWriter out = new BufferedWriter(new FileWriter("/Users/dn/Documents/一般文档/结果3.txt",true));

        // out.write(head[0]+"\t表1\t表2\n");

        int same_shop_num=0;
        int dif_shop_num=0;
        int same_value=0;

        for(Map.Entry<String,String> e:hs1.entrySet()){
            String k1 = e.getKey();
            String v1 = e.getValue();
            if(hs2.containsKey(k1)){
                same_shop_num++;
                if(hs2.get(k1).equals(v1)){
                    same_value++;
                }
            }else{
                dif_shop_num++;
            }

        }

        out.write(s1+"表和"+s2+"表\n");
        out.write("两张表相同shop数量："+same_shop_num+"\n");
        out.write("shop相同的情况下，标签也相同的数量："+ same_value+"\n");
        out.write("表1有表2没有的shop数量："+dif_shop_num+"\n");
        out.write("-------------------------------\n");

        out.close();

    }





}
