package org.du.tech.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;



/*@DiscriminatorColumn(
		name="VEHICLE_TYPE",
		discriminatorType=DiscriminatorType.STRING
)
*/

/*@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)*/
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Vehicle {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int vehicleId;
	
	private String vehicleName;
	
	@ManyToMany(mappedBy="vehicles")
	private Collection<UserDetails> users =new ArrayList<UserDetails>();
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public Collection<UserDetails> getUsers() {
		return users;
	}
	public void setUsers(Collection<UserDetails> users) {
		this.users = users;
	}
	
}
