package HowToUseInterfactes;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-06
 * Time: 14:32
 * Description:
 */

class Student implements Comparable <Student> {
    public String name;
    public int age;
    public double score;

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Student o) {

        //ascending order
        return this.age - o.age;
        //descending order
        //return o.age - this.age;
    }
}

//or we can
class AgeCompator implements Comparator <Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.age - o2.age;
    }
}


public class demo1 {
    public static void main(String[] args) {
        AgeCompator ageCompator = new AgeCompator();
        Student student2 = new Student("jasper1", 12, 18.9);
        Student student1 = new Student("jasper2", 13, 88.9);
        System.out.println(ageCompator.compare(student1, student2));
    }
}
