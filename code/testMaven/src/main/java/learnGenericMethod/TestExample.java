package learnGenericMethod;

import java.util.HashMap;

public class TestExample {
    public static void main(String[] args) {
        HashMap hm = new HashMap();
        Example<?> e = new Example<String>("111");
        e.show();

        e = new Example<Float>(1.2f);
        e.show();

    }
}
