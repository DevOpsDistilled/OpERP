package devopsdistilled.operp.server.data.entity.items;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Manufacturer implements Serializable {

	private static final long serialVersionUID = 3771480832066400289L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long manufacturerId;

	private String manufactuerName;

	@OneToMany(mappedBy = "manufacturer")
	private List<Brand> brands;

	public Long getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(Long manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getManufactuerName() {
		return manufactuerName;
	}

	public void setManufactuerName(String manufactuerName) {
		this.manufactuerName = manufactuerName;
	}

	public List<Brand> getBrands() {
		return brands;
	}

	public void setBrands(List<Brand> brands) {
		this.brands = brands;
	}
}
