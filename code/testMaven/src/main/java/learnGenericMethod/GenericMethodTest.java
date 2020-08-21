package learnGenericMethod;

public class GenericMethodTest {

    public static <T> void printArray(T[] inputArray){
        /*for(T element : inputArray){
            System.out.printf("%s ", element);

        }*/

        for(int i=0;i<inputArray.length;i++){
            System.out.print(inputArray[i]+" ");
        }

        System.out.println();
    }

    public static void main(String[] args){
        Integer[] intArray = {1,2,3,4,5};
        Double[] doubleArray = {1.1,2.2,3.3,4.4};
        Character[] charArray = {'H','E','L','L','O'};

        printArray(intArray);
        printArray(doubleArray);
        printArray(charArray);
    }

}
