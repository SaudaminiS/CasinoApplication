package pokerClasses;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	private ArrayList<Card> listOfCards;

	public Deck()

	{
		listOfCards = new ArrayList<Card>();
		int index1, index2;
		Random generator = new Random();
		Card temp;
		for (int a = 1; a <= 4; a++) {
			for (int b = 1; b <= 13; b++) {
				listOfCards.add(new Card(a, b));
			}
		}

		for (int i = 0; i < 100; i++) {
			index1 = generator.nextInt(listOfCards.size() - 1);
			index2 = generator.nextInt(listOfCards.size() - 1);
			temp = listOfCards.get(index2);
			listOfCards.set(index2, listOfCards.get(index1));
			listOfCards.set(index1, temp);
		}
	}

	public Card deckDraw() {
		return listOfCards.remove(0);
	}

	public int getTotCards() {
		return listOfCards.size();
	}

}
