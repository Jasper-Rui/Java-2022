import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-14
 * Time: 15:46
 * Description:
 */
public class PascalsTriangle {

    public static List<List<Integer>> generate (int number) {
        List<List<Integer>> list = new ArrayList<>();

        //first row
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        list.add(row1);

        for (int i = 1; i < number; i++) {
            List<Integer> nextrow = new ArrayList<>();
            nextrow.add(1);
            List<Integer> prev = list.get(i - 1);
            for (int j = 1; j < i; j++) {
                int num1 = prev.get(j) + prev.get(j - 1);
                nextrow.add(num1);
            }
            nextrow.add(1);
            list.add(nextrow);
        }
        return list;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = generate(9);
        System.out.println(list);
    }
}
