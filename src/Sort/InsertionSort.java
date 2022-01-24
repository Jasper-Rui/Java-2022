package Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-23
 * Time: 0:00
 * Description:
 */
public class InsertionSort {


    /**
     * stable sort if it preserves the order of duplicate keys
     * Time complexity O(n^2)
     *          best is O(n)
     * Space complexity O(1)
     * @param array
     */
    public static void insertionSort (int[] array) {

        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            int temp = array[i];
            for (; j >= 0 ; j--) {
                if(temp > array[j]) {
                    break;
                }
                else {
                    array[j + 1] = array[j];
                }
            }
            array[j + 1] = temp;
        }
    }








    public static void main(String[] args) {
        int[] array = {12, 5, 18, 10, 3};
        insertionSort(array);
        System.out.println();

        List<Integer> list1 = new ArrayList<>();


    }
}
