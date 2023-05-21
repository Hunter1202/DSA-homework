package dsa.com.homework2.bai7;

import dsa.com.homework2.bai6.Card;
import dsa.com.homework2.bai6.DeckOfCards;

public class ShuffleDeckOfCards {
    public static void main(String[] args) {
        //generate a sequence of random integers
        int[] RandomSequence = RandomIntegers.generateRandomIntegers(52, 52);
        DeckOfCards deckOfCards = new DeckOfCards();
        //shuffle the deck
        deckOfCards.shuffle();
        for (Card card : deckOfCards.getCards()) {
            System.out.println(card);
        }
    }
}

