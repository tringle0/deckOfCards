package deckOfCards;

/**
 * @author tringle
 * @version four
 * @since 10/1/2025
 */

//helper function to format cards for printing
public class CardFormatter {
	private String suitToString(Suit suit) {
		switch(suit) {
		case clubs:
			return "clubs";
		case hearts:
			return "hearts";
		case spades:
			return "spades";
		case diamonds:
			return "diamonds";
		case joker:
		}
		return "";
	}
	
	private String rankToString(int rank) {
		switch(rank) {
		case 1:
			return "ace";
		case 11:
			return "jack";
		case 12:
			return "queen";
		case 13:
			return "king";
		default:
			return String.valueOf(rank);
		}
	}
	
	//formats the card in "<suit> of <rank>"
	public String formatCard(Suit suit, int rank) {
		//jokers are denoted joker-0 for red joker and joker-1 for black joker
		if(suit == Suit.joker) {
			if(rank == 0) {
				return "joker red";
			}else if (rank == 1){
				return "joker black";
			}
		}
		return rankToString(rank) + " of " + suitToString(suit);
	}
}
