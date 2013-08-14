package devopsdistilled.operp.server.data.entity.party;

import java.util.Date;

import javax.persistence.MappedSuperclass;

import devopsdistilled.operp.server.data.entity.Entiti;

@MappedSuperclass
public abstract class Party extends Entiti<Long> {

	private static final long serialVersionUID = 5183636412272320506L;

	private Long partyId;

	private String partyName;

	private Date registerdDate;

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

	public Date getRegisterdDate() {
		return registerdDate;
	}

	public void setRegisterdDate(Date registerdDate) {
		this.registerdDate = registerdDate;
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
