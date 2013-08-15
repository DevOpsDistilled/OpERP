package devopsdistilled.operp.server.data.entity.party;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import devopsdistilled.operp.server.data.entity.Entiti;
import devopsdistilled.operp.server.data.entity.commons.ContactInfo;

@MappedSuperclass
public abstract class Party extends Entiti<Long> {

	private static final long serialVersionUID = 5183636412272320506L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long partyId;

	private String partyName;

	private String panVat;

	@OneToOne(cascade = CascadeType.ALL)
	private ContactInfo contactInfo;

	@Temporal(TemporalType.DATE)
	private Date registeredDate;

	public Long getPartyId() {
		return partyId;
	}

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}

	public String getPanVat() {
		return panVat;
	}

	public void setPanVat(String panVat) {
		this.panVat = panVat;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	@Override
	public Long id() {
		return getPartyId();
	}

	@Override
	public String toString() {
		return new String(getPartyId() + ": " + getPartyName());
	}
}
