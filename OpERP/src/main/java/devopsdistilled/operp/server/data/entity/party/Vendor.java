package devopsdistilled.operp.server.data.entity.party;

import javax.persistence.Entity;

@Entity
public class Vendor extends Party {

	private static final long serialVersionUID = 1438740246885453097L;

	public Long getVendorId() {
		return getPartyId();
	}

	public String getVendorName() {
		return getPartyName();
	}

}
