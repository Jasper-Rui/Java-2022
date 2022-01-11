/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-10
 * Time: 14:54
 * Description:
 */

class NameException extends RuntimeException {
    public NameException (String message) {
        super(message);
    }
}

class PasswordException extends RuntimeException {
    public PasswordException (String message) {
        super(message);
    }
}

public class UserDefineExceptions {

    public static void main(String[] args) {
        int i = 0;
        while (i < 10) {
            try {
                if(i < 10) {
                    throw new Exception();
                }
            } catch (Exception e) {
                i++;
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }


    public static void main2(String[] args) {
        try {
            throw new Exception("Throw an exception");
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("It run");
        }
    }




    private static String name = "bit";
    private static String password = "123";

    public static void login (String name, String password) throws NameException, PasswordException{
        if (!UserDefineExceptions.name.equals(name)) {
            throw new NameException("Name error");
        }

        if (!UserDefineExceptions.password.equals(password)) {
            throw new PasswordException("Password error");
        }
    }

    public static void main1(String[] args) {
        try {
            login("Jasper", "1234");
        } catch (NameException e) {
            e.printStackTrace();
            System.out.println("Name error");
        } catch (PasswordException e) {
            e.printStackTrace();
            System.out.println("Password error");
        } finally {
            System.out.println("Finally");
        }

    }
}
