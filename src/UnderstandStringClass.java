import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-07
 * Time: 20:27
 * Description:
 */
public class UnderstandStringClass {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("abcd");
        sb.append("Jasper");
        System.out.println(sb);

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Jasper");
        System.out.println(stringBuffer);

        sb.reverse();
        System.out.println(sb);

    }

    public static void main26(String[] args) {
        String str = "Jasper";
        String ret = str.concat(" is the best");
        System.out.println(ret);
        String strr = "";
        System.out.println(strr.isEmpty());
        System.out.println(str.isEmpty());
    }

    public static void main25(String[] args) {
        String str = "              jasper              ";
        System.out.println(str.trim());
        System.out.println(str.toLowerCase());
        System.out.println(str.trim().toUpperCase());
    }

    public static void main24(String[] args) {
        String str = "Jasper";
        String ret = str.substring(2, 4);
        System.out.println(ret);
    }

    public static void main23(String[] args) {
        String str = "Java30 12&21#hello";
        String[] strings = str.split(" |&|#");
        System.out.println(Arrays.toString(strings));
    }

    public static void main22(String[] args) {
        String str = "192.168.1.1";
        String[] strings = str.split("\\.", 2);
        System.out.println(Arrays.toString(strings));

        String str1 = "192\\168\\1\\1";
        String[] stringss = str1.split("\\\\"); // "\\\\" -> "\\" -> \
        System.out.println(Arrays.toString(stringss));
    }

    public static void main20(String[] args) {
        String str = "Jasper&jasper&haorui&hao";
        String[] strings = str.split("&");
        System.out.println(Arrays.toString(strings));
    }

    public static void main19(String[] args) {
        String str = "Jasper is jasper and jasper is Jasper";
        String ret = str.replace('J', 'Y');
        System.out.println(ret);
        String ret2 = str.replace("Jasper", "haorui");
        System.out.println(ret2);
        String ret3 = str.replaceFirst("Jasper", "haorui");
        System.out.println(ret3);
    }

    public static void main17(String[] args) {
        String str = "abcdefgabcd";
        String tmp = "abcd";
        int index = str.lastIndexOf(tmp, 5);
        System.out.println(index);

        System.out.println(str.startsWith(tmp, 7));

        System.out.println(str.endsWith(tmp));
    }

    public static void main16(String[] args) {
        String str = "abcdefgabcd";
        String tmp = "abcd";
        boolean flg = str.contains(tmp);
        System.out.println(flg);
        System.out.println("===================");

        int index = str.indexOf(tmp, 2);
        System.out.println(index);
    }

    public static void main15(String[] args) {
        //methods in String
        //1. true / false
        String str1 = "abc";
        String str2 = "bcd";
        System.out.println(str1.equals(str2));
        //2. size
        System.out.println(str1.length());

        String str3 = "abc";
        String str4 = "ABC";
        System.out.println(str3.equalsIgnoreCase(str4));
        System.out.println(str3.compareTo(str4));// 'a' - 'A' == 97 - 65 = 32


    }

    public static void main14(String[] args) throws UnsupportedEncodingException {
        byte[] bytes = {97, 98, 99, 100};
        String str = new String(bytes);
        System.out.println(str);

        String str1 = new String(bytes, 1, 3);
        System.out.println(str1);

        //String str2 = new String(bytes, 14); //outdated
        //System.out.println(str2);

        String str3 = "bit";
        byte[] bytess = str3.getBytes("utf-8");
        System.out.println(Arrays.toString(bytess));

    }

    public static boolean isNumberChar (String s) {
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            boolean flg = Character.isDigit(c);
            if(flg == false) {
                return false;
            }
            /*if(c < '0' || c > '9') {
                return false;
            }*/
        }
        return true;
    }

    public static void main13(String[] args) {
        String s = "12341514";
        System.out.println(isNumberChar(s));
    }

    public static void main12(String[] args) {
        //there are 2 constructors for string
        //1.
        char[] val = {'a', 'b', 'c', 'd', 'e', 'f'};
        String str = new String(val);
        System.out.println(str);// str will not be added to pool

        //2.
        String str1 = new String(val, 1 ,3);
        System.out.println(str1);
        System.out.println("===================");

        String str2 = "hello";
        char ch = str2.charAt(2);
        System.out.println(ch);

        char[] chars = str2.toCharArray();
        System.out.println(Arrays.toString(chars));
    }



    public static void main99(String[] args) {
        String str1 = "11";
        String str2 = null;
        System.out.println(str1.equals(str2));//fasle
        System.out.println(str2.equals(str1)); // null pointer exception
    }

    public static void main11(String[] args) {

        String str2 = new String("1") + new String("1");
        String str1 = "11";
        System.out.println(str1 == str2);//false
        str2.intern();//if "11" is in the pool, return the string from the pool, otherwise add it to pool
        System.out.println(str1 == str2);//false
        str2 = str2.intern();
        System.out.println(str1 == str2);//true
    }

    public static void main7(String[] args) {
        String str1 = "11";
        String str2 = new String("1") + new String("1");
        System.out.println(str1 == str2);
        char[] chars = {'a', 'b', 'c'};
        String str3 = new String(chars);
        String str4 = "abc";
        System.out.println(str3 == str4);
    }

    public static void main3(String[] args) {
        String str = "Jasper";
        String str1 = "Jasper";
        String str2 = new String("Jasper");
        String str3 = "Ja" + "sper";
        String str4 = "Jas";
        String str5 = str4 + "per"; //here str4 is a variable, compiler doesn't know what it is during compiling
        System.out.println(str == str1); // true
        System.out.println(str == str3); // true
        System.out.println(str2 == str1); // false
        System.out.println(str == str5); // fasle
    }

    public static void main1(String[] args) {
        String str = "Jasper";

        //using constructor to create a new object "Jasper"
        String str2 = new String("Jasper");
        System.out.println(str.equals(str2));
        System.out.println(str == str2);

        char[] chars = {'a', 'b', 'c'};
        String str3 = new String(chars);
        String str4 = new String("abc");
        System.out.println(str3);

    }
}
