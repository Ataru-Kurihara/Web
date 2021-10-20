package ex5;

public class Card {
	private int mark;
	private int number;

	public static final int SPADE = 0;
	public static final int HEART = 1;
	public static final int CLUB = 2;
	public static final int DIAMOND = 3;

	public static final int BLACK = 0;
	public static final int RED = 1;

	public Card(int m, int num) {
		mark = m;
		number = num;
	}

	public int getMark() {
		return mark;

	}

	public int getNumber() {
		return number;
	}

	public int color() {
		int ans;
		switch (mark) {
		case SPADE:
			ans = BLACK;
			break;
		case HEART:
			ans = RED;
			break;
		case CLUB:
			ans = BLACK;
			break;
		case DIAMOND:
			ans = RED;
			break;
		default:
			ans = -1;
		}
		return ans;
	}

	public String toString() {
		String markString = null, numberString = null;
		switch (mark) {
		case SPADE:
			markString = "S";
			break;
		case HEART:
			markString = "H";
			break;
		case CLUB:
			markString = "C";
			break;
		case DIAMOND:
			markString = "D";
			break;
		}

		switch (number) {
		case 1:
			numberString = "A";
			break;
		case 11:
			numberString = "J";
			break;
		case 12:
			numberString = "Q";
			break;
		case 13:
			numberString = "K";
			break;
		case 2:
	   		numberString = "2";
	   		break;
	   	case 3:
	   		numberString = "3";
	   		break;
	   	case 4:
	   		numberString = "4";
	   		break;
	   	case 5:
	   		numberString = "5";
	   		break;
	   	case 6:
	   		numberString = "6";
	   		break;
	   	case 7:
	   		numberString = "7";
	   		break;
	   	case 8:
	   		numberString = "8";
	   		break;
	   	case 9:
	   		numberString = "9";
	   		break;
	   	case 10:
	   		numberString = "10";
	   		break;
		}
		return "a Card("+markString + ","+numberString +")";
	}
	
	public boolean isEqualMark(Card aCard) {
		boolean equal;
		equal = (getMark() == aCard.getMark());
		return equal;
	}
	
	public boolean isLargerThan(Card aCard) {
		boolean larger = false;
		if(getNumber() > aCard.getNumber() || getNumber()==1 && aCard.getNumber()==13) {
			larger = true;
		}else {
			larger = false;
		}if(getNumber()==13 && aCard.getNumber()==1) {
			larger = false;
		}
		
		return larger;
	}
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Card card1, card2, card3;
		card1 = new Card(Card.SPADE, 1);
		card2 = new Card(Card.DIAMOND, 2);
		card3 = new Card(Card.SPADE, 13);

		System.out.println(card1);
		System.out.println(card2);
		System.out.println(card3);
		
		System.out.println(card1.isEqualMark(card2));
		System.out.println(card1.isEqualMark(card3));
		System.out.println(card2.isEqualMark(card3));
		System.out.println(card3.isEqualMark(card1));
		System.out.println(card3.isEqualMark(card2));
		
		System.out.println(card1.isLargerThan(card2));
		System.out.println(card1.isLargerThan(card3));
		System.out.println(card2.isLargerThan(card1));
		System.out.println(card2.isLargerThan(card3));
		System.out.println(card3.isLargerThan(card1));
		System.out.println(card3.isLargerThan(card2));
	}

}
