package devopsdistilled.operp.server.data.entity.business;

import javax.persistence.Entity;

import devopsdistilled.operp.server.data.entity.party.Customer;

@Entity
public class Sale extends Business<Customer, SaleDesc> {

	private static final long serialVersionUID = 581894269636553933L;

}
