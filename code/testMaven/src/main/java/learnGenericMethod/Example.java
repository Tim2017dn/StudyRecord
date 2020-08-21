package learnGenericMethod;

import java.util.ArrayList;

public class Example<E> {

    private E str;


    public  Example(E str){
        this.str = str;
    }

    public void show(){
        System.out.println(str);
    }
}
