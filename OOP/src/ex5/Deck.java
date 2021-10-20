package ex5;

import java.util.ArrayList;

public class Deck {
	private ArrayList<Card> cards = new ArrayList<Card>();
		public Deck() {
			for(int i=0; i <=3; i++) {
				for(int j=0; j<=13; j++) {
					cards.add(new Card(i,j));
				}
			}	
		}
public void show() {
		for(Card cards_2 : cards) {
			System.out.println(cards_2);
		}
	}
public static void main(String[] args) {
		Deck aDeck = new Deck();
		aDeck.show();
	}
}


