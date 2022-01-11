package DataStructure;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-10
 * Time: 21:00
 * Description:
 */
public class UnderstandCollection {
    public static void main(String[] args) {

        Collection<String> collection = new ArrayList<>();
        //generics

        collection.add("Jasper");
        System.out.println(collection.size());

        Collection<Integer> collection1 = new ArrayList<>();
        //what's inside <> must be a class type
        //int is not one of them, but Integer is ok
        collection1.add(12);
        collection1.add(123);
        collection1.add(1234);
        System.out.println(collection1);
        collection1.clear();
        System.out.println(collection1);
    }
}
