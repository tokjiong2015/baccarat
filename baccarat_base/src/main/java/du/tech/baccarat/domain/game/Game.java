package du.tech.baccarat.domain.game;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import du.tech.baccarat.domain.pack.Pack;
import du.tech.baccarat.domain.tabt.Tabt;



@Entity
@Table(name="GAME",schema="baccarat")
public class Game {
	
    @EmbeddedId
    @Basic(fetch=FetchType.LAZY)
    private GameKey gameKey;
    
    @Temporal(TemporalType.TIME)
    @Column(name = "LUP_TIME")
    private Date lup_time;
    
	@Column(name="NO_PLAYERS")
	private int noOfPlayers;
    
	@Column(name="P_AMT",precision=9, scale=6)
	private BigDecimal pamt;
	
	@Column(name="B_AMT",precision=9, scale=6)
	private BigDecimal bamt;
	
	@Column(name="T_AMT",precision=9, scale=6)
	private BigDecimal tamt;
    
	@Column(name="RESULT", nullable=true, length=2)
	private String result;
	
	@Column(name="TOT_IN",precision=9, scale=6)
	private BigDecimal totalIn;
	
	@Column(name="TOT_OUT",precision=9, scale=6)
	private BigDecimal totalOut;
    
	@Column(name="IN_ROW", nullable=true, length=2)
	private String inRow;
	
	@Column(name="STR_DESC",nullable=true,length=245)
	private String strDesc;
    
	@Column(name="RESULT_DESC",nullable=true,length=245)
	private String resultDesc;
    
	//------------------------------------------Table Relationship-----------------------------------------------
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="TABT_UUID")
	private Tabt tabt;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PACK_UUID", referencedColumnName="UUID", insertable = false, updatable = false)
	private Pack pack;
	//------------------------------------------Getters and Setters------------------------------------------------
	public GameKey getGameKey() {
		return gameKey;
	}

	public void setGameKey(GameKey gameKey) {
		this.gameKey = gameKey;
	}

	public Date getLup_time() {
		return lup_time;
	}

	public void setLup_time(Date lup_time) {
		this.lup_time = lup_time;
	}

	public int getNoOfPlayers() {
		return noOfPlayers;
	}

	public void setNoOfPlayers(int noOfPlayers) {
		this.noOfPlayers = noOfPlayers;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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

	public String getInRow() {
		return inRow;
	}

	public void setInRow(String inRow) {
		this.inRow = inRow;
	}

	public String getStrDesc() {
		return strDesc;
	}

	public void setStrDesc(String strDesc) {
		this.strDesc = strDesc;
	}

	public String getResultDesc() {
		return resultDesc;
	}

	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}

	public Tabt getTabt() {
		return tabt;
	}

	public void setTabt(Tabt tabt) {
		this.tabt = tabt;
	}

	public BigDecimal getPamt() {
		return pamt;
	}

	public void setPamt(BigDecimal pamt) {
		this.pamt = pamt;
	}

	public BigDecimal getBamt() {
		return bamt;
	}

	public void setBamt(BigDecimal bamt) {
		this.bamt = bamt;
	}

	public BigDecimal getTamt() {
		return tamt;
	}

	public void setTamt(BigDecimal tamt) {
		this.tamt = tamt;
	}

	public Pack getPack() {
		return pack;
	}

	public void setPack(Pack pack) {
		this.pack = pack;
	}
    
	
}
