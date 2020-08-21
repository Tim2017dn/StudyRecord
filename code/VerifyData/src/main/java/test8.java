import java.io.*;

public class test8 {

    public static void main(String[] args) throws IOException {
        String s1 = "/Users/dn/Desktop/t4.txt";
        run(s1);

    }
    public static void run(String s1) throws IOException {

        FileInputStream fin = new FileInputStream(s1);
        BufferedReader bf = new BufferedReader(new InputStreamReader(fin));


        String line;
        StringBuilder result=new StringBuilder();

        while(( line= bf.readLine())!=null){
            result.append(","+line);
          //  System.out.println(line);
        }

        System.out.println(result);
        BufferedWriter out = new BufferedWriter(new FileWriter("/Users/dn/Documents/一般文档/id2.txt",true));

        out.write(result.toString());
        out.close();


    }

}
