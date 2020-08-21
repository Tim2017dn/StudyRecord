import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class test4 {

    public static void main(String[] args) throws IOException {
        String s1 = "/Users/dn/Downloads/老部署版本.txt";
        String s2 = "/Users/dn/Downloads/新部署.txt";

        run(s1,s2);
    }



    public static void run(String s1,String s2) throws IOException {
        FileInputStream fin = new FileInputStream(s1);

        BufferedReader bf = new BufferedReader( new InputStreamReader(fin));

        FileInputStream fin2 = new FileInputStream(s2);
        BufferedReader bf2 = new BufferedReader( new InputStreamReader(fin2));

        HashMap<String,String> hm1 =new HashMap();
        HashMap<String,String> hm2 =new HashMap();

        String str =null;
        //
        String[] head=bf.readLine().split("\t");
        while( (str=bf.readLine())!=null){
            String[] sarr = str.split("\t");

            hm1.put(sarr[0],sarr[8]);
        }

        bf2.readLine().split("\t");
        while((str=bf2.readLine())!=null){
            String[] sarr = str.split("\t");

            hm2.put(sarr[0],sarr[8]);
        }

        BufferedWriter out = new BufferedWriter(new FileWriter("/Users/dn/Documents/一般文档/结果5.txt",true));

        // out.write(head[0]+"\t表1\t表2\n");

        int num1=0;
        int same_key=0;
        int same_value=0;
        int dif_num=0;
        int dif_value=0;

        for(Map.Entry<String,String> e:hm1.entrySet()){
            String k1 = e.getKey();
            String v1 = e.getValue();
            num1++;
            if(hm2.containsKey(k1)){
               same_key++;
                String v2 = hm2.get(k1);
                if(v1.equals(v2)){
                   same_value++;
               }else{
                   dif_value++;
               }
//95361446
            }else{
                dif_num++;
            }

        }

        out.write(s1+"表和"+s2+"表\n");
        out.write("num1："+num1+"\n");
        out.write("same_key："+ same_key+"\n");
        out.write("same_value："+same_value+"\n");
        out.write("dif_num："+dif_num+"\n");
        out.write("dif_value："+dif_value+"\n");
        out.write("-------------------------------\n");

        out.close();

    }
}
