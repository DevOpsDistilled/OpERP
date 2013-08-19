package devopsdistilled.operp.client.party.panes.controllers.impl;

import javax.inject.Inject;

import devopsdistilled.operp.client.party.models.CustomerModel;
import devopsdistilled.operp.client.party.panes.ListCustomerPane;
import devopsdistilled.operp.client.party.panes.controllers.ListCustomerPaneController;
import devopsdistilled.operp.client.party.panes.models.ListCustomerPaneModel;

public class ListCustomerPaneControllerImpl implements
		ListCustomerPaneController {

	@Inject
	private ListCustomerPane view;

	@Inject
	private ListCustomerPaneModel model;

	@Inject
	private CustomerModel customerModel;

	@Override
	public void init() {
		view.init();
		model.registerObserver(view);
		customerModel.registerObserver(view);
	}

}
