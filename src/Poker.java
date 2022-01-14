import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-13
 * Time: 19:00
 * Description:
 */

class Card {
    private int rank;
    private String suit;

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "[ " + this.rank + " " + this.suit + " ]";
    }

}







public class Poker {

    private static final String[] suits = {"♥","♠","♣","♦"};

    public static List<Card> BuyCrad () {

        ArrayList<Card> arrayList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                String suit = suits[i];
                int rank = j;
                Card card = new Card(rank,suit);
                arrayList.add(card);
                //or
                //arrayList.add(new Card(j, suits[i]));
            }
        }
        return arrayList;
    }

    private static void swap (List<Card> cards, int i, int rand) {
        Card temp = cards.get(i);
        cards.set(i, cards.get(rand));
        cards.set(rand, temp);
    }

    public static void shuffle (List<Card> cards) {
        int size = cards.size();
        for (int i = size - 1; i > 0; i--) {
            Random random = new Random();
            int rand = random.nextInt(i);
            swap(cards, i, rand);
        }
    }

    public static void main(String[] args) {

        List<Card> list = BuyCrad();
        System.out.println(list);
        //initialize cards

        //shuffle cards
        shuffle(list);
        System.out.println(list);

    }
}
