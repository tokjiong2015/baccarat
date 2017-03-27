package du.tech.baccarat.domain.lbby;

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
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import du.tech.baccarat.domain.player.Player;
import du.tech.baccarat.domain.tabt.Tabt;

@Entity
@Table(name="LBBY",schema="baccarat")
public class Lbby {
	
	@Id
	@GeneratedValue(generator="du-uuid")
	@GenericGenerator(name="du-uuid", strategy = "uuid")
	@Column(name="UUID")
	private String uuid;
	
	@Column(name="CASINO_NAME",nullable=true,length=45)
	private String casinoName;
	
	@Column(name="CASINO_DESC",nullable=true,length=245)
	private String casinoDesc;
	
	//------------------------------------------Table Relationship-----------------------------------------------
	@ManyToMany(mappedBy="lbbys")
	private Collection<Player> players = new ArrayList<Player>();

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "LBBY_TABT",
	joinColumns = {@JoinColumn(name = "LBBY_UUID")},
	inverseJoinColumns = {@JoinColumn(name = "TABT_UUID")})
	private Collection<Tabt> tabts = new ArrayList<Tabt>();
	
	//------------------------------------------Getters and Setters------------------------------------------------
	public String getCasinoName() {
		return casinoName;
	}

	public void setCasinoName(String casinoName) {
		this.casinoName = casinoName;
	}

	public String getCasinoDesc() {
		return casinoDesc;
	}

	public void setCasinoDesc(String casinoDesc) {
		this.casinoDesc = casinoDesc;
	}
	
	public Collection<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Collection<Player> players) {
		this.players = players;
	}

	public Collection<Tabt> getTabts() {
		return tabts;
	}

	public void setTabts(Collection<Tabt> tabts) {
		this.tabts = tabts;
	}

	//about uuid
	public String getLbbyUuid() {
		return uuid;
	}

	public void setUuid(String lbbyUuid) {
		this.uuid = lbbyUuid;
	}

	public String getUuid() {
		return uuid;
	}
	
}
