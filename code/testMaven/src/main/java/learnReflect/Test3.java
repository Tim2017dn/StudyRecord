package learnReflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test3 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        Class class1 = Class.forName("learnReflect.Student");

        Object o = class1.newInstance();
        System.out.println(o);


        Constructor constructor = class1.getConstructor();
        Student o1 = (Student) constructor.newInstance();
        System.out.println(o1);
    }

}
