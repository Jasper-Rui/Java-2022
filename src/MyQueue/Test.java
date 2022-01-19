package MyQueue;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-17
 * Time: 15:27
 * Description:
 */

class RecentCounter {
    public Queue<Integer> queue;

    public RecentCounter() {
        this.queue = new LinkedList<>();
    }

    public int ping(int t) {

        this.queue.offer(t);

        while(!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }

        return queue.size();
    }
}


public class Test {
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));     // requests = [1], range is [-2999,1], return 1
        System.out.println(recentCounter.queue);
        System.out.println(recentCounter.ping(100));   // requests = [1, 100], range is [-2900,100], return 2
        System.out.println(recentCounter.queue);
        System.out.println(recentCounter.ping(3001));  // requests = [1, 100, 3001], range is [1,3001], return 3
        System.out.println(recentCounter.queue);
        System.out.println(recentCounter.ping(3002));  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
        System.out.println(recentCounter.queue);
        System.out.println(recentCounter.ping(3003));  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
        System.out.println(recentCounter.queue);
        System.out.println(recentCounter.ping(7000));  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
        System.out.println(recentCounter.queue);
        System.out.println(recentCounter.ping(7001));  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
        System.out.println(recentCounter.queue);
        System.out.println(recentCounter.ping(7002));  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
        System.out.println(recentCounter.queue);


        int n = 2;
        System.out.println(n / 2);
    }
}
