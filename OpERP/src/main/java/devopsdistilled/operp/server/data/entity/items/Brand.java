package devopsdistilled.operp.server.data.entity.items;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import devopsdistilled.operp.server.data.entity.Entiti;

@Entity
public class Brand extends Entiti {

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

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public Long getId() {
		return getBrandID();
	}
}
