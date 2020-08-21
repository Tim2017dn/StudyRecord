import java.util.Arrays;
import java.util.List;

public class learnArrays {

    public static void main(String[] args) {

        String str="aaaaa,bbbb,ccc,dd";
        List<String> strings = Arrays.asList(str.split(","));
        System.out.println(strings.toString());
    }
}
