package Games;

import java.util.*;

public class Table {
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Card> playedCards = new ArrayList<>();
    private Player highCardHolder;


    public Table(ArrayList<Player> players, ArrayList<Card> playedCards, Player highCardHolder) {
        this.players = players;
        this.playedCards = playedCards;
        this.highCardHolder = highCardHolder;
    }

    public Table() {
    }

    public int hashCode() {
        return Objects.hash(players, playedCards, highCardHolder);
    }

    public void setPlayers() {
        Scanner sc = new Scanner(System.in);

        System.out.println("please input a number of players between 2 and 10 inclusive");
        int numPlayers = sc.nextInt();
        if (numPlayers <= 1 || numPlayers > 10)
            throw new IndexOutOfBoundsException("please choose a number of players between 2 and 10 inclusive");


        for (int i = 0; i < numPlayers; i++) {
            System.out.println("please input the name of player " + (i + 1));
            Player player = new Player();
            players.add(player);
            players.get(i).setName(sc.next());
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setHand() {
        ArrayList<Card> d = Card.deck();
        Card.shuffle(d);
        for (Player player : players) {
            for (int j = 0; j < 52 / players.size(); j++) {
                player.addToHand(d.get(0));
                d.remove(0);
            }
        }
        //the remainder of the cards are given to the winner of the first round
        playedCards.addAll(d);
    }


    public Player max(ArrayList<Player> list) {
        return Collections.max(list, Player::compareTo);
    }

    public void playHand() {
        //each individual round uses this function once
        for (Player player : players) {
            //every player puts a card in play
            player.inPlay = player.hand.get(0);
            playedCards.add(player.hand.get(0));
            player.hand.remove(0);
            System.out.println(player.toString());
        }
        //find the person with the highest card
        highCardHolder = max(players);
        ArrayList<Player> warriors = new ArrayList<>(players);
        while (warriors.size() != 1) {
            warriors.removeIf(warrior -> warrior.inPlay.getRank() != highCardHolder.inPlay.getRank());
            if (warriors.size() > 1) {
                System.out.println("\nwar of " + highCardHolder.inPlay.rankToString());
                int infiteLoop = 0;
                for (Player warrior : warriors) {
                    if (warrior.totalCards() == 0)
                        infiteLoop++;
                }
                if (infiteLoop == warriors.size())
                    throw new IllegalStateException("this game has hit an infinite loop and as the rules of war do not cover what to " +
                            "do in this situation please restart the game");
                war(warriors);
            }
        }
        System.out.println("\nthe winner is: " + highCardHolder.getName() + " with a high card of " + highCardHolder.inPlay.rankToString() + "\n");
        highCardHolder.addToWinnings(playedCards);
        transfer();
        playedCards.clear();
    }


    public void war(ArrayList<Player> ap) {
        for (Player p : ap) {
            //4 cards are required for a proper war
            if (p.hand.size() < 4)
                p.resetHand();
            if (p.hand.size() == 0)
                continue;
            for (int i = 0; i < 3; i++) {
                //the players last card should be put in play
                if (p.hand.size() == 1)
                    break;
                System.out.println(p.getName() + " wagers the card of: " + p.hand.get(0));
                playedCards.add(p.hand.get(0));
                p.hand.remove(0);
            }
            System.out.println(p.getName() + " plays the final card of: " + p.hand.get(0));
            p.inPlay = p.hand.get(0);
            playedCards.add(p.hand.get(0));
            p.hand.remove(0);
        }
        highCardHolder = max(ap);
    }


    public void transfer() {
        ArrayList<Player> toBeRemoved = new ArrayList<>();
        for (Player p : players) {
            if (p.hand.size() == 0 && p.winnings.size() == 0) {
                System.out.println(p.getName() + " Lost\n");
                toBeRemoved.add(p);
            } else if (p.hand.size() == 0) {
                p.resetHand();
            }
        }
        players.removeAll(toBeRemoved);
        toBeRemoved.clear();
    }


    public void playGame() {
        while (players.size() != 1)
            playHand();
        System.out.println(players.get(0).name.toUpperCase() + " WINS!!!!!");
    }
}