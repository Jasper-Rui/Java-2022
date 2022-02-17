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
        int [][] array = {{1, 2, 3, 4, 5, 6}};
        System.out.println(array.length);
        int col = array.length - 1; // 0
        int row = array[0].length - 1; // 5
        List<Integer> result = new ArrayList<Integer>();
        helper(array, 0, col, row, result);
        System.out.println(result);
    }

    public static void main22(String[] args) {
        int[][] array = {{1,2,3,4}, {12,13,14,5}, {11,16,15,6}, {10,9,8,7}};
        int[][] array2 = {
                {1,2,3,4},
                {10,11,12,5},
                {9,8,7,6}};
        List<Integer> result = new ArrayList<Integer>();
        helper(array2, 0, 2, 3, result);
        System.out.println(result);
    }

    public static void helper(int[][] array, int index, int col, int row, List<Integer> result) {
        if(index > col) {
            return;
        }

        if(index > row) {
            return;
        }
        //add first row
        for(int i = index; i <= row; i++) {
            result.add(array[index][i]);
        }

        //remove duplicate
        result.remove(result.size() - 1);

        //add first row
        for(int i = index; i <= col; i++) {
            result.add(array[i][row]);
        }

        //remove duplicate
        result.remove(result.size() - 1);

        //add last col
        for(int i = row; i >= index; i--) {
            result.add(array[col][i]);
        }

        //remove duplicate
        result.remove(result.size() - 1);

        for(int i = col; i >= index; i--) {
            result.add(array[i][index]);
        }

        result.remove(result.size() - 1);
        helper(array, ++index, --col, --row, result);
    }

    public static void main55(String[] args) {
        var Jasper = "Jasper";
        System.out.println(Jasper instanceof String);

        int flg1 = -99 >> 31;
        int flg2 = 99 >> 31;
        System.out.println(flg1);
        System.out.println(flg2);
    }

    public static void main3(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.set(1, 4);
        list.set(4, 1);
        System.out.println(list);
    }

    public static void main2(String[] args) {
        Integer[] res = new Integer[3];
        res[0] = 0;
        res[1] = 1;
        res[2] = 2;


        Integer[] ress = new Integer[3];
        ress[0] = 0;
        ress[1] = 2;
        ress[2] = 1;

        List<Integer[]> result = new ArrayList<Integer[]>();
        result.add(res);
        result.add(ress);
        result.sort(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0] - o2[0];
            }
        });

        result.add(new Integer[] {1, 2, 3});
        System.out.println(Arrays.equals(res, ress));

        List<Integer> list = new ArrayList<>();
        list.add(0);



    }


    public static void main1(String[] args) {
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
