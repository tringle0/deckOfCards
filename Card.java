package deckOfCards;

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
	public boolean equals(Card other) {
		return (this.suit == other.suit) && (this.rank == other.rank);
	}
	
	public int compareTo(Card other) {
		return this.rank - other.rank;
	}
	
	// ---------- this thing -----------
	
	//override for print statement
	public String toString() {
		CardFormatter cf = new CardFormatter();
		return cf.formatCard(suit, rank);
	}
	
}

