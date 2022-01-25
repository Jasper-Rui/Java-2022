package MyPriorityQueueOrHeap;

import java.util.Comparator;
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
        String title = "aa bb cc";

        String[] array = title.split(" ");
        for(int i = 0; i < array.length; i++) {
            String temp = array[i];
            if(temp.length() == 1) continue;
            array[i] = Character.toUpperCase(temp.charAt(1)) + temp.substring(1).toLowerCase();
            System.out.println(array[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if(i < array.length - 1) sb.append(" ");
        }
        //return sb.toString();
    }


    public static int findKthLargest(int[] nums, int k) {
        if(nums == null || k < 0) return 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k);
        for(int i = 0; i < nums.length; i++){
            if(priorityQueue.size() < k) {
                priorityQueue.offer(nums[i]);
            }

            if(nums[i] > priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(nums[i]);
            }
            else {
                continue;
            }
        }

        return priorityQueue.peek();
    }

    public static void main1(String[] args) {
        MyHeap myHeap = new MyHeap();
        int[] arra2y = {27,15,19,18,28,34,65,49,25,37};
        myHeap.createMinHeap(arra2y);
        myHeap.offer(80);
        System.out.println("=================");
        System.out.println(myHeap.poll());//80

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(3, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        priorityQueue.offer(-1);
        priorityQueue.offer(0);
        priorityQueue.offer(2);
        priorityQueue.offer(3);
        priorityQueue.offer(4);
        System.out.println(priorityQueue.peek());


        int[] array = {-1, 2, 0};
        //System.out.println(findKthLargest(array, 2));
    }
}
