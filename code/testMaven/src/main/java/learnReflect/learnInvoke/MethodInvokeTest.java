package learnReflect.learnInvoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodInvokeTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<InvokeObj> clazz = InvokeObj.class;
        Method[] methods = clazz.getMethods();
//        System.out.println("以下输出方法");
//        for(Method m:methods){
//            System.out.println(m);
//        }
//
//        Method method1 =clazz.getMethod("show",null);
//        Object obj = method1.invoke(new InvokeObj(),null);
//        System.out.println(obj);
//
//        Method method2 = clazz.getMethod("show", String.class);
//        Object obj2 = method2.invoke(new InvokeObj(), "dn");
//        System.out.println(obj2);

        Method method3 = clazz.getMethod("StringShow", String.class);
        Object obj3 = method3.invoke(new InvokeObj(), "hello");
        System.out.println(obj3);


    }
}
