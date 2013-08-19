package devopsdistilled.operp.client.party.models;

import devopsdistilled.operp.client.abstracts.EntityModel;
import devopsdistilled.operp.client.party.models.observers.CustomerModelObserver;
import devopsdistilled.operp.server.data.entity.party.Customer;
import devopsdistilled.operp.server.data.service.party.CustomerService;

public interface CustomerModel extends
		EntityModel<Customer, CustomerService, CustomerModelObserver> {

}
