package Games;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    ArrayList<Card> h1 = new ArrayList<>();
    ArrayList<Card> w1 = new ArrayList<>();
    Player p1 = new Player("Jeff", h1, w1, null);

    ArrayList<Card> h2 = new ArrayList<>();
    ArrayList<Card> w2 = new ArrayList<>();
    Player p2 = new Player("Steve", h2, w2, null);

    ArrayList<Card> h3 = new ArrayList<>();
    ArrayList<Card> w3 = new ArrayList<>();
    Player p3 = new Player("Phil", h3, w3, null);


    @Test
    void setterGetterName() {
        p1.setName("Kevin");
        assertEquals("Kevin", p1.getName());
    }

    @Test
    void resetHand() {
        w1.add(new Card(Suits.Clubs, Ranks.Ace));
        h1.add(new Card(Suits.Spades, Ranks.Ace));
        p1.resetHand();
        assertEquals(0,w1.size());
        assertEquals(2,h1.size());
    }

    @Test
    void addToHand() {
    }

    @Test
    void getHand() {
    }

    @Test
    void getWinnings() {
    }

    @Test
    void addToWinnings() {
    }

    @Test
    void removeFromHand() {
    }

    @Test
    void shuffle() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void compareTo() {
    }

    @Test
    void totalCards() {
    }

    @Test
    void testToString() {
    }
}