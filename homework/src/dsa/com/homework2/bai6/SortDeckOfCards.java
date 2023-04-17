package dsa.com.homework2.bai6;

import java.util.Collections;

public class SortDeckOfCards {
    public static void main(String[] args) {
        DeckOfCards deckOfCards = new DeckOfCards();
        //sort deck
        Collections.sort(deckOfCards.getCards(), new CompareCard());
        for (Card card : deckOfCards.getCards()) {
            System.out.println(card);
        }
    }
}


