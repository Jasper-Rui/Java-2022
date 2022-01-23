package CompareClass;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-22
 * Time: 23:10
 * Description:
 */
public class TOPK {

    public static int []  TopK (int [] array, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < array.length; i++) {
            if(maxHeap.size() < k) {
                maxHeap.offer(array[i]);
            }
            else {
                int max = maxHeap.peek();
                if(array[i] > max) {
                    maxHeap.poll();
                    maxHeap.offer(array[i]);
                }
            }
        }
        int [] temp = new int[k];
        for(int i = 0; i < k; i++) {
            temp[i] = maxHeap.poll();
        }

        return temp;
    }


    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>(k, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return (o1.get(1) + o2.get(1)) - (o1.get(0) + o2.get(0));
            }
        });
        return null;
    }




    public static void main(String[] args) {
        int[] array = {18, 21, 8, 10, 34, 12};
        int [] temp = TopK(array, 3);
        System.out.println(Arrays.toString(temp));
    }
}
