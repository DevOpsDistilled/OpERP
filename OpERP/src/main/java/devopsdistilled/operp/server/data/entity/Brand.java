package devopsdistilled.operp.server.data.entity;

import javax.persistence.Entity;

@Entity
public class Brand {
	private Brand brandID;
	private String brandName;
	private Manufacturer manufacturer;
}
