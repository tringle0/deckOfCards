package deckOfCards;

public class FilledDeck extends Deck {
	//override constructor for filled deck with all cards
	public FilledDeck() {
		super();
		super.setAllowDuplicates(false);
		
		//add jokers
		super.addCard(new Card(Suit.joker, 0));
		super.addCard(new Card(Suit.joker, 1));
		
		//add all cards
		for(int rank = 1; rank <= 13; rank++) {
			for(Suit s: Suit.values()) {
				if(s!=Suit.joker) //ignore jokers
				super.addCard(new Card(s, rank));
			}
		}
	}
}
