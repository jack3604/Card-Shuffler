/**
 * Deck class for module 6.
 * This Deck class is used to demo shuffling cards using arrays and loops.
 */

import java.util.Arrays;
import java.util.Random;
public class Deck {
    protected Card[] Deck;

    /**
     * Default constructor for Deck object. Creates an empty Card array of length 52.
     */
    Deck() {
        this.Deck = new Card[52];
    }

    /**
     * Fills the Deck object with a standard set of cards without jokers.
     */
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

    /**
     * Uses a Random() object to randomly shuffle the deck.
     */
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

    /**
     * Uses a Random() object to randomly shuffle the deck.
     * @param timesToShuffle The amount of times to repeat the shuffle.
     */
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

    /**
     * Uses the Riffle shuffle method of splitting the deck in half and alternating sides.
     */
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

    /**
     * Uses the Riffle shuffle method of splitting the deck in half and alternating sides.
     * @param timesToShuffle The amount of times to repeat the shuffle.
     */
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

    /**
     * Uses the Fisher-Yates method of shuffling the cards. This is used to give a psuedo-random shuffle
     * while trying to be the most computationally efficient. Starting from one side of the deck, you
     * take the first card and swap it with a randomly selected card and leave that card as shuffled.
     * Then move to the next and do the same, while only selecting from the previously un-shuffled cards.
     */
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

    /**
     * Uses the Fisher-Yates method of shuffling the cards. This is used to give a psuedo-random shuffle
     * while trying to be the most computationally efficient. Starting from one side of the deck, you
     * take the first card and swap it with a randomly selected card and leave that card as shuffled.
     * Then move to the next and do the same, while only selecting from the previously un-shuffled cards.
     * @param timesToShuffle The amount of times to repeat the shuffle.
     */
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

    /**
     * Gets a list of the cards in the deck in order from first to last and separates them on new lines.
     * @return A String of all the cards in the deck in short-form.
     */
    public String ToString() {
        String out = "";

        for (Card card : Deck) {
            out += card.ToString() + "\n";
        }

        return out;
    }

    /**
     *
     * Gets a list of the cards in the deck in order from first to last and separates them on new lines.
     * @param longForm boolean if true returns long-form.
     * @return A String of all the cards in the deck in long-form.
     */
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
