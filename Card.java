package deckOfCards;

/**
 * @author tringle
 * @version four
 * @since 10/1/2025
 */

public class Card{
	//---------- fields ----------
	//variables: suit and rank
	//jokers are denoted joker-0 for red joker and joker-1 for black joker
	final private Suit suit;
	final private int rank;
	
	//---------- constructors ---------
	public Card(Suit suit, int rank) {
		this.suit = suit;
		if(suit == Suit.joker)
			this.rank = (int)Math.clamp(rank, 0, 1);
		else
			this.rank = (int)Math.clamp(rank, 1, 13);
	}
	
	// ---------- getters ----------
	public Suit getSuit() { return suit; }
	public int getRank() { return rank; }
	
	//check if two cards are equal
	@Override
	public boolean equals(Object other) {
		if(!(other instanceof Card)) return false;
		Card otherCard = (Card) other;
		return (this.suit == otherCard.suit) && (this.rank == otherCard.rank);
	}
	
	//compare the values of both cards
	public int compareTo(Card other) {
		if(suit == Suit.joker && other.suit != Suit.joker) return -1;
		return ((this.rank - other.rank)*4 + (suit.ordinal() - other.suit.ordinal()));
	}
	
	// ---------- this thing -----------
	
	//override for print statement
	public String toString() {
		CardFormatter cf = new CardFormatter();
		return cf.formatCard(suit, rank);
	}
	
}

