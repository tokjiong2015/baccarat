package du.tech.baccarat.domain.uspf;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import du.tech.baccarat.domain.player.Player;


@Entity
@NamedQuery(name="User.login",query="from Uspf where userName = ? and passWord = ?")
@Table(name="USPF",schema="baccarat")
public class Uspf {
	
	@Id 
	@Column(name="USPF_NAME", nullable=false, length=20)
	private String userName;

	@Column(name="PASSWORD", nullable=false, length=255)
	private String passWord;

	@Column(name="USER_EMAIL",nullable=false,length=50)
	private String userEmail;

	@Column(name="STR_TENY")
	private int strategyTendency;

	@Column(name="STR_TENY_DESC",nullable=true,length=245)
	private String strategyTendencyDesc;

	@Column(name="WARN_IND",nullable=true,length=1)
	private String warnInd;

	@Column(name="TOT_GAME")
	private int totalGame;

	@Column(name="TOT_WIN")
	private int totalWin;

	@Column(name="TOT_LOSE")
	private int totalLose;

	@Column(name="TOT_TIE")
	private int totalTie;
	
	//------------------------------------------Table Relationship-----------------------------------------------
	@OneToMany(fetch=FetchType.LAZY,mappedBy="uspf",cascade=CascadeType.ALL)
	private Collection<Player> player = new ArrayList<Player>();
	
	//------------------------------------------Getters and Setters------------------------------------------------
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getStrategyTendency() {
		return strategyTendency;
	}

	public void setStrategyTendency(int strategyTendency) {
		this.strategyTendency = strategyTendency;
	}

	public String getStrategyTendencyDesc() {
		return strategyTendencyDesc;
	}

	public void setStrategyTendencyDesc(String strategyTendencyDesc) {
		this.strategyTendencyDesc = strategyTendencyDesc;
	}

	public String getWarnInd() {
		return warnInd;
	}

	public void setWarnInd(String warnInd) {
		this.warnInd = warnInd;
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

	public Collection<Player> getPlayer() {
		return player;
	}

	public void setPlayer(Collection<Player> player) {
		this.player = player;
	}
	
}
