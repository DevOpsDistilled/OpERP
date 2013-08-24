package devopsdistilled.operp.client.party.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.abstracts.EntityOperation;
import devopsdistilled.operp.client.party.controllers.CustomerController;
import devopsdistilled.operp.client.party.models.CustomerModel;
import devopsdistilled.operp.client.party.panes.controllers.CustomerPaneController;
import devopsdistilled.operp.client.party.panes.controllers.ListCustomerPaneController;
import devopsdistilled.operp.server.data.entity.party.Customer;

public class CustomerControllerImpl implements CustomerController {

	@Inject
	private CustomerPaneController customerPaneController;

	@Inject
	private CustomerModel customerModel;

	@Inject
	private ListCustomerPaneController listCustomerPaneController;

	@Override
	public void create() {
		customerPaneController.init(new Customer(), EntityOperation.Create);
	}

	@Override
	public void edit(Customer customer) {
		customerPaneController.init(customer, EntityOperation.Edit);
	}

	@Override
	public void list() {
		listCustomerPaneController.init();
	}

	@Override
	public void delete(Customer customer) {
		customerModel.deleteAndUpdateModel(customer);
	}

	@Override
	public void showDetails(Customer customer) {
		customerPaneController.init(customer, EntityOperation.Details);
	}

}
