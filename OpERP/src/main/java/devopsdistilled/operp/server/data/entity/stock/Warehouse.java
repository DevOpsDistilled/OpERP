package devopsdistilled.operp.server.data.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Warehouse implements Serializable {
	private static final long serialVersionUID = 3048560317071734805L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long warehouseID;
	private String location;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}