import javax.lang.model.type.ArrayType;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-09
 * Time: 14:36
 * Description:
 */
public class UnderstandExceptions {

    public static void func (int x) throws ArithmeticException {
        if(x == 0) {
            throw new RuntimeException("x is / by 0");
        }
    }

    public static void main(String[] args) {
        try {
            func(0);
        }
        catch (ArithmeticException e) {
            e.printStackTrace();
        }

    }


    public static void main11(String[] args) {

        int[] array =  {1, 2, 3, 4};
        try{
            System.out.println(array[5]);
        } catch (ArrayIndexOutOfBoundsException exception){
            //or we can
            //catch (ArrayIndexOutOfBoundsException | NullPointerException exception)
            exception.printStackTrace();
            System.out.println("Array Index Out Of Bounds Exception");
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Null Pointer Exception");
        }
        System.out.println("Hello");
    }

    public static void main1(String[] args) {

        //There are two type of exceptions
        //compile exception and runtime exception

        //System.out.println(10 / 0);
        //ArithmeticException, denominator is zero

        String str = null;
        //System.out.println(str.isEmpty());
        //NullPointerException

        int[] array =  {1, 2, 3, 4};
        //System.out.println(array[5]);
        //ArrayIndexOutOfBoundsException


        //inputMIsMatchException

        //LBYL: look before you leak
        //EAFP: It;s easier to ask forgiveness then permission

    }
}
