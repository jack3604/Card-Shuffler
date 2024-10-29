import java.util.Map;

public class Card {
    private final String Suit;
    private final int Rank;

    Card() {
        this.Suit = "none";
        this.Rank = 0;
    }

    Card(String suit, int rank) {
        this.Suit = suit.substring(0,1).toUpperCase() + suit.substring(1).toLowerCase();
        this.Rank = rank;
    }

    public String GetSuit() { return Suit; }

    public int GetRank() { return Rank; }

    // returns characters
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

    // overload for word form
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
