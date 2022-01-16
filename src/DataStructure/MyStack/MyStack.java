package DataStructure.MyStack;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-14
 * Time: 20:53
 * Description:
 */

class StackMine {
    public int elem[];
    public int usedSize;

    public StackMine() {
        this.elem = new int[5];
    }

    public void push (int val) {
        if(isFUll()) {
            //expand
            Arrays.copyOf(this.elem, 2 * this.elem.length);
        }
        this.elem[this.usedSize++] = val;
    }

    public boolean isFUll () {
        return this.usedSize == this.elem.length;
    }

    public int pop() {
        if(isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        int temp = this.elem[this.usedSize - 1];
        this.usedSize--;
        return temp;
    }

    public boolean isEmpty() {
        return this.usedSize == 0;
    }

    public int peek() {
        if(isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        int temp = this.elem[this.usedSize - 1];
        return temp;
    }

}

public class MyStack {

    public static void main(String[] args) {
        StackMine myStack = new StackMine();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.pop();
        System.out.println(myStack.peek());
    }
}
