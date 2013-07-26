package devopsdistilled.operp.server.data.entity.stock;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import devopsdistilled.operp.server.data.entity.Entiti;

@Entity
public class Warehouse extends Entiti implements Serializable {
	private static final long serialVersionUID = 3048560317071734805L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long warehouseID;
	private String name;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}