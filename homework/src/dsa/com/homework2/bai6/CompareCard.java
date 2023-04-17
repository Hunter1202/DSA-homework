package dsa.com.homework2.bai6;

import java.util.Comparator;
// compare two cards for sorting
public class CompareCard implements Comparator<Card> {
    public int compare(Card c1, Card c2) {
        return c1.getRank().compareTo(c2.getRank());
    }
}

