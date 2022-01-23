package MyPriorityQueueOrHeap;

import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-21
 * Time: 21:50
 * Description:
 */
public class Test {

    public static void main(String[] args) {
        MyHeap myHeap = new MyHeap();
        int[] array = {27,15,19,18,28,34,65,49,25,37};
        myHeap.createMinHeap(array);
        myHeap.offer(80);
        System.out.println("=================");
        System.out.println(myHeap.poll());//80
    }
}
