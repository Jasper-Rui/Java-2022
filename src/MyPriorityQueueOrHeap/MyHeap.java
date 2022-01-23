package MyPriorityQueueOrHeap;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-21
 * Time: 22:03
 * Description:
 */
public class MyHeap {
    public int elem[];
    public int usedSize;

    public MyHeap() {
        this.elem = new int[10];
    }

    public MyHeap(int capacity) {
        this.elem = new int[capacity];
    }

    public void shiftDown(int parent, int len) {
        int child = parent * 2 + 1;

        //1. at least the parent has a left child
        while (child < len) {
            if((child + 1) < len && this.elem[child] < this.elem[child + 1]) {
                child++;
            }
            //swap if child is larger than parent
            if(this.elem[child] > this.elem[parent]) {
                int temp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = temp;
                parent = child;
                child = parent * 2 + 1;
            }
            else{
                break;
            }
        }
    }

    public void createMinHeap (int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }

        for(int parent = (this.usedSize - 1 - 1) / 2; parent >= 0; parent--) {
            shiftDown(parent, this.usedSize);
        }
    }

    private void shiftUp (int child) {
        int parent = (child - 1) / 2;
        while (child > 0) {
            if(this.elem[child] > this.elem[parent]) {
                int temp = this.elem[child];
                this.elem[child] = this.elem[parent];
                this.elem[parent] = temp;
                child = parent;
                parent = (child - 1) / 2;
            }
            else {
                break;
            }
        }
    }

    public void offer (int value) {
        if(isFull()) {
            this.elem = Arrays.copyOf(this.elem, 2 * this.elem.length);
        }
        this.elem[this.usedSize++] = value;
        shiftUp(this.usedSize - 1);
    }

    public boolean isFull () { return this.usedSize == this.elem.length;}

    public int poll () {
        if(isEmpty()) {
            throw new RuntimeException("PriorityQueue is empty");
        }
        int temp = this.elem[0];
        this.elem[0] = this.elem[this.usedSize - 1];
        this.elem[this.usedSize - 1] = temp;
        this.usedSize--;

        shiftDown(0, this.usedSize);
        return temp;
    }

    public boolean isEmpty () {
        return this.usedSize == 0;
    }


    public int peek () {
        if(isEmpty()) {
            throw new RuntimeException("PriorityQueue is empty");
        }
        return this.elem[0];
    }



    public void headSort () {

        int end = this.usedSize - 1;

        while (end != 0) {
            int temp = this.elem[end];
            this.elem[end] = this.elem[0];
            this.elem[0] = temp;
            shiftDown(0, end);
            end--;
        }
    }








}
