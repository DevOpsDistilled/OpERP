package devopsdistilled.operp.server.data.entity.business;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import devopsdistilled.operp.server.data.entity.party.Customer;

@Entity
public class Sale extends Business {

	private static final long serialVersionUID = 581894269636553933L;

	@ManyToOne
	private Customer party;

	public Customer getParty() {
		return party;
	}

	public void setParty(Customer party) {
		this.party = party;
	}
}
