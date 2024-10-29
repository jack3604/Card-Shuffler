public class Main {
    public static void main(String[] args) {
        Card card1 = new Card("sPADES", 1);

        // make deck and fill it
        Deck deck = new Deck();
        deck.Fill();

        // print cards unshuffled
        System.out.println(deck.ToString());

        // shuffle deck
        deck.Shuffle();

        // print shuffled deck
        System.out.println(deck.ToString());

        // compare the first 2 cards in the shuffled deck
        System.out.println(deck.Deck[0].CompareTo(deck.Deck[1]));
    }
}
