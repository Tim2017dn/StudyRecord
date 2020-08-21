package learnReflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestReflect {

    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        Student s = new Student();
//        s.doHomeWork("math");
        Class<?> clazz = Class.forName("learnReflect.Student");
        Method doHomeWork = clazz.getMethod("doHomeWork", String.class);
        Constructor constructor = clazz.getConstructor();
        Object o = constructor.newInstance();
        doHomeWork.invoke(o,"chinese");

//        Method[] declaredMethods = clazz.getDeclaredMethods();
//        for(Method m:declaredMethods){
//            System.out.println(m.toString());
//        }
       // Arrays.stream(declaredMethods).forEach(System.out::println);
//        Method[] method = clazz.getMethods();
//        for(Method m:method){
//            System.out.println(m.toString());
//        }


        // clazz.getDeclaredMethods();

    }

}
