package du.tech.baccarat.domain.pack;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import du.tech.baccarat.domain.card.Card;
import du.tech.baccarat.domain.game.Game;



@Entity
@Table(name="Pack",schema="baccarat")
public class Pack {
	
	@Id @GeneratedValue(generator="du-uuid")
	@GenericGenerator(name="du-uuid", strategy = "uuid")
	@Column(name="UUID")
	private String uuid;
	
	@Column(name="PRE_REMOVE")
	private int preRemove;
	
	@Column(name="POST_REMOVE")
	private int postRemove;
	
	@Column(name="CURR_INDEX")
	private int currIndex;
	
	@Column(name="INIT_CARDS")
	private int initialCards;
	
	@Column(name="FINISHED_CARDS")
	private int finishedCards;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="pack",cascade=CascadeType.ALL)
	private Collection<Card> cards = new ArrayList<Card>();
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="pack",cascade=CascadeType.ALL)
	private Collection<Game> games = new ArrayList<Game>();

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getPreRemove() {
		return preRemove;
	}

	public void setPreRemove(int preRemove) {
		this.preRemove = preRemove;
	}

	public int getPostRemove() {
		return postRemove;
	}

	public void setPostRemove(int postRemove) {
		this.postRemove = postRemove;
	}

	public int getCurrIndex() {
		return currIndex;
	}

	public void setCurrIndex(int currIndex) {
		this.currIndex = currIndex;
	}

	public int getInitialCards() {
		return initialCards;
	}

	public void setInitialCards(int initialCards) {
		this.initialCards = initialCards;
	}

	public int getFinishedCards() {
		return finishedCards;
	}

	public void setFinishedCards(int finishedCards) {
		this.finishedCards = finishedCards;
	}

	public Collection<Card> getCards() {
		return cards;
	}

	public void setCards(Collection<Card> cards) {
		this.cards = cards;
	}

	public Collection<Game> getGames() {
		return games;
	}

	public void setGames(Collection<Game> games) {
		this.games = games;
	}
    
}
