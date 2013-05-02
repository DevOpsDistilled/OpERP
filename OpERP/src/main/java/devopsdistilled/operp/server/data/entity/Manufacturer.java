package devopsdistilled.operp.server.data.entity;

import java.io.Serializable;
import java.util.Set;

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
	private String manufacturerName;

	@OneToMany(mappedBy = "manufacturer")
	private Set<Brand> brands;

	public Long getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(Long manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public Set<Brand> getBrands() {
		return brands;
	}

	public void setBrands(Set<Brand> brands) {
		this.brands = brands;
	}
}
