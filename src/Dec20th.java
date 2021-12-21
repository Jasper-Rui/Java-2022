import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2021-12-20
 * Time: 16:32
 * Description:
 */
class Calculator {
    private int num1;
    private int num2;

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int add () {
        return num1 + num2;
    }

    public int sub () {
        return num1 - num2;
    }

    public int mul () {
        return num1 * num2;
    }

    public int div () {
        return num1 / num2;
    }

}

class myValue {
    public int value;
}

public class Dec20th {

    public static void swap (myValue val1, myValue val2) {
        int temp = val1.value;
        val1.value = val2.value;
        val2.value = temp;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setNum1(1);
        calculator.setNum2(2);
        System.out.println(calculator.add());

        myValue myValue1 = new myValue();
        myValue1.value = 10;

        myValue myValue2 = new myValue();
        myValue2.value = 20;



    }
}
