package devopsdistilled.operp.server.data.entity.items;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Brand implements Serializable {

	private static final long serialVersionUID = -8725499929433349001L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long brandID;
	private String brandName;
	
	@ManyToOne
	private Manufacturer manufacturer;

	public Long getBrandID() {
		return brandID;
	}

	public void setBrandID(Long brandID) {
		this.brandID = brandID;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
}
