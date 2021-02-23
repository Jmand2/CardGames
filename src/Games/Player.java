package Games;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Player {
    public String name;
    public ArrayList<Card> hand = new ArrayList<>();
    public ArrayList<Card> winnings = new ArrayList<>();
    public Card inPlay;

    public Player(String name, ArrayList<Card> hand, ArrayList<Card> winnings, Card inPlay){
        this.name = name;
        this.hand = hand;
        this.winnings = winnings;
        this.inPlay = inPlay;
    }


    public Player(){}

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void resetHand() {
        this.hand.addAll(winnings);
        shuffle();
        winnings.clear();
    }

    public void addToHand(Card card){
        hand.add(card);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public ArrayList<Card> getWinnings() {
        return winnings;
    }

    public void addToWinnings(ArrayList<Card> cards){
        winnings.addAll(cards);
    }

    public void removeFromHand(int index){
        hand.remove(index);
    }

    public void shuffle() {
        Collections.shuffle(this.hand);
    }

    public int hashCode(){
        return Objects.hash(name, hand, winnings, inPlay);
    }

    public int compareTo(Player that){
        return this.inPlay.compareTo(that.inPlay);
    }
    public int totalCards(){
        return hand.size() + winnings.size();
    }

    public String toString(){
            return name + ", remaining cards: " + totalCards() + ", card in play: "  + inPlay;
        }
    }
