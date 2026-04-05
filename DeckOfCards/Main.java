package DeckOfCards;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of decks (N): ");
        int N = sc.nextInt();

        System.out.print("Enter number of shuffles (M): ");
        int M = sc.nextInt();

        Deck deck = new Deck(N);
        deck.shuffleDeck(M);

        Map<Integer, List<Card>> dealCards = deck.dealCards(11, 11);

        for (Map.Entry<Integer, List<Card>> entry : dealCards.entrySet()) {
            Integer playerId = entry.getKey();
            List<Card> cards = entry.getValue();

            System.out.println("Player " + playerId + ": " + cards);
        }


        System.out.println("Remaining cards: " + deck.remainingCards());
    }
}
