
public class Deck {
	private static final int MAX_VALUE_WITH_DIGITS = 10;
	private static final int MIN_VALUE = 2;
	private static final int MAX_VALUE = 14;
	static final int NUMBER_OF_CARDS = 52;
	
	private Card[] cards;
	
	public Deck() {
		this.cards = new Card[NUMBER_OF_CARDS];
		generateCards();
		shuffleCards();
	}
	
	public Deck(Card[] cards) {
		this.cards = new Card[NUMBER_OF_CARDS];
		if (cards != null) {
			for (int index=0; index < cards.length; index++) {
				this.cards[index] = cards[index];
			}
		}
	}
	
	public Card getCard(int index){
		if(index >= 0 && index <= 26){
			return cards[index];
		}
		else{
			return null;
		}
	}
	
	public Deck getCards(int start, int end) {
		if (start >= 0 && start < end && end <= NUMBER_OF_CARDS) {
			Card[] cards = new Card[end-start];
			for (int index=start; index < end; index++) {
				cards[index-start] = this.cards[index];
			}
			
			return new Deck(cards);
		}
		return null;
	}

	private void shuffleCards() {
		for (int count=1; count < NUMBER_OF_CARDS; count++) {
			int cardIndex = (int)(Math.random() * NUMBER_OF_CARDS);
			
			Card temp = this.cards[count-1];
			this.cards[count-1] = this.cards[cardIndex];
			this.cards[cardIndex] = temp;
		}
	}

	private void generateCards() {
		final String[] values = {"J","Q","K","A"};
		final String[] suites = {"Spades","Hearts","Diamonds","Clubs"};
		int index = 0;
		
		for (int valueIndex=MIN_VALUE; valueIndex <= MAX_VALUE; valueIndex++ ) {
			for (int suitIndex=suites.length-1; suitIndex>=0; suitIndex--) {
				String suit = suites[suitIndex];
				String value;
				
				if (valueIndex <= MAX_VALUE_WITH_DIGITS) {
					value = ""+valueIndex;
				} else {
					value = values[valueIndex-MAX_VALUE_WITH_DIGITS-1];
				}
				
				Card newCard = new Card(suit, value);
				cards[index] = newCard;
				index++;
			}
		}
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("");
		
		for (int index = 0; index < this.cards.length; index++) {
			if (this.cards[index] == null) break;
			
			builder.append(this.cards[index].toString() + System.lineSeparator());
		}
		
		return builder.toString();
	}
	
	
}