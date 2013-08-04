package devopsdistilled.operp.server.data.entity.items;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import devopsdistilled.operp.server.data.entity.Entiti;

@Entity
public class Manufacturer extends Entiti<Long> {

	private static final long serialVersionUID = 3771480832066400289L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long manufacturerId;

	private String manufacturerName;

	@OneToMany(mappedBy = "manufacturer")
	private List<Brand> brands;

	public Long getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(Long manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufactuerName) {
		this.manufacturerName = manufactuerName;
	}

	public List<Brand> getBrands() {
		return brands;
	}

	public void setBrands(List<Brand> brands) {
		this.brands = brands;
	}

	@Override
	public Long id() {
		return getManufacturerId();
	}
}
