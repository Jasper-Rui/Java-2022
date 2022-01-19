package MyQueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-16
 * Time: 1:24
 * Description:
 */
public class UnderstandBasicQueue {

    public static void main(String[] args) {



        Deque <Integer> queue = new LinkedList<>();
        queue.offer(1);
        //default add to last
        queue.offerFirst(2);
        //now this queue is 2 1
        System.out.println(queue);
        System.out.println(queue.peek());//2
        System.out.println(queue.peekFirst());//2
        System.out.println(queue.peekLast());//1

    }

    public static void mainq(String[] args) {
        Queue <Integer> queue = new LinkedList<>();

        queue.offer(2);
        System.out.println(queue.peek());
        System.out.println(queue.poll());

        queue.add(1);
        System.out.println(queue.element());
        System.out.println(queue.remove());
    }
}
