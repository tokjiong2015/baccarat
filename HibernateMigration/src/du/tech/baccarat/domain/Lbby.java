package du.tech.baccarat.domain;

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
// STEP 1, define a table name within the database
// STEP 2, define the primary key, this is UD, do not use generated value
// STEP 3, define the One-To-Many relationship
// STEP 4, define the Many-To-Many relationship
@Entity
@Table(name="LBBY",schema="baccarat")
public class Lbby {
	
	@Id @GeneratedValue(generator="du-uuid")
	@GenericGenerator(name="du-uuid", strategy = "uuid")
	@Column(name="UUID")
	private String uuid;
	
	@Column(name="CASINO_NAME",nullable=true,length=45)
	private String casinoName;
	
	@Column(name="CASINO_DESC",nullable=true,length=245)
	private String casinoDesc;
	
	@ManyToMany(mappedBy="lbbys")
	private Collection<Player> players = new ArrayList<Player>();

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "LBBY_TABT",
	joinColumns = {@JoinColumn(name = "LBBY_UUID")},
	inverseJoinColumns = {@JoinColumn(name = "TABT_UUID")})
	private Collection<Tabt> tabts = new ArrayList<Tabt>();
	
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

}
