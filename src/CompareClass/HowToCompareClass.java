package CompareClass;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JasperRui
 * Date: 2022-01-22
 * Time: 21:54
 * Description:
 */
class Card implements Comparable<Card> {
    public String suit;
    public int rank;

    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public int compareTo(Card o) {
        return this.rank - o.rank;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", rank=" + rank +
                '}';
    }
}

/*class CardCompare implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        return o1.rank - o2.rank;
    }
}*/

public class HowToCompareClass {
    public static void main(String[] args) {

        //default minHeap
        PriorityQueue<Card> priority= new PriorityQueue<> ();

        //anonymous inner class
        PriorityQueue<Card> priorityQueue = new PriorityQueue<>(new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o1.rank - o2.rank;
            }
        });

        PriorityQueue<Card> priorityQueue1 = new PriorityQueue<> ((x, y) -> {return x.rank - y.rank;});
        priorityQueue.offer(new Card("1", 1));
        //priorityQueue.offer(null);
        priorityQueue.offer(new Card("2", 2));
        priorityQueue.offer(new Card("3", 3));
        priorityQueue.offer(new Card("4", 4));
        System.out.println(priorityQueue);





    }
}
