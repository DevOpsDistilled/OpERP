package devopsdistilled.operp.server.data.entity.commons;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import devopsdistilled.operp.server.data.entity.Entiti;

@Entity
public class Address extends Entiti<Long> {

	private static final long serialVersionUID = -7373506476406558225L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long addressId;

	private String country;
	private String zone;
	private String district;
	private String city;
	private String street;

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public Long id() {
		return getAddressId();
	}

	@Override
	public String toString() {
		StringBuilder address = new StringBuilder();
		address.append(getStreet() + ", " + getCity());
		address.append(System.lineSeparator());
		address.append(getDistrict() + ", " + getZone());
		address.append(System.lineSeparator());
		address.append(getCountry());
		return address.toString();
	}

}
