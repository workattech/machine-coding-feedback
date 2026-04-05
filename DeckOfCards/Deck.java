package DeckOfCards;

import java.util.*;

public class Deck {
    private Stack<Card> cards;

    public Deck(int numberOfDecks) {
        cards = new Stack<>();
        createDeck(numberOfDecks);
    }

    private void createDeck(int numberOfDecks) {
        for (int i = 0; i < numberOfDecks; i++) {
            for (Suit suit : Suit.values()) {
                for (Rank rank : Rank.values()) {
                    cards.push(new Card(suit, rank));
                }
            }
        }
    }

    public void shuffleDeck(int numberOfShuffles) {
        Random random = new Random();
        Card[] tempArray = cards.toArray(new Card[0]);

        for (int m = 0; m < numberOfShuffles; m++) { // Shuffle M times
            for (int i = tempArray.length - 1; i > 0; i--) {
                int j = random.nextInt(i + 1);
                Card temp = tempArray[i];
                tempArray[i] = tempArray[j];
                tempArray[j] = temp;
            }
        }

        // Rebuild the stack
        cards.clear();
        for (Card card : tempArray) {
            cards.push(card);
        }
    }

    // Distribute cards to players
    public Map<Integer, List<Card>> dealCards(int numberOfPlayers, int cardsPerPlayer) {
        int totalAvailable = cards.size();
        int required = numberOfPlayers * cardsPerPlayer;

        // Edge case check
        if (required > totalAvailable) {
            throw new IllegalArgumentException("Not enough cards! Required: " + required + ", Available: " + totalAvailable);
        }

        Map<Integer, List<Card>> playerHands = new HashMap<>();
        for (int player = 1; player <= numberOfPlayers; player++) {
            List<Card> hand = new ArrayList<>();
            for (int c = 0; c < cardsPerPlayer; c++) {
                hand.add(cards.pop());
            }
            playerHands.put(player, hand);
        }
        return playerHands;
    }


    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("No cards left in the deck!");
        }
        return cards.pop(); // Draw from top
    }

    public int remainingCards() {
        return cards.size();
    }
}
