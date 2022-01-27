package Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-24
 * Time: 9:41
 * Description:
 */
public class Sort {
    //ShellSort a.k.a. Diminishing Increment Sort

    public static void insertionSortDay2 (int[] array) {
        for(int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if(array[j] > temp) {
                    break;
                }
            }
            array[j + 1] = temp;
        }
    }




    public static void shell (int[] array, int gap) {
        for(int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - gap;
            for(; j >= 0; j = j - gap) {
                if(array[j] > temp) {
                    array[j + gap] = array[j];
                }
                else{
                    break;
                }
            }
            array[j + gap] = temp;
        }

    }

    public static void shellSort (int[] array) {
        int gap = array.length;

        while (gap > 1) {
            shell(array, gap);
            gap /= 2;
        }
        shell(array, 1);
    }

    /**
     * Time complexity : O(n ^ 2)
     * Space complexity : O(1)
     * unstable
     * @param array array to be sorted
     */
    public static void selectSort(int[] array) {
        int i = 0;
        int j = 0;

        int min = array[0];

        for (i = 0; i < array.length; i++) {
            for(j = i + 1; j < array.length; j++) {
                //for every possibility it will swap, but we only need to swap the minimum one
                if(array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
        }
    }

    public static void swap (int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void selectSortOptimized(int[] array) {
        int i = 0;
        int j = 0;

        for (i = 0; i < array.length; i++) {
            int minIndex = i;
            for(j = i + 1; j < array.length; j++) {
                if(array[minIndex] > array[j]) {
                    minIndex = j;
                }
                swap(array, i, minIndex);
            }
        }
    }


    public static void test1 (int capacity) {
        int[] array = new int[capacity];

        Random random = new Random();

        for(int i = 0; i < capacity; i++) {
            array[i] = random.nextInt(capacity);
        }

        long start = System.currentTimeMillis();
        //shellSort(array);
        selectSort(array);
        //selectSortOptimized(array);
        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }

    public static void test2 (int capacity) {
        int[] array = new int[capacity];

        Random random = new Random();

        for(int i = 0; i < capacity; i++) {
            array[i] = i;
        }

        long start = System.currentTimeMillis();
        //shellSort(array);
        selectSort(array);
        //selectSortOptimized(array);
        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }

    /**
     *
     * @param array
     */
    public static void doubleSideSort(int[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            //end start represent the range [start, end] to be sorted
            int min = start;
            int max = start;

            for(int i = start; i <= end; i++) {
                if(array[i] < array[min]) {
                    min = i;
                }
                if(array[i] > array[max]) {
                    max = i;
                }
            }
            //each time we will have a min and a max
            //put max to array[end], end will decrement every time
            //put min to array[start], end will increment every time
            swap(array, min, start);
            //array = { 9, 5, 2, 7, 3, 6, 8 }; // 交换之前
            // start = 0; end = 6
            // max = 0; min = 2

            if(max == start) {
                max = min;
            }
            swap(array, max, end);
            start++;
            end--;
        }
    }

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


    /**
     * Time complexity O(n * log(n))
     *
     * Space complexity O(1)
     *
     * @param array
     */
    public static void heapSort(int[] array) {
        createHeap(array);
        int end = array.length - 1;
        while (end >= 0) {
            swap(array, 0, end);
            shiftDown(array, 0, end);
            end--;
        }
    }

    private static void createHeap (int[] array) {
        for (int parent = (array.length - 1 - 1) / 2; parent >= 0 ; parent--) {
            shiftDown(array, parent, array.length);
        }
    }


    private static void shiftDown (int[] array, int parent, int len) {
        int child = parent * 2 + 1;
        while (child < len) {
            if(child + 1 < len && array[child + 1] > array[child]) {
                child++;
            }
            if(array[child] > array[parent]) {
                swap(array, child, parent);
                parent = child;
                child = parent * 2;
            }
            else {
                break;
            }
        }
    }

    /**
     * Time complexity O(n ^ 2)
     * Best case O(n)
     * Space complexity O(1)
     * Stable
     * @param array
     */
    public static void bubbleSort(int [] array) {

        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length - i - 1; j++) {
                if(array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }


    public static void bubbleSortOptimized(int [] array) {

        for(int i = 0; i < array.length; i++) {
            boolean flg = false;
            for(int j = 0; j < array.length - i - 1; j++) {

                if(array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    flg = true;
                }
            }
            //if flg is false, means it is sorted
            if(flg == false) {
                break;
            }
        }
    }


    /**
     * Time complexity best : O(n * log(n))
     * Worse O(n ^ 2)
     * Space complexity O(log(n))
     * Worse O(n) single branch tree
     * Unstable
     * @param array
     */
    public static void quickSort(int [] array) {
        quick(array, 0, array.length - 1);
    }

    public static void quick(int [] array, int start, int end) {
        if(start >= end) return;
        int pivot = partition(array, start, end);
        quick(array, start, pivot - 1);
        quick(array, pivot + 1, end);
    }

    private static int partition (int[] array, int start, int end) {
        int temp = array[start];
        while (start < end) {
            while (start < end && array[end] >= temp) {
                end--;
            }
            //end now is the index which smaller than temp
            array[start] = array[end];
            while (start < end && array[start] <= temp) {
                start++;
            }
            array[end] = array[start];
        }
        array[start] = temp;
        //now start == end
        return start;
    }

    /**
     *
     * @param array1 有序的
     * @param array2 有序的
     * @return
     */
    public static int[] mergeArray(int[] array1,int[] array2) {
        int[] finalarray = new int[array1.length + array2.length];
        int i = 0;
        int j = 0;
        int index = 0;
        while(i < array1.length && j < array2.length) {
            if(array1[i] <= array2[j]) {
                finalarray[index++] = array1[i++];
            }

            if(array1[j] <= array2[i]) {
                finalarray[index++] = array2[j++];
            }
        }

        while (i < array1.length ) {
            finalarray[index++] = array1[i++];
        }

        while (j < array2.length) {
            finalarray[index++] = array2[j++];
        }
        return finalarray;
    }

    public static void mergeSort2(int[] array) {
        mergeSortInternal(array, 0, array.length - 1);
        //merge(array, low, mid, high);
    }

    public static void mergeSortInternal(int[] array, int low, int high) {

        int mid = low + ((high - low) >>> 1);

        mergeSortInternal(array, low, mid);
        mergeSortInternal(array, mid + 1, high);
        merge(array, low, mid, high);
    }
    private static void merge (int[] array, int low, int mid, int height) {


    }

    public static void main(String[] args) {
        int[] array = {12, 5, 8, 2, 4, 10, 0, 100, 111};
        //shellSort(array);
        //selectSortOptimized(array);
        //System.out.println(Arrays.toString(array));
        //test1(10_0000);
        //test2(10_0000);
        //bubbleSort(array);
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }



}
