import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-11
 * Time: 22:19
 * Description:
 */
public class TestIterator {

    public static void main(String[] args) {
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("abc");
        list2.add("hello");
        list2.add("bit");
        list2.add("haha");
        System.out.println(list2);
        //[abc, hello, bit, haha]
        //list default add to last

        list2.add(3, "Jasper");
        System.out.println(list2);
        //[abc, hello, bit, Jasper, haha]

        ArrayList<String> list3 = new ArrayList<>();
        list3.add("a");
        list3.add("b");
        list3.add("c");

        list2.addAll(list3);
        System.out.println(list2);
        //[abc, hello, bit, Jasper, haha, a, b, c]

        String ret = list2.remove(0);
        System.out.println(ret);
        System.out.println(list2);
    }

    public static void main4(String[] args) {
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("hello");
        list2.add("bit");
        list2.add("haha");

        Iterator<String> iterator = list2.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if(s.equals("hello")) {
                iterator.remove();
            }
            else{
                System.out.print(s + " ");
            }
        }


    }
    public static void main3(String[] args) {
        ArrayList<String> list2 = new ArrayList<>();
        //CopyOnWriteArrayList<String> list2 = new CopyOnWriteArrayList<>();
        list2.add("hello");
        list2.add("bit");
        list2.add("haha");

        System.out.println(list2);
        System.out.println("==================");
        for (String s: list2) {
            System.out.println(s);
        }

        System.out.println("==================");
        Iterator<String> iterator = list2.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.println("==================");

        ListIterator<String> listIterator = list2.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println();

    }
}
