/**
 * Card class for module 6.
 * This Card class is used by the Deck class for each card to be an object.
 */

import java.util.Map;
public class Card {
    private final String Suit;
    private final int Rank;

    /**
     * Default constructor for a Card object.
     * assigns String value of "none" to the Suit and 0 to the Rank.
     */
    Card() {
        this.Suit = "none";
        this.Rank = 0;
    }

    /**
     * Parameterized constructor for a Card object.
     *
     * @param suit  The suit of the card as a String. The input is formated to be a capital letter followed by lowercase.
     * @param rank  The rank of the card as an integer.
     */
    Card(String suit, int rank) {
        this.Suit = suit.substring(0,1).toUpperCase() + suit.substring(1).toLowerCase();
        this.Rank = rank;
    }

    /**
     * Gets the Suit property of the card.
     * @return The Suit of the Card as a string.
     */
    public String GetSuit() { return Suit; }

    /**
     * Gets the Rank property of the card.
     * @return The Rank of the card as an integer.
     */
    public int GetRank() { return Rank; }

    /**
     * Gets a short-form summary of the card.
     * @return A summary of the card as a String.
     */
    public String ToString() {
        Map<Integer, String> faceMap = Map.of(1, "J", 2, "Q", 3, "K");
        String suit = Suit.substring(0,1).toUpperCase();

        if ((double)Rank / 10 > 1) {
            return faceMap.get(Rank % 10) + " of " + suit;
        } else if (Rank == 1) {
            return "A of " + suit;
        }
        return Rank + " of " + suit;
    }

    /**
     * Gets a long-form summary of the card.
     * @param longForm boolean if true return long form
     * @return A long-form summary of the card as a String.
     */
    public String ToString(boolean longForm) {
        if (longForm) {
            Map<Integer, String> faceMap = Map.of(1, "Jack", 2, "Queen", 3, "King");
            String suit = Suit;

            if ((double) Rank / 10 > 1) {
                return faceMap.get(Rank % 10) + " of " + suit;
            } else if (Rank == 1) {
                return "Ace of " + suit;
            }
            return Rank + " of " + suit;
        } else { return this.ToString(); }
    }

    /**
     * Compares the card calling the method to the card passed.
     * @param other The other Card object to compare this card to.
     * @return A short String describing how this card compares to the other card.
     */
    public String CompareTo(Card other) {
        if (this.Rank > other.Rank) {
            return this.ToString() + " is bigger than " + other.ToString();
        } else if (other.Rank > this.Rank) {
            return this.ToString() + " is smaller than " + other.ToString();
        } else {
            return this.ToString() + " is equal to " + other.ToString();
        }
    }
}
