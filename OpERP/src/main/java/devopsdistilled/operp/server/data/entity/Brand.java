package devopsdistilled.operp.server.data.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Brand implements Serializable{
	@Id
	private Long brandID;
	private String brandName;
	@ManyToOne
	private Manufacturer manufacturer;
}
