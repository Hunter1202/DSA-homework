package dsa.com.homework2.bai6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {
    private List<Card> cards;
    //implementation of a deck of 52 cards
    public DeckOfCards() {
        cards = new ArrayList<>();
        String[] suits = {"Dô", "Cơ", "Bích", "Tép"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                String rank = ranks[i];
                cards.add(new Card(rank, suit));
            }
        }
    }
    // shuffle the deck
    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<Card> getCards() {
        return cards;
    }
}

