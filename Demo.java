
public class Demo {
	
	public static void main(String[] args) {
		Deck allCards = new Deck();
		Deck player1Deck = allCards.getCards(0, Deck.NUMBER_OF_CARDS / 2);
		Deck player2Deck = allCards.getCards(Deck.NUMBER_OF_CARDS / 2, Deck.NUMBER_OF_CARDS);
		
		Player player1 = new Player(player1Deck);
		Player player2 = new Player(player2Deck);
		
//		System.out.println("Player 1");
//		System.out.println(player1.getDeck().getCard(0));
//		
//		System.out.println("Player 2");
//		System.out.println(player2.getDeck());
	}
}