import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class test5 {
    public static void main(String[] args) throws IOException {
        String s1 = "/Users/dn/Downloads/目前6-09.txt";
        String s2 = "/Users/dn/Downloads/新6-09.txt";
        run(s1,s2);
    }


    public static void run(String s1,String s2) throws IOException {

        FileInputStream fin1 = new FileInputStream(s1);
        BufferedReader bf1 = new BufferedReader(new InputStreamReader(fin1));

        FileInputStream fin2 = new FileInputStream(s2);
        BufferedReader bf2 = new BufferedReader(new InputStreamReader(fin2));

        HashMap<String,ArrayList<String>> hm1 = new HashMap<String,ArrayList<String>>();
        HashMap<String,ArrayList<String>> hm2 = new HashMap<String,ArrayList<String>>();


        String str =null;

        bf1.readLine();
        while((str= bf1.readLine())!=null){
            String[] sarr = str.split("\t");
            ArrayList<String> temp = new ArrayList<String>();
            temp.add(sarr[1]);
            temp.add(sarr[2]);
            hm1.put(sarr[0],temp);
        }

        bf2.readLine();
        while((str= bf2.readLine())!=null){
            String[] sarr = str.split("\t");
            ArrayList<String> temp = new ArrayList<String>();
            temp.add(sarr[1]);
            temp.add(sarr[2]);
            hm2.put(sarr[0],temp);
        }

        ArrayList<String> same_account=new ArrayList<String>();
        ArrayList<String> old_have_only = new ArrayList<String>();
        ArrayList<String> new_have_only = new ArrayList<String>();



        for(Map.Entry e: hm1.entrySet()){
            String k1 = (String) e.getKey();
            if(hm2.containsKey(k1)){
                same_account.add(k1);
            }else{
                old_have_only.add(k1);
                System.out.println(k1);
            }
        }

        for(Map.Entry e: hm2.entrySet()){
            String k2 = (String)e.getKey();
            if(!hm1.containsKey(k2)){
                new_have_only.add(k2);
                System.out.println(k2+" ");
               // System.out.println(hm1.get(k2).get(0)+hm1.get(k2).get(1));
                System.out.println(hm2.get(k2).get(0)+hm2.get(k2).get(1));
            }

        }

        int new_dis = 0;
        int same_old =0;
        int dif_old =0;

        for(int i=0;i<same_account.size();i++){
            String key = same_account.get(i);

            ArrayList<String> arr1 = hm1.get(key);
            ArrayList<String> arr2 = hm2.get(key);

            if(!arr1.get(0).equals(arr2.get(0))&&arr2.get(0).equals("1")){
                new_dis++;
            }

            if(arr1.get(1).equals(arr2.get(1))){
                same_old++;
            }else{
                if(!"NULL".equals(arr2.get(1))){
                    dif_old++;
                    System.out.println(key+" "+arr1.get(1)+" "+arr2.get(1));
                }

            }

        }



        BufferedWriter out = new BufferedWriter(new FileWriter("/Users/dn/Documents/一般文档/结果11.txt",true));

        out.write(s1+"表和"+s2+"表\n");
        out.write("same_account："+same_account.size()+"\n");
        out.write("old_have_only："+ old_have_only.size()+"\n");
        out.write("new_have_only："+ new_have_only.size()+"\n");
        out.write("new_dis："+new_dis+"\n");
        out.write("same_old："+same_old+"\n");
        out.write("dif_old："+dif_old+"\n");
        out.write("-------------------------------\n");

        out.close();


    }

}

/*
(73695741,72330260,72692590)
73695741 4 2
72330260 3 2
72692590 4 3
72462567 3 2
73026139 4 3
72477522 3 1
73046598 4 1
71994708 4 3
72890675 4 3
4308579 4 3
71785023 3 1
72064185 4 2
71715152 3 2
71984487 3 1
71807209 4 3
2481703 3 2
73536740 4 3
72131425 4 3
71562694 3 2
72626801 4 3
71640946 4 2
73792843 4 2
 */