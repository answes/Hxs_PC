package sample.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * lambda study 2017.08.03
 */
public class LambdaDemo {
    public static void main(String [] arg){
        ListDemo();
    }

    public static void ListDemo(){
        List arrayList = Arrays.asList("test1","test2","test3","test4","test5","test6");
        //mode one
        //arrayList.forEach( n -> System.out.println(n));
        //mode two
        arrayList.forEach(System.out::println);
    }
}
