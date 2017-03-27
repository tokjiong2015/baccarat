package du.tech.baccarat.domain.card;

import java.io.Serializable;

import javax.persistence.Column;

public class CardKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
    public CardKey(String suit, String rank, int deck) {
		super();
		this.suit = suit;
		this.rank = rank;
		this.deck = deck;
	}

	//Clubs Diamonds Hearts Spades
	@Column(name = "SUIT", nullable = false)
    private String suit;

	//ACE 1 2 3 4 5 6 7 8 9 20 JACK QUEEN KING
    @Column(name = "RANK", nullable = false)
    private String rank;
    
    @Column(name = "DECK", nullable = false)
    private int deck;


	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public int getDeck() {
		return deck;
	}

	public void setDeck(int deck) {
		this.deck = deck;
	}

}
