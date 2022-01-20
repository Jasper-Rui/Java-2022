package MyBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-16
 * Time: 22:01
 * Description:
 */
public class TestDemo {

    public static boolean backspaceCompare(String s, String t) {

        if(s == null || t == null) return false;
        //empty is not null

        StringBuilder str1 = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != '#') {
                str1.append(s.charAt(i));
            }
            else {
                int len = str1.length();
                //assume length is 5, so we want delet index 4, so it's (4, 5)
                str1 = str1.delete(len - 1, len);
            }
        }

        StringBuilder str2 = new StringBuilder();
        for(int i = 0; i < t.length(); i++) {
            if(t.charAt(i) != '#') {
                str2.append(t.charAt(i));
            }
            else {
                int len = str2.length();
                //assume length is 5, so we want delet index 4, so it's (4, 5)
                str2 = str2.delete(len - 1, len);
            }
        }
        System.out.println(str1);
        System.out.println(str2);


        return str1.toString().equals(str2.toString());
    }

    public static void main(String[] args) {
        MyBinaryTree myBinaryTree = new MyBinaryTree();
        BTNode root = myBinaryTree.createTree();
        myBinaryTree.preOrder(root);
        System.out.println();
        myBinaryTree.inOrder(root);
        System.out.println();
        myBinaryTree.postOrder(root);


        //Double a = new Integer(1);
        //Double o1 = true ? new Integer(1) : new Double(2.0);
        //System.out.println(o1);

        //Object o2 = new Integer(1);
        //System.out.println(o2);

        System.out.println(14 ^ 3);


        byte a = 127;
        byte b = 127;
        a += b;
        System.out.println(b);


        StringBuilder sb = new StringBuilder("");
        sb.append('a');
        sb.append('a');
        sb.append('a');
        sb.append('a');
        sb.delete(3, 4);
        System.out.println(sb);


        System.out.println(backspaceCompare("ab#c", "ad#c"));

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        int count = 0;
        while (!queue.isEmpty() && queue.peek() < 5) {
            queue.poll();
            count++;
        }
        System.out.println(count);
        System.out.println(queue);

        int i = 0;
        for(out('a'); out('b') && (i < 2); out('c')) {
            i++;
            out('D');
        }


        //Integer integer = new Integer(1);
        //Integer integer1 = integer;
        //dosomething(integer1);
        System.out.println();
        //System.out.println(integer1);
        //System.out.println(integer == integer1);

        System.out.println(false && false);


    }

    //public static void  dosomething (Integer integer) { integer = new Integer(2); }


    static boolean out (char c) {
        System.out.print(c);
        return true;
    }




}
