import java.util.Arrays;
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

    public void Shuffle(int timesToShuffle) {
        for (int i = 0; i < timesToShuffle; i++) {
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
    }

    // classic bridge shuffle interpretation. split in half alternate sides.
    public void RiffleShuffle() {
        Card[] half1, half2 = new Card[26];
        Card[] newDeck = new Card[52];

        half1 = Arrays.copyOfRange(Deck, 0, 26);
        half2 = Arrays.copyOfRange(Deck, 26, 52);

        int count = 0;
        while (count < 52) {
            newDeck[count] = half1[count/2];
            newDeck[count+1] = half2[count/2];
            count += 2;
        }

        this.Deck = newDeck;
    }

    // classic bridge shuffle interpretation. split in half alternate sides. additional shuffles.
    public void RiffleShuffle(int timesToShuffle) {
        for (int i = 0; i < timesToShuffle; i++) {
            Card[] half1, half2 = new Card[26];
            Card[] newDeck = new Card[52];

            half1 = Arrays.copyOfRange(Deck, 0, 26);
            half2 = Arrays.copyOfRange(Deck, 26, 52);

            int count = 0;
            while (count < 52) {
                newDeck[count] = half1[count/2];
                newDeck[count+1] = half2[count/2];
                count += 2;
            }

            this.Deck = newDeck;
            }
    }

    public void FisherYatesShuffle() {
        Random rand = new Random();
        int i = Deck.length;

        while (i > 0) {
            int swap = rand.nextInt(i--);
            Card c = Deck[i];
            Deck[i] = Deck[swap];
            Deck[swap] = c;
        }
    }

    public void FisherYatesShuffle(int timesToShuffle) {
        for (int j = 0; j < timesToShuffle; j++) {
            Random rand = new Random();
            int i = Deck.length;

            while (i > 0) {
                int swap = rand.nextInt(i--);
                Card c = Deck[i];
                Deck[i] = Deck[swap];
                Deck[swap] = c;
            }
        }
    }

    public String ToString() {
        String out = "";

        for (Card card : Deck) {
            out += card.ToString() + "\n";
        }

        return out;
    }

    public String ToString(boolean longForm) {
        if (longForm) {
            String out = "";

            for (Card card : Deck) {
                out += card.ToString(true) + "\n";
            }

            return out;
        } else { return this.ToString(); }
    }
}
