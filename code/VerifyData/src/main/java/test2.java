import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class test2 {

    public static void main(String[] args) throws IOException {
        String s1 = "/Users/dn/Downloads/2718个账号.txt";
        run(s1);
    }

    public static void run(String s1) throws IOException {
        FileInputStream fin = new FileInputStream(s1);

        BufferedReader bf = new BufferedReader( new InputStreamReader(fin));


        HashMap<String,Integer> hs1 =new HashMap();
        HashMap<String,Integer> hs2 =new HashMap();

        String str =null;

        HashSet<String[]> set = new HashSet();

        String[] head=bf.readLine().split("\t");
        while( (str=bf.readLine())!=null){
            String[] sarr = str.split("\t");
            set.add(new String[] {sarr[0],sarr[1]});
        }

        System.out.println(set.size());
        Iterator it = set.iterator();

       int[] type=new int[4];

       HashMap hm3 = new HashMap();
       HashMap hm4 = new HashMap();

        while(it.hasNext()){
            String[] sarr = (String[]) it.next();
            if(hs1.containsKey(sarr[1])){
                 Integer t = hs1.get(sarr[1]);
                hs1.put(sarr[1],t+1);
             }else{
                 hs1.put(sarr[1],1);
             }

//             if(hs2.containsKey(sarr[2]+":"+sarr[0])){
//                 Integer t = hs2.get(sarr[2]);
//                 hs2.put(sarr[2],t+1);
//             }else{
//                 hs2.put(sarr[2],1);
//                 type[Integer.parseInt(sarr[2])]++;
//             }
//            if(sarr[2].equals("1")){
//                if(!hs2.containsKey(sarr[0])){
//                    hs2.put(sarr[1],1);
//                }
//            }
//
//            if(sarr[2].equals("2")){
//                if(!hm3.containsKey(sarr[0])){
//                    hm3.put(sarr[1],1);
//                }
//            }
//            if(sarr[2].equals("3")){
//                if(!hm4.containsKey(sarr[0])){
//                    hm4.put(sarr[1],1);
//                }
//            }

        }



        BufferedWriter out = new BufferedWriter(new FileWriter("/Users/dn/Documents/一般文档/结果4.txt"));

        // out.write(head[0]+"\t表1\t表2\n");
        out.write("产品ID：账号数量 \n");
        for(Map.Entry e:hs1.entrySet()){
            out.write(e.getKey()+" :"+e.getValue()+"\n");
        }
        out.write("-----------------------\n");
        out.write("relation_type：账号数量 \n");
//        for(Map.Entry e:hs2.entrySet()){
//            out.write(e.getKey()+" :"+e.getValue()+"\n");
//        }
            out.write("1 :"+hs2.size()+"\n");
            out.write("2 :"+hm3.size()+"\n");
            out.write("3 :"+hm4.size()+"\n");

        out.close();

    }


}
