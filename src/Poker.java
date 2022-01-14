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

        List<Card> cards = BuyCrad();
        System.out.println(cards);
        //initialize cards

        //shuffle cards
        shuffle(cards);
        System.out.println(cards);

        System.out.println("Each player get 5 cards");
        ArrayList <List<Card>> users = new ArrayList<>();
        List<Card> user1 = new ArrayList<>();
        List<Card> user2 = new ArrayList<>();
        List<Card> user3 = new ArrayList<>();

        users.add(user1);
        users.add(user2);
        users.add(user3);


        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                Card card = cards.remove(0);
                users.get(j).add(card);
            }
        }

        System.out.println("User1 cards " + user1);
        System.out.println("User2 cards " + user2);
        System.out.println("User3 cards " + user3);
        System.out.println("Rest cards " + cards);

    }
}
