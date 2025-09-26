package deckOfCards;

public class Main {
	public static void main(String args[]) {
		
		// test creating cards
		Card cardOne = new Card(Suit.diamonds, 1);
		System.out.println(cardOne);
		
		Deck deckOne = new Deck();
		// test adding cards to deck
		deckOne.addCard(new Card(Suit.clubs, 12));
		deckOne.addCard(new Card(Suit.spades, 4));
		deckOne.addCard(new Card(Suit.hearts, 1));
		deckOne.addCard(new Card(Suit.hearts, 9));
		deckOne.addCard(new Card(Suit.diamonds, 13));
		deckOne.addCard(new Card(Suit.joker, 0));

		// test deck printing
		System.out.println("deck one :\n" + deckOne);

		// test random draws (remove and no remove)
		System.out.println("random draw (removed) : " + deckOne.drawRandom(true));
		System.out.println("random draw : " + deckOne.drawRandom(false));

		// test deck shuffling
		deckOne.shuffle();
		System.out.println("\nshuffled deck one : \n");
		System.out.println(deckOne);

		// get a subdeck of first three cards
		System.out.println("\nsubdeck of first three cards in deck one :\n");
		System.out.println(deckOne.subDeck(0, 3));

		// make a filled deck
		System.out.println("\nfilled deck : \n");
		Deck deckTwo = new FilledDeck();
		System.out.print(deckTwo);

		// reset decks one and two
		System.out.println("\nresetting deck one and two : \n");
		deckOne = new Deck();
		deckOne.addCard(new Card(Suit.clubs, 1));
		deckOne.addCard(new Card(Suit.spades, 2));
		System.out.println(deckOne);
		
		// deck two is the same thing but added then removed 3 of hearts
		deckTwo = new Deck();
		deckTwo.addCard(new Card(Suit.clubs, 1));
		deckTwo.addCard(new Card(Suit.spades, 2));
		deckTwo.addCard(new Card(Suit.hearts, 3));
		deckTwo.removeCard(new Card(Suit.hearts, 3));
		System.out.println(deckTwo);

		// check if two decks are equal
		if (deckOne.equals(deckTwo)) {
			System.out.println("deck one is equal to deck two");
		}

		// test deck that allows duplicates
		deckOne = new Deck();
		deckOne.setAllowDuplicates(true);

		deckOne.addCard(new Card(Suit.spades, 2));
		deckOne.addCard(new Card(Suit.diamonds, 13));
		deckOne.addCard(new Card(Suit.diamonds, 13));
		deckOne.addCard(new Card(Suit.diamonds, 13));
		deckOne.addCard(new Card(Suit.diamonds, 13));
		deckOne.addCard(new Card(Suit.hearts, 7));
		deckOne.addCard(new Card(Suit.hearts, 7));
		deckOne.addCard(new Card(Suit.hearts, 7));

		System.out.println("\nprinting deck with duplicate cards\n");
		System.out.println(deckOne);

		// remove duplicates from deck
		System.out.println("\nprinting deck with removed duplicates\n");
		deckOne.removeDuplicates();
		System.out.println(deckOne);

		// test implicit removing of duplicates by setting allow duplicates to false
		deckOne = new Deck();
		deckOne.setAllowDuplicates(true);

		deckOne.addCard(new Card(Suit.spades, 2));
		deckOne.addCard(new Card(Suit.diamonds, 13));
		deckOne.addCard(new Card(Suit.diamonds, 13));
		deckOne.addCard(new Card(Suit.hearts, 7));
		deckOne.addCard(new Card(Suit.diamonds, 13));

		System.out.println("\nprinting deck with duplicate cards\n");
		System.out.println(deckOne);

		// remove duplicates from deck by converting to non-duplicate supported deck
		System.out.println("\nprinting deck with disallowed duplicates\n");
		deckOne.setAllowDuplicates(false);
		System.out.println(deckOne);

	}
}
