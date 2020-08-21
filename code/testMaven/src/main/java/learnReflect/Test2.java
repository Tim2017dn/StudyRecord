package learnReflect;

public class Test2 {

    public static void main(String[] args) throws ClassNotFoundException {

        //get class object

        //method one
        Class<?> class1 = Class.forName("learnReflect.Student");

        //method two
        Class<Student> class2 = Student.class;

        //method 3
        Student s1 = new Student();
        Class<?> class3 = s1.getClass();




    }

}
