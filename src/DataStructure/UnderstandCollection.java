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
public class UnderstandCollection {

    public static void main(String[] args) {
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
