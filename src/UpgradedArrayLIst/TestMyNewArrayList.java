package UpgradedArrayLIst;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-12
 * Time: 10:54
 * Description:
 */

class MyNewArrayList <E> {
    private Object[] elementdata;
    private static final int DEFAULT_CAPACITY = 10;
    private int usedSize;

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    public MyNewArrayList(){
        this.elementdata = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public MyNewArrayList(int capacity){
        //capacity
        if(capacity > 0) {
            this.elementdata = new Object[capacity];
        }
        else if(capacity == 0) {
            this.elementdata = new Object[0];
        }
        else {
            throw new IllegalArgumentException("initial capacity can not be negative");
        }
    }

    /**
     *
     * @param e elemenet to be added
     * @return true if added successfully otherwise false
     */
    public boolean add (E e) {
        //make sure that the list has enough space
        ensureCapacityInternal(usedSize + 1);
        ensureCapacityInternal(usedSize+1);
        elementdata[usedSize] = e;
        usedSize++;
        return true;
    }

    private void ensureCapacityInternal(int minCapacity) {
        //calculate required capacity
        int capacity = calculateCapacity(elementdata, minCapacity);
        //test if the capacity need to grow
        ensureExplicitCapacity(capacity);
    }

    private void ensureExplicitCapacity (int minCapacity) {
        //minCapacity - element data.length determine if the capacity is full or not
        if(minCapacity - elementdata.length > 0) {
            //expand
            grow(minCapacity);
        }
    }

    private static final int MAX_ARRAY_SIZE =  Integer.MAX_VALUE-8;
    private void grow(int minCapacity) {
        int oldCapacity = elementdata.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);//1.5 times oly capacity
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE> 0)
            //means that the capacity required is extremely large
            newCapacity = hugeCapacity(minCapacity);
        elementdata = Arrays.copyOf(elementdata, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0)
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    public static int calculateCapacity(Object[] elementdata, int minCapacity) {
        if(elementdata == DEFAULTCAPACITY_EMPTY_ELEMENTDATA){
            return Math.max(10, minCapacity);
        }
        return minCapacity;
    }

    /**
     * add a new element at index
     * @param index
     * @param e
     */
    public void add (int index, E e) {
        //check if index is legal
        rangeCheckForAdd(index);
        //check capacity availability
        ensureCapacityInternal(usedSize + 1);
        //copy and move data
        copy(index, e);
        //increment size
        usedSize++;
    }

    private void copy (int index, E e) {
        for(int i = usedSize - 1; i >= index; i--){
            elementdata[i + 1] = elementdata[i];
        }
        elementdata[index] = e;
    }

    private void rangeCheckForAdd (int index) {
        if(index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
    }

    public int size () {
        return this.usedSize;
    }


}


public class TestMyNewArrayList {
    public static void main(String[] args) {
        MyNewArrayList<String> myNewArrayList = new MyNewArrayList<>();
        myNewArrayList.add("Jasper");
        myNewArrayList.add("Haorui");
        myNewArrayList.add("Yang");
        myNewArrayList.add("Best");
        myNewArrayList.add(2, "guess");
        myNewArrayList.add("1");

    }
}
