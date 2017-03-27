package du.tech.baccarat.domain.tabt;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

import du.tech.baccarat.domain.player.Player;
import du.tech.baccarat.domain.game.Game;
import du.tech.baccarat.domain.lbby.Lbby;

@Entity
@Table(name="TABT",schema="baccarat")
public class Tabt {
	
	@Id 
	@GeneratedValue(generator="du-uuid")
	@GenericGenerator(name="du-uuid", strategy = "uuid")
	@Column(name="UUID")
	private String uuid;

	@Column(name="NO_PLAYERS")
	private int noOfPlayers;
	
	@Column(name="TOT_GAME")
	private int totalGame;
	
	@Column(name="TOT_IN",precision=9, scale=6)
	private BigDecimal totalIn;
	
	@Column(name="TOT_OUT",precision=9, scale=6)
	private BigDecimal totalOut;
	
	@Column(name="TOT_WIN")
	private int totalWin;
	
	@Column(name="TOT_LOSE")
	private int totalLose;
	
	@Column(name="TOT_TIE")
	private int totalTie;
	
	@Column(name="DEALER_NAME")
	private String dealerName;
	
	@Column(name="TABT_NAME")
	private String tabtName;
	
	//------------------------------------------Table Relationship-----------------------------------------------
	@OneToMany(mappedBy="tabt",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Collection<Game> games = new ArrayList<Game>();

	@ManyToMany(mappedBy="tabts",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Collection<Lbby> lbbys = new ArrayList<Lbby>();
	//------------------------------------------Getters and Setters------------------------------------------------
	public String getTabtUuid() {
		return uuid;
	}

	public int getNoOfPlayers() {
		return noOfPlayers;
	}

	public void setNoOfPlayers(int noOfPlayers) {
		this.noOfPlayers = noOfPlayers;
	}

	public int getTotalGame() {
		return totalGame;
	}

	public void setTotalGame(int totalGame) {
		this.totalGame = totalGame;
	}

	public BigDecimal getTotalIn() {
		return totalIn;
	}

	public void setTotalIn(BigDecimal totalIn) {
		this.totalIn = totalIn;
	}

	public BigDecimal getTotalOut() {
		return totalOut;
	}

	public void setTotalOut(BigDecimal totalOut) {
		this.totalOut = totalOut;
	}

	public int getTotalWin() {
		return totalWin;
	}

	public void setTotalWin(int totalWin) {
		this.totalWin = totalWin;
	}

	public int getTotalLose() {
		return totalLose;
	}

	public void setTotalLose(int totalLose) {
		this.totalLose = totalLose;
	}

	public int getTotalTie() {
		return totalTie;
	}

	public void setTotalTie(int totalTie) {
		this.totalTie = totalTie;
	}

	public Collection<Game> getGames() {
		return games;
	}

	public void setGames(Collection<Game> games) {
		this.games = games;
	}
	
	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public Collection<Lbby> getLbbys() {
		return lbbys;
	}

	public void setLbbys(Collection<Lbby> lbbys) {
		this.lbbys = lbbys;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getTabtName() {
		return tabtName;
	}

	public void setTabtName(String tabtName) {
		this.tabtName = tabtName;
	}
}
