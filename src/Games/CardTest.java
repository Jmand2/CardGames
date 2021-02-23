package Games;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void getSuit() {
        Card c1 = new Card(Suits.Diamonds, Ranks.Five);
        assertEquals(Suits.Diamonds,c1.getSuit());
    }

    @Test
    public void setSuit() {
        Card c1 = new Card(Suits.Diamonds, Ranks.Five);
        c1.setSuit(Suits.Clubs);
        assertEquals(Suits.Clubs , c1.getSuit());
    }

    @Test
    public void getRank() {
        Card c1 = new Card(Suits.Diamonds, Ranks.Five);
        assertEquals(Ranks.Five,c1.getRank());
    }

    @Test
    public void setRank() {
        Card c1 = new Card(Suits.Diamonds, Ranks.Five);
        c1.setRank(Ranks.Ace);
        assertEquals(Ranks.Ace,c1.getRank());
    }

    @Test
    public void tostring() {
        Card c1 = new Card(Suits.Diamonds, Ranks.Five);
        assertEquals("Five of Diamonds",c1.toString());
    }

    @Test
    public void rankToString() {
        Card c1 = new Card(Suits.Diamonds, Ranks.Five);
        assertEquals("Five",c1.rankToString());
    }

    @Test
    public void equalsT() {
        Card c1 = new Card(Suits.Diamonds, Ranks.Five);
        Card c2 = new Card(Suits.Diamonds, Ranks.Five);
        assertTrue(c2.equals(c1));
    }

    @Test
    public void equalsF() {
        Card c1 = new Card(Suits.Diamonds, Ranks.Five);
        Card c2 = new Card(Suits.Diamonds, Ranks.Three);
        assertFalse(c2.equals(c1));
    }

    @Test
    public void hash() {
        Card c1 = new Card(Suits.Diamonds, Ranks.Five);
        Card c2 = new Card(Suits.Diamonds, Ranks.Five);
        assertTrue(c1.equals(c2) && c2.equals(c1));
        assertTrue(c1.hashCode() == c2.hashCode());
    }

    @Test
    public void deck() {
        Card c1 = new Card(Suits.Clubs, Ranks.Two);
        assertEquals(52, Card.deck().size());
        assertEquals(c1, Card.deck().get(0));
    }

    @Test
    public void shuffle() {
        //will fail 1/52 times
        Card c1 = new Card(Suits.Clubs, Ranks.Two);
        ArrayList<Card> d;
        d = Card.deck();
        Card.shuffle(d);
        assertNotEquals(c1,d.get(0));
    }

    @Test
    public void compareTo() {
        Card c1 = new Card(Suits.Diamonds, Ranks.Five);
        Card c2 = new Card(Suits.Diamonds, Ranks.Three);
        assertEquals(-2,c2.compareTo(c1));
    }
}