package DataStructure.MyStack;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-15
 * Time: 11:36
 * Description:
 */
public class ReviewStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<> ();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());//4

        System.out.println(stack.peek());//3

        System.out.println(stack.empty());

        System.out.println("==================");

        System.out.println(stack.isEmpty());

        System.out.println(stack.search(4));

        String str = "123";
        int ret = Integer.parseInt(str);
        System.out.println(ret);



    }
}
