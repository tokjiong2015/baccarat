package du.tech.baccarat.domain.card;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import du.tech.baccarat.domain.pack.Pack;


@Entity
@Table(name="Card",schema="baccarat")
public class Card {
	
    @EmbeddedId
    private CardKey cardKey;
    
    @Temporal(TemporalType.TIME)
    @Column(name = "LUP_TIME")
    private Date lup_time;
	
	@ManyToOne
	@JoinColumn(name="UUID", referencedColumnName="UUID")
	private Pack pack;
    
	public Card(CardKey cardKey) {
		super();
		this.cardKey = cardKey;
	}

	public CardKey getCardKey() {
		return cardKey;
	}

	public void setCardKey(CardKey cardKey) {
		this.cardKey = cardKey;
	}
	
	public Date getLup_time() {
		return lup_time;
	}

	public void setLup_time(Date lup_time) {
		this.lup_time = lup_time;
	}

	public Pack getPack() {
		return pack;
	}

	public void setPack(Pack pack) {
		this.pack = pack;
	}
}
