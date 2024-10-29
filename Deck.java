import java.util.Random;

public class Deck {
    protected Card[] Deck;

    Deck() {
        this.Deck = new Card[52];
    }

    public void Fill() {
        int count = 0;
        for (int suit = 0; suit < 4; suit++){
            for (int rank = 1; rank < 14; rank++){
                switch(suit){
                    case 0:
                        Deck[count] = new Card("Spades", rank);
                        break;
                    case 1:
                        Deck[count] = new Card("Hearts", rank);
                        break;
                    case 2:
                        Deck[count] = new Card("Diamonds", rank);
                        break;
                    case 3:
                        Deck[count] = new Card("Clubs", rank);
                        break;
                }
                count++;
            }
        }
    }

    public void Shuffle() {
        Random rand = new Random();
        Card[] newDeck = new Card[52];
        int count = 0;

        while (count < 52) {
            int curIndex = rand.nextInt(52);
            if (newDeck[curIndex] == null) {
                newDeck[curIndex] = Deck[count];
                count++;
            }
        }

        this.Deck = newDeck;
    }

    public String ToString() {
        String out = "";

        for (Card card : Deck) {
            out += card.ToString() + "\n";
        }

        return out;
    }
}
