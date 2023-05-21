package dsa.com.homework2.bai6;

//Card class with rank and suit attributes
public class Card implements Comparable<Card> {
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String toString() {
        return rank + " " + suit;
    }

    //    @Override
//    public int compareTo(Card other) {
//        return Integer.compare(rank, other.rank);
//    }
    @Override
    public int compareTo(Card other) {
        int suitComparison = suit.compareTo(other.suit);
        if (suitComparison != 0) {
            return suitComparison;
        } else {
            return CharSequence.compare(rank, other.rank);
        }
    }
}

