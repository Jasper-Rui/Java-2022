package DataStructure;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-10
 * Time: 21:00
 * Description:
 */


    //E means, current class is a generic class
    //
class MyArrayList<E> {
    private E[] elem;
    private int usedSize;
    public MyArrayList() {
        this.elem = (E[])new Object[10];
        //this.elem = new E[10];
    }
    public void add(E val) {
        this.elem[usedSize] = val;
        usedSize++;
    }
    public E get(int pos) {
        return this.elem[pos];
    }

    /*public <T> T[] getArray(int size) {
        T[] genericArray = new T[size]; // suppose this is allowed
        return genericArray;
    }*/

    public Object[] getArray(int size) {
        Object[] genericArray = new Object[size];
        return genericArray;
    }

}

public class UnderstandCollection {
    public static void main(String[] args) {
        MyArrayList<String> myArrayList1 = new MyArrayList<>();
        System.out.println(myArrayList1);
        MyArrayList<Integer> myArrayList2 = new MyArrayList<>();
        System.out.println(myArrayList2);
        MyArrayList<Boolean> myArrayList3 = new MyArrayList<>();
        System.out.println(myArrayList3);
    }

    public static void main4(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Jasper", "No.1");
        map.put("Haorui", "No.2");
        map.put("Yang", "No.3");
        String result = map.get("Jasper");
        System.out.println(result);

        String result2 = map.get("Jasperrr");
        System.out.println(result2);
        //if the value corresponding to key doesn't;t exist, it will return null

        String result3 = map.getOrDefault("Jasperrr", "heihei");
        System.out.println(result3);

        boolean flg = map.containsKey("haorui");
        boolean flg1 = map.containsKey("Haorui");
        System.out.println(flg);
        System.out.println(flg1);
        System.out.println(map);

        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> ebtry : entrySet) {
            System.out.println( "Key is " + ebtry.getKey() + " value is " + ebtry.getValue());
        }

    }



    public static void main1(String[] args) {

        Collection<String> collection = new ArrayList<>();
        //generics

        collection.add("Jasper");
        System.out.println(collection.size());

        Collection<Integer> collection1 = new ArrayList<>();
        //what's inside <> must be a class type
        //int is not one of them, but Integer is ok
        collection1.add(12);
        collection1.add(123);
        collection1.add(1234);
        System.out.println(collection1);
        collection1.clear();
        System.out.println(collection1);

    }
}
