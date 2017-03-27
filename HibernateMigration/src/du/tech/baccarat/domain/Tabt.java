package du.tech.baccarat.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
// STEP 1, define a table name within the database
// STEP 2, define the primary key, this is UD, do not use generated value
@Entity
@Table(name="TABT",schema="baccarat")
public class Tabt {
	
	@Id @GeneratedValue(generator="du-uuid")
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
	private String TabtName;
	
	@OneToMany(mappedBy="tabt",cascade=CascadeType.ALL)
	private Collection<Game> games = new ArrayList<Game>();

	@ManyToMany(mappedBy="tabts")
	private Collection<Lbby> lbbys = new ArrayList<Lbby>();
	
	public String getUuid() {
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

	public Collection<Lbby> getLbbys() {
		return lbbys;
	}

	public void setLbbys(Collection<Lbby> lbbys) {
		this.lbbys = lbbys;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getTabtName() {
		return TabtName;
	}

	public void setTabtName(String tabtName) {
		TabtName = tabtName;
	}
	
}
