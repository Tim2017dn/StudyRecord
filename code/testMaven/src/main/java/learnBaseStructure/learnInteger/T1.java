package learnBaseStructure.learnInteger;

public class T1 {

    public static void main(String[] args) {
//        Integer a1=new Integer(100);
//        Integer a2=new Integer(100);
//        System.out.println(a1.hashCode()==a2.hashCode());
        Integer b1=100;
        Integer b2=100;
        System.out.println(b1.hashCode()==b2.hashCode());
        b1=200;
        b2=200;
        System.out.println(b1.hashCode()==b2.hashCode());

    }
}
