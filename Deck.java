package deckOfCards;

import java.util.*;

class Deck {
	// ---------- fields ----------
	private boolean allowDuplicates = false;
	private List<Card> cards;

	// -------- constructors ------
	// empty deck
	public Deck() {
		cards = new ArrayList<Card>();
	}

	// copy of another deck
	public Deck(Deck deck) {
		this.allowDuplicates = deck.allowDuplicates;
		this.cards = deck.cards;
	}

	// ---------- setters ---------
	// setter for allowDuplicates
	public void setAllowDuplicates(boolean allow) {
		allowDuplicates = allow;

		// update deck if allow duplicates turned off
		if (!allowDuplicates) {
			removeDuplicates();
		}
	}

	// --------- getters ----------
	// check if deck is empty
	public boolean isEmpty() {
		return cards.isEmpty();
	}

	// check if the deck contains a card
	public boolean contains(Card card) {
		for (Card c : cards) {
			if (c.equals(card)) {
				return true;
			}
		}
		return false;
	}

	// check if the deck equals another
	public boolean equals(Deck other) {
		if (cards.size() != other.cards.size())
			return false;
		for (int k = 0; k < cards.size(); k++) {
			if (!cards.get(k).equals(other.cards.get(k))) {
				return false;
			}
		}
		return true;
	}

	// returns a new deck with cards <start> inclusive, to <start + len> exclusive
	public Deck subDeck(int start, int len) {
		start = Math.clamp(start, 0, cards.size());
		len = Math.clamp(len, 0, cards.size() - start);
		List<Card> croppedCards = new ArrayList<Card>();
		for (int k = start; k < start + len; k++) {
			croppedCards.add(cards.get(k));
		}
		Deck result = new Deck();
		result.cards = croppedCards;
		return result;
	}

	// ---------- methods ---------
	// shuffle deck
	public void shuffle() {
		List<Card> shuffledCards = new ArrayList<Card>();
		int cardsTotal = cards.size();
		for (int k = 0; k < cardsTotal; k++) {
			shuffledCards.add(drawRandom(true));
		}
		cards = shuffledCards;
	}

	// adds a card to the deck, returns true if successful
	public boolean addCard(Card card) {
		if (contains(card) && !allowDuplicates) {
			return false;
		}
		cards.add(card);
		return true;
	}

	// returns a random card from the deck
	public Card drawRandom(boolean removeCard) {
		int randomCard = (int) (Math.random() * cards.size());
		Card drawn = cards.get(randomCard);
		if (removeCard)
			cards.remove(drawn);
		return drawn;
	}

	// returns the top of the deck
	public Card drawTop(boolean removeCard) {
		Card drawn = cards.getFirst();
		if (removeCard)
			cards.remove(drawn);
		return drawn;
	}

	// remove all cards that match specified card from the deck, returns true if
	// successful
	public void removeCard(Card remove) {
		for (int k = 0; k < cards.size(); k++) {
			if (cards.get(k).equals(remove)) {
				cards.remove(k--);
			}
		}
	}

	// remove duplicates by copying deck into a deck that doesn't allow dupes
	public void removeDuplicates() {
		Deck noDupes = new Deck();
		noDupes.allowDuplicates = false;
		for (Card c : cards) {
			noDupes.addCard(c);
		}
		this.cards = noDupes.cards;
	}

	// ---------- this thing ---------
	// override for print statement
	public String toString() {
		String result = "";
		for (Card c : cards) {
			result += c.toString() + '\n';
		}
		return result;
	}
}
