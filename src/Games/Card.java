package Games;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

enum  Suits {Clubs, Diamonds, Spades, Hearts};
enum Ranks {Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace};

public class Card implements Comparable<Card>{
    public Suits suit;
    public Ranks rank;


    public Card(Suits suit, Ranks rank){
        this.suit = suit;
        this.rank = rank;
    }

    public Card(){}

    public Suits getSuit() {
        return suit;
    }

    public void setSuit(Suits suit){
        this.suit = suit;
    }

    public Ranks getRank(){
        return rank;
    }

    public void setRank(Ranks rank){
        this.rank = rank;
    }

    public String toString(){
        return rank + " of "+ suit;
    }

    public String rankToString(){
        return rank + "";
    }

    public int hashCode(){
        return Objects.hash(rank,suit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Card card = (Card) o;
        return suit == card.suit && rank == card.rank;
    }

    public int compareTo(Card that){
        return this.rank.compareTo(that.rank);
    }


    public static ArrayList<Card> deck() {
        ArrayList<Card> deck = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < Suits.values().length; i++){
            for (int j = 0; j < Ranks.values().length; j++){
                deck.add(new Card(Suits.values()[i], Ranks.values()[j]));
                k++;
            }
        }
        return deck;
    }

    public static void shuffle(ArrayList<Card> deck) {
        Collections.shuffle(deck);
    }
}

