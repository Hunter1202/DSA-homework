package dsa.com.homework2.bai7;

import dsa.com.homework2.bai6.Card;

import java.util.Comparator;
import java.util.Random;

//RandomSequence class that implements the Comparator<Card> interface
public class RandomSequence extends Random implements Comparator<Card> {
    //implementation that generates a sequence of N random integers
    private int[] randomIntegers;
    private int currentIndex;

    public RandomSequence(int[] randomIntegers) {
        this.randomIntegers = randomIntegers;
        this.currentIndex = 0;
    }

    @Override
    public int compare(Card card1, Card card2) {
        int result = Integer.compare(randomIntegers[currentIndex], randomIntegers[currentIndex + 1]);
        currentIndex += 2;
        return result;
    }

    @Override
    public Comparator<Card> reversed() {
        return Comparator.super.reversed();
    }
}

