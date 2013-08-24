package devopsdistilled.operp.client.party.models.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.AbstractEntityModel;
import devopsdistilled.operp.client.party.models.CustomerModel;
import devopsdistilled.operp.client.party.models.observers.CustomerModelObserver;
import devopsdistilled.operp.server.data.entity.party.Customer;
import devopsdistilled.operp.server.data.service.party.CustomerService;

public class CustomerModelImpl extends
		AbstractEntityModel<Customer, CustomerService, CustomerModelObserver>
		implements CustomerModel {

	@Inject
	private CustomerService service;

	@Override
	public CustomerService getService() {
		return service;
	}

}
