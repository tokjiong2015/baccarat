package du.tech.baccarat.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

// STEP 1, define a table name within the database
// STEP 2, define the primary key, this is UD, do not use generated value
// STEP 3, case insensitive
@Entity
@Table(name="STRATEGY",schema="baccarat")
public class Strategy {
	
	@Id @Column(name="STR_NAME", nullable=false, length=10)
	private String strategyName;
	
	@Column(name="STR_DESC", length=245)
	private String strategyDesc;
	
	@Column(name="EXP_REV_PER_GAME",precision=9, scale=6)
	private BigDecimal expRevPerGame;
	
	@Column(name="EXP_REV_PER_TABLE",precision=9, scale=6)
	private BigDecimal expRevPerTable;
	
	@Column(name="MAX_L_PER_GAME",precision=9, scale=6)
	private BigDecimal maxLossPerGame;
	
	@Column(name="MAX_L_PER_TABLE",precision=9, scale=6)
	private BigDecimal maxLossPerTable;
	
	@Column(name="TRI_CASE", nullable=true, length=3)
	private String triggerCase;
	
	@Column(name="END_CASE", nullable=true, length=3)
	private String endCase;

	@ManyToMany(mappedBy="strategies",cascade=CascadeType.ALL)
	private Collection<Player> players = new ArrayList<Player>();
	
	public String getStrategyName() {
		return strategyName;
	}

	public void setStrategyName(String strategyName) {
		this.strategyName = strategyName;
	}

	public BigDecimal getExpRevPerGame() {
		return expRevPerGame;
	}

	public void setExpRevPerGame(BigDecimal expRevPerGame) {
		this.expRevPerGame = expRevPerGame;
	}

	public BigDecimal getExpRevPerTable() {
		return expRevPerTable;
	}

	public void setExpRevPerTable(BigDecimal expRevPerTable) {
		this.expRevPerTable = expRevPerTable;
	}

	public BigDecimal getMaxLossPerGame() {
		return maxLossPerGame;
	}

	public void setMaxLossPerGame(BigDecimal maxLossPerGame) {
		this.maxLossPerGame = maxLossPerGame;
	}

	public BigDecimal getMaxLossPerTable() {
		return maxLossPerTable;
	}

	public void setMaxLossPerTable(BigDecimal maxLossPerTable) {
		this.maxLossPerTable = maxLossPerTable;
	}

	public String getTriggerCase() {
		return triggerCase;
	}

	public void setTriggerCase(String triggerCase) {
		this.triggerCase = triggerCase;
	}

	public String getEndCase() {
		return endCase;
	}

	public void setEndCase(String endCase) {
		this.endCase = endCase;
	}

	public String getStrategyDesc() {
		return strategyDesc;
	}

	public void setStrategyDesc(String strategyDesc) {
		this.strategyDesc = strategyDesc;
	}

	public Collection<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Collection<Player> players) {
		this.players = players;
	}
	
	
}
