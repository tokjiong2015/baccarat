package org.du.tech.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name="UserDetails.byId",query="from UserDetails where userId = ?")
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
@Table(name="USER_DETAILS")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	/*
	@ManyToMany(cascade=CascadeType.PERSIST)
	private Collection<Vehicle> vehicles =new ArrayList<Vehicle>();
	*/
	
	/*
	@OneToMany
	@JoinTable(joinColumns=@JoinColumn(name="USER_ID"),inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))
	private Collection<Vehicle> vehicleList = new ArrayList<Vehicle>();
	//fetch=FetchType.EAGER
	
	@ElementCollection
	@JoinTable(name="USER_ADDRESS",joinColumns= @JoinColumn(name="USER_ID"))
	@GenericGenerator(name = "h1", strategy = "sequence")
	@CollectionId(columns = { @Column(name="ADDRESS_IDD") }, generator = "h1", type = @Type(type="long"))
	private Collection<Address> listOfAddress = new ArrayList<Address>();
	
	@Temporal(TemporalType.DATE)
	private Date joinedDate;
	*/
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
