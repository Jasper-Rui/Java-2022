import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-11
 * Time: 14:45
 * Description:
 */
public class PackingAndUnpacking {

    public static void main(String[] args) {
        MyPrinter <Integer> integerMyPrinter = new MyPrinter<>(100);
        integerMyPrinter.print();
    }

    public static void main3(String[] args) {
        List<String> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        list2.add("Jasper");
        list2.add("Hello");
        System.out.println(list2);

    }

    public static void main1(String[] args) {
        Integer a = 10; // packing
        int b = a; //unpacking
        System.out.println(a + " " + b);
    }

}
