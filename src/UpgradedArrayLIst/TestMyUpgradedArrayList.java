package UpgradedArrayLIst;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-13
 * Time: 12:05
 * Description:
 */

class Student {
    private String Lastname;
    private String classes;
    private double score;

    public Student(String lastname, String classes, double score) {
        Lastname = lastname;
        this.classes = classes;
        this.score = score;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Lastname='" + Lastname + '\'' +
                ", classes='" + classes + '\'' +
                ", score=" + score +
                '}';
    }
}




public class TestMyUpgradedArrayList {

    /**
     * interview question, given 2 string, "Welcome to bit", "come"
     * return "wl t bit"
     * @param input
     * @param target
     * @return
     */
    public static String deleteDuplicate1 (String input, String target) {
        List <Character> list = new ArrayList<>();
        for(int i = 0; i < input.length(); i++) {
            boolean flg = true;
            for(int j = 0; j < target.length(); j++){
                if (input.charAt(i) == target.charAt(j)) {
                    flg = false;
                }
            }

            if(flg) list.add(input.charAt(i));
        }
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < list.size(); i++){
            sb.append(list.get(i));
        }

        return sb.toString();

    }


    public static String deleteDuplicate (String input, String target) {
        ArrayList <Character> list = new ArrayList<>();

        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(!target.contains(ch + "")) {
                list.add(input.charAt(i));
            }
        }

        return list.toString();

    }

    public static void main(String[] args) {
        ArrayList <Student> arrayList = new ArrayList<>();
        arrayList.add(new Student("Jasper", "Bit102", 100.00));
        arrayList.add(new Student("Jasper1", "Bit1023", 1001.00));
        arrayList.add(new Student("Jasper2", "Bit1024", 1003.00));
        System.out.println(arrayList);

        String ret = deleteDuplicate1("Welcome to bit", "come");
        System.out.println(ret);

    }
}
