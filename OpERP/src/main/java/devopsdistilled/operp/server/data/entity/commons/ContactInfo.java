package devopsdistilled.operp.server.data.entity.commons;

import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToOne;

import devopsdistilled.operp.server.data.entity.Entiti;

@Entity
public class ContactInfo extends Entiti<Long> {

	private static final long serialVersionUID = 2729474004283929872L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long contactId;

	@OneToOne
	private Address address;

	private String email;

	@ElementCollection
	@CollectionTable(name = "PhoneNumber")
	@MapKeyEnumerated(EnumType.STRING)
	@MapKeyColumn(name = "phoneType")
	@Column(name = "phoneNumber")
	private Map<PhoneType, String> phoneNumbers;

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Map<PhoneType, String> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(Map<PhoneType, String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	@Override
	public Long id() {
		return getContactId();
	}

	@Override
	public String toString() {
		StringBuilder contactInfo = new StringBuilder();
		contactInfo.append("Email: " + getEmail());
		contactInfo.append(System.lineSeparator());
		contactInfo.append("Phone Numbers");
		contactInfo.append(System.lineSeparator());
		for (Entry<PhoneType, String> number : getPhoneNumbers().entrySet()) {
			contactInfo.append("\t" + number.getKey() + ": "
					+ number.getValue());
			contactInfo.append(System.lineSeparator());
		}
		contactInfo.append("Address");
		contactInfo.append(System.lineSeparator());
		contactInfo.append(getAddress());
		return contactInfo.toString();
	}
}
