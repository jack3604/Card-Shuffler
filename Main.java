public class Main {
    public static void main(String[] args) {
        // make card and print its values
        Card card1 = new Card("sPADES", 1);
        System.out.println(card1.ToString());
        System.out.println(card1.ToString(true));

        // make deck and fill it
        Deck deck = new Deck();
        deck.Fill();

        // print cards unshuffled
        System.out.println(deck.ToString());

        // riffle shuffle
        deck.Fill();
        deck.RiffleShuffle();

        // print riffle shuffled cards
        System.out.println(deck.ToString());

        // random shuffle deck
        deck.Fill();
        deck.Shuffle();

        // print random shuffled deck in long form
        System.out.println(deck.ToString(true));

        // compare the first 2 cards in the shuffled deck
        System.out.println(deck.Deck[0].CompareTo(deck.Deck[1]) + "\n");

        // shuffle the deck using the Fisher-Yates method
        deck.Fill();
        deck.FisherYatesShuffle();

        // print the Fisher-Yates shuffled deck
        System.out.println(deck.ToString());

        long sum = 0;
        for (int i = 0; i < 100; i++){
            sum += TimeRandomShuffle();
        }
        System.out.println("Random Shuffle average time taken: " + sum/100 + "ns");

        sum = 0;
        for (int i = 0; i < 100; i++){
            sum += TimeRiffleShuffle();
        }
        System.out.println("Riffle Shuffle average time taken: " + sum/100 + "ns");

        sum = 0;
        for (int i = 0; i < 100; i++){
            sum += TimeFisherYatesShuffle();
        }
        System.out.println("Fisher-Yates Shuffle average time taken: " + sum/100 + "ns");
    }

    public static long TimeRandomShuffle() {
        Deck deck = new Deck();
        deck.Fill();

        long startTime = System.nanoTime();
        deck.Shuffle();
        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    public static long TimeRiffleShuffle() {
        Deck deck = new Deck();
        deck.Fill();

        long startTime = System.nanoTime();
        deck.RiffleShuffle();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static long TimeFisherYatesShuffle() {
        Deck deck = new Deck();
        deck.Fill();

        long startTime = System.nanoTime();
        deck.FisherYatesShuffle();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
