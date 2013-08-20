package devopsdistilled.operp.server.data.entity.business;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import devopsdistilled.operp.server.data.entity.party.Vendor;

@Entity
public class Purchase extends Business {

	private static final long serialVersionUID = 4680542154771058958L;

	@ManyToOne
	private Vendor party;

	public Vendor getParty() {
		return party;
	}

	public void setParty(Vendor party) {
		this.party = party;
	}
}
