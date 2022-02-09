import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-02-08
 * Time: 15:39
 * Description:
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> competitions = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("html");
        list1.add("java");
        competitions.add(list1);

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("java");
        list2.add("py");
        competitions.add(list2);


        ArrayList<String> list3 = new ArrayList<>();
        list3.add("py");
        list3.add("html");
        competitions.add(list3);

        ArrayList<String> list4 = new ArrayList<>();
        list4.add("c");
        list4.add("py");
        competitions.add(list4);

        ArrayList<String> list5 = new ArrayList<>();
        list5.add("java");
        list5.add("c");
        competitions.add(list5);

        ArrayList<String> list6 = new ArrayList<>();
        list6.add("c");
        list6.add("html");
        competitions.add(list6);


        ArrayList<Integer> results = new ArrayList<>();
        results.add(0);
        results.add(1);
        results.add(1);
        results.add(1);
        results.add(0);
        results.add(1);

        System.out.println(tournamentWinner(competitions, results));
    }

    public static String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        // Write your code here.

        int max = 0;
        String result = "";
        HashMap <String, Integer> map = new HashMap<>();
        for(int i = 0; i < competitions.size(); i++) {
            int winner = results.get(i);

            //competitions form is [home, away]
            //if reulst == 1, home win, key index is 0
            //if result == 0. away win, key index is 1
            if(winner == 1) winner = 0;
            else winner = 1;

            String key = competitions.get(i).get(winner);
            if(map.containsKey(key)) {
                map.replace(key, map.get(key) + 1);
                if(map.get(key) > max) {
                    max = map.get(key);
                    result = key;
                }
            }
            else map.put(key, 1);
        }

        return result;
    }

}
