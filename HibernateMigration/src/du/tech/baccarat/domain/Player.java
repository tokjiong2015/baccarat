package du.tech.baccarat.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
// STEP 1, define a table name within the database
// STEP 2, define the primary key, this is UD, do not use generated value
@Entity
@NamedQuery(name="player.creation",query="INSERT INTO player (playerName,initialFund) VALUES (?,?)")
@Table(name="PLAYER",schema="baccarat")
public class Player {
	
	@Id @Column(name="PLAYER_NAME", nullable=false, length=10)
	private String playerName;
	
	@Column(name="TOT_GAME")
	private int totalGame;
	
	@Column(name="TOT_WIN")
	private int totalWin;
	
	@Column(name="TOT_LOSE")
	private int totalLose;
	
	@Column(name="TOT_TIE")
	private int totalTie;
	
	@Column(name="STR_TENY")
	private String strategyTendency;
	
	@Column(name="STR_TENY_DESC",nullable=true,length=245)
	private String strategyTendencyDesc;
	
	@Column(name="INITIAL_FUND",precision=9, scale=6)
	private BigDecimal initialFund;
	
	@Column(name="CURR_FUND",precision=9, scale=6)
	private BigDecimal currFund;
	
	// NAME(FK) do need to be the same,but uspf needs(mapped)
	// referencedColumnName --> which column u want to point to, if did not define, will point to the id
	@ManyToOne
	@JoinColumn(name="USPF_NAME", referencedColumnName="USPF_NAME")
	private Uspf uspf;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "PLAYER_STRATEGY",
	joinColumns = {@JoinColumn(name = "PLAYER_NAME")},
	inverseJoinColumns = {@JoinColumn(name = "STR_NAME")})
	private Collection<Strategy> strategies = new ArrayList<Strategy>();
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "PLAYER_LBBY",
	joinColumns = {@JoinColumn(name = "PLAYER_NAME")},
	inverseJoinColumns = {@JoinColumn(name = "LBBY_UUID")})
	private Collection<Lbby> lbbys = new ArrayList<Lbby>();

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getTotalGame() {
		return totalGame;
	}

	public void setTotalGame(int totalGame) {
		this.totalGame = totalGame;
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

	public String getStrategyTendency() {
		return strategyTendency;
	}

	public void setStrategyTendency(String strategyTendency) {
		this.strategyTendency = strategyTendency;
	}

	public String getStrategyTendencyDesc() {
		return strategyTendencyDesc;
	}

	public void setStrategyTendencyDesc(String strategyTendencyDesc) {
		this.strategyTendencyDesc = strategyTendencyDesc;
	}

	public BigDecimal getInitialFund() {
		return initialFund;
	}

	public void setInitialFund(BigDecimal initialFund) {
		this.initialFund = initialFund;
	}

	public BigDecimal getCurrFund() {
		return currFund;
	}

	public void setCurrFund(BigDecimal currFund) {
		this.currFund = currFund;
	}

	public Uspf getUspf() {
		return uspf;
	}

	public void setUspf(Uspf uspf) {
		this.uspf = uspf;
	}

	public Collection<Strategy> getStrategies() {
		return strategies;
	}

	public void setStrategies(Collection<Strategy> strategies) {
		this.strategies = strategies;
	}

	public Collection<Lbby> getLbbys() {
		return lbbys;
	}

	public void setLbbys(Collection<Lbby> lbbys) {
		this.lbbys = lbbys;
	}
}
